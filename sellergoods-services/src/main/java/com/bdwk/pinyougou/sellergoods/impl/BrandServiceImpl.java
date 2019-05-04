package com.bdwk.pinyougou.sellergoods.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bdwk.pinyougou.common.enums.ResultEnum;
import com.bdwk.pinyougou.common.http.R;
import com.bdwk.pinyougou.dao.mapper.TbBrandMapper;
import com.bdwk.pinyougou.entity.pojo.TbBrand;
import com.bdwk.pinyougou.sellergoods.service.IBrandService;
import com.google.common.base.Strings;
import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.Map;

@Service(protocol = {"dubbo"},validation = "true",version ="1.0.0",timeout = 3000)
@Slf4j
public class BrandServiceImpl extends ServiceImpl<TbBrandMapper,TbBrand> implements IBrandService {

    @Override
    public R<List<TbBrand>> selectAll() {
        Wrapper<TbBrand> wrapper=new QueryWrapper<>();
        List<TbBrand> list=this.baseMapper.selectList(wrapper);
        return R.create(list);
    }

    @Override
    public R<List<Map>> select2list() {
        List<Map> maps=this.baseMapper.select2list();
        return R.create(maps);
    }

    @Override
    public R<IPage<TbBrand>> page(Long page,Long rows) {
        IPage<TbBrand> page1 = super.page(new Page<>(page, rows));
        return R.create(page1);
    }

    @Override
    public R<IPage<TbBrand>> page(Long page,Long rows,TbBrand tbBrand) {
        Page<TbBrand> pageParam = new Page<>(page, rows);
        if(null==tbBrand){
            return R.create(super.page(pageParam));
        }else {
            QueryWrapper<TbBrand> wrapper=new QueryWrapper<TbBrand>();
            if(!Strings.isNullOrEmpty(tbBrand.getName())){
                wrapper.lambda().like(TbBrand::getName,tbBrand.getName());
            }
            if(!Strings.isNullOrEmpty(tbBrand.getFirstChar())){
                wrapper.lambda().like(TbBrand::getFirstChar,tbBrand.getFirstChar());
            }
            return R.create(super.page(pageParam,wrapper));
        }
    }
    @Override
    public R add(TbBrand tbBrand) {
        if(Strings.isNullOrEmpty(tbBrand.getFirstChar())
            || tbBrand.getFirstChar().length()>1
            ){
            return R.create(ResultEnum.BRAND_FIRSTCHAR_TOOLONG);
        }
        return super.save(tbBrand)?R.addSuccess():R.addFailed();
    }

    @Override
    public R update(TbBrand tbBrand) {
        if(Strings.isNullOrEmpty(tbBrand.getFirstChar())
                || tbBrand.getFirstChar().length()>1
        ){
            return R.create(ResultEnum.BRAND_FIRSTCHAR_TOOLONG);
        }
        return super.updateById(tbBrand)?R.updateSuccess():R.updateFailed();
    }
}
