package com.bdwk.pinyougou.sellergoods.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bdwk.pinyougou.common.http.R;
import com.bdwk.pinyougou.dao.mapper.TbSpecificationOptionMapper;
import com.bdwk.pinyougou.entity.pojo.TbSpecificationOption;
import com.bdwk.pinyougou.sellergoods.service.ISpecificationOptionService;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Service(protocol = {"dubbo"},validation = "true",version ="1.0.0",timeout = 3000)
@Slf4j
public class SpecificationOptionServiceImpl extends ServiceImpl<TbSpecificationOptionMapper, TbSpecificationOption> implements ISpecificationOptionService {
    @Override
    public R<List<TbSpecificationOption>> selectAll() {
        Wrapper<TbSpecificationOption> wrapper=new QueryWrapper<>();
        return R.create(this.baseMapper.selectList(wrapper));
    }
}
