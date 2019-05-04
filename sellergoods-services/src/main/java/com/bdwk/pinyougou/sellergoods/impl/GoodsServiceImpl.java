package com.bdwk.pinyougou.sellergoods.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bdwk.pinyougou.common.enums.ResultEnum;
import com.bdwk.pinyougou.common.http.R;
import com.bdwk.pinyougou.common.util.Checker;
import com.bdwk.pinyougou.entity.dto.GoodsDto;
import com.bdwk.pinyougou.dao.mapper.*;
import com.bdwk.pinyougou.entity.pojo.TbGoods;
import com.bdwk.pinyougou.sellergoods.service.IGoodsService;
import com.bdwk.pinyougou.entity.vo.GoodsSelect2Vo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Map;

@Service(protocol = {"dubbo"},validation = "true",version ="1.0.0",timeout = 3000)
@Slf4j
public class GoodsServiceImpl extends ServiceImpl<TbGoodsMapper, TbGoods> implements IGoodsService {

    @Autowired
    private TbGoodsDescMapper tbGoodsDescMapper;
    @Autowired
    private TbItemCatMapper tbItemCatMapper;
    @Autowired
    private TbTypeTemplateMapper tbTypeTemplateMapper;
    @Autowired
    private TbBrandMapper tbBrandMapper;

    @Override
    public R add(GoodsDto goodsDto, String authedId) {
        //判断是否是认证过的用户
        if(Checker.isBlank(authedId)){
            return R.create(ResultEnum.FORBIDDEN);
        }
        //判断2个具体实体是否为null
        if(Checker.isNull(goodsDto) || Checker.isNull(goodsDto.getGoods(),goodsDto.getGoodsDesc())){
            return R.create(ResultEnum.PARAM_IS_BLANK);
        }
        //设置seller_id
        goodsDto.getGoods().setSellerId(authedId);
        //插入商品基本信息
        int f1=this.baseMapper.insert(goodsDto.getGoods());
        if(f1<=0){
            return R.addSuccess();
        }
        //插入已生成的商品的主键
        goodsDto.getGoodsDesc().setGoodsId(goodsDto.getGoods().getId());
        //插入商品详细信息
        int f2=tbGoodsDescMapper.insert(goodsDto.getGoodsDesc());

        return f1>0 && f2>0 ?R.addSuccess():R.addFailed();
    }

    @Override
    public R<GoodsSelect2Vo> select2(Integer lv, Long parentId) {
        if(null==lv || lv<=0 || null==parentId || parentId<0){
            return R.create(ResultEnum.PARAM_IS_INVALID);
        }
        GoodsSelect2Vo goodsSelect2Vo=new GoodsSelect2Vo();
        List<Map> list=tbItemCatMapper.select2(parentId);
        if(lv==1){
            goodsSelect2Vo.setLevel1List(list);
            List<Map> tempList = tbTypeTemplateMapper.select2List();
            goodsSelect2Vo.setTempList(tempList);
            List<Map> brandList=tbBrandMapper.select2list();
            goodsSelect2Vo.setBrandList(brandList);
        }
        if(lv==2){
            goodsSelect2Vo.setLevel2List(list);
        }
        if(lv==3){
            goodsSelect2Vo.setLevel3List(list);
        }
        return R.create(goodsSelect2Vo);
    }
}
