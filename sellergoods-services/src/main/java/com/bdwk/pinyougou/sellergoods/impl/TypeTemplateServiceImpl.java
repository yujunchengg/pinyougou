package com.bdwk.pinyougou.sellergoods.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.bdwk.pinyougou.mapper.TbTypeTemplateMapper;
import com.bdwk.pinyougou.pojo.TbTypeTemplate;
import com.bdwk.pinyougou.sellergoods.service.ITypeTemplateService;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Service(protocol = {"dubbo"},validation = "true",version ="1.0.0",timeout = 3000)
@Slf4j
public class TypeTemplateServiceImpl extends ServiceImpl<TbTypeTemplateMapper, TbTypeTemplate> implements ITypeTemplateService {
    @Override
    public List<TbTypeTemplate> findAll() {
        Wrapper<TbTypeTemplate> wrapper=new EntityWrapper<>();
        return this.baseMapper.selectList(wrapper);
    }
}
