package com.bdwk.pinyougou.sellergoods.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bdwk.pinyougou.common.http.R;
import com.bdwk.pinyougou.dao.mapper.TbItemCatMapper;
import com.bdwk.pinyougou.entity.pojo.TbItemCat;
import com.bdwk.pinyougou.sellergoods.service.IItemCatService;
import com.bdwk.pinyougou.entity.vo.TbItemCatVo;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * 商品分类接口实现
 */
@Service(protocol = {"dubbo"},validation = "true",version ="1.0.0",timeout = 3000)
@Slf4j
public class ItemCatServiceImpl extends ServiceImpl<TbItemCatMapper, TbItemCat> implements IItemCatService {

    @Override
    public R<Page<TbItemCatVo>> page(Long page, Long rows, Long parentId, String name) {
        Page<TbItemCatVo> pageParam=new Page<>(page,rows);
        //自定义分页
        List<TbItemCatVo> records=this.baseMapper.selectPage(pageParam,parentId,name);
        pageParam.setRecords(records);
        return R.create(pageParam);
    }

    @Override
    public R deleteByIds(List<Long> ids) {
        //删除子集
        QueryWrapper<TbItemCat> wrapper=new QueryWrapper<>();
        wrapper.lambda().in(TbItemCat::getParentId,ids);
        boolean f1=super.remove(wrapper);
        //删除自身
        boolean f2=super.removeByIds(ids);
        return f1 && f2 ?R.deleteSuccess():R.deleteFailed();
    }
}
