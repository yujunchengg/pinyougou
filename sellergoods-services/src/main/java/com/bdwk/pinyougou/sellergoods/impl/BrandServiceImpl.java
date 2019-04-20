package com.bdwk.pinyougou.sellergoods.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.bdwk.pinyougou.mapper.TbBrandMapper;
import com.bdwk.pinyougou.pojo.TbBrand;
import com.bdwk.pinyougou.sellergoods.service.IBrandService;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service(protocol = {"dubbo"},validation = "true",version ="1.0.0",timeout = 3000)
@Slf4j
public class BrandServiceImpl extends ServiceImpl<TbBrandMapper,TbBrand> implements IBrandService {
    @Override
    public List<TbBrand> findAll() {
        Wrapper<TbBrand> wrapper=new EntityWrapper<>();
        return this.baseMapper.selectList(wrapper);
    }

    @Override
    public List<Map> select2list() {
        return this.baseMapper.select2list();
    }
}
