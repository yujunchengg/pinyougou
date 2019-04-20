package com.bdwk.pinyougou.sellergoods.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.bdwk.pinyougou.mapper.TbSpecificationOptionMapper;
import com.bdwk.pinyougou.pojo.TbSpecificationOption;
import com.bdwk.pinyougou.sellergoods.service.ISpecificationOptionService;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Service(protocol = {"dubbo"},validation = "true",version ="1.0.0",timeout = 3000)
@Slf4j
public class SpecificationOptionServiceImpl extends ServiceImpl<TbSpecificationOptionMapper, TbSpecificationOption> implements ISpecificationOptionService {
    @Override
    public List<TbSpecificationOption> findAll() {
        Wrapper<TbSpecificationOption> wrapper=new EntityWrapper<>();
        return this.baseMapper.selectList(wrapper);
    }
}
