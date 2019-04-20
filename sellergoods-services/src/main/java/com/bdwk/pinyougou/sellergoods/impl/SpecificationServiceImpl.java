package com.bdwk.pinyougou.sellergoods.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.bdwk.pinyougou.mapper.TbSpecificationMapper;
import com.bdwk.pinyougou.mapper.TbSpecificationOptionMapper;
import com.bdwk.pinyougou.pojo.TbSpecification;
import com.bdwk.pinyougou.pojo.TbSpecificationOption;
import com.bdwk.pinyougou.sellergoods.service.ISpecificationService;
import com.google.common.base.Strings;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service(protocol = {"dubbo"},validation = "true",version ="1.0.0",timeout = 3000)
@Slf4j
public class SpecificationServiceImpl extends ServiceImpl<TbSpecificationMapper, TbSpecification> implements ISpecificationService {
    @Autowired
    private TbSpecificationOptionMapper tbSpecificationOptionMapper;

    @Override
    public List<TbSpecification> findAll() {
        Wrapper<TbSpecification> wrapper=new EntityWrapper<>();
        return this.baseMapper.selectList(wrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addOne2Many(TbSpecification specification, List<TbSpecificationOption> specificationOptions) {
        if(null==specification || Strings.isNullOrEmpty(specification.getSpecName())){
            return false;
        }
        //添加规格
        Integer insert = this.baseMapper.insert(specification);
        //若有规格详情则添加规格详情,没有则只添加规格
        if(CollectionUtil.isNotEmpty(specificationOptions)){
            specificationOptions.stream().forEach((e)->{
                e.setSpecId(specification.getId());
                tbSpecificationOptionMapper.insert(e);
            });
            return true;
        }
        return insert>0;
    }

    @Override
    public List<Map> select2list() {
        return this.baseMapper.select2list();
    }
}
