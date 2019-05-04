package com.bdwk.pinyougou.sellergoods.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bdwk.pinyougou.common.http.R;
import com.bdwk.pinyougou.dao.mapper.TbTypeTemplateMapper;
import com.bdwk.pinyougou.entity.pojo.TbTypeTemplate;
import com.bdwk.pinyougou.sellergoods.service.ITypeTemplateService;
import com.google.common.base.Strings;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

@Service(protocol = {"dubbo"},validation = "true",version ="1.0.0",timeout = 3000)
@Slf4j
public class TypeTemplateServiceImpl extends ServiceImpl<TbTypeTemplateMapper, TbTypeTemplate> implements ITypeTemplateService {
    @Override
    public R<List<TbTypeTemplate>> selectAll() {
        Wrapper<TbTypeTemplate> wrapper=new QueryWrapper<>();
        return R.create(this.baseMapper.selectList(wrapper));
    }

    @Override
    public R<List<Map>> select2List() {
        return R.create(this.baseMapper.select2List());
    }

    @Override
    public R<IPage<TbTypeTemplate>> page(Long page,Long rows,TbTypeTemplate tbTypeTemplate) {
        Page<TbTypeTemplate> pageParam = new Page<>(page, rows);
        if(null==tbTypeTemplate){
            return R.create(super.page(pageParam));
        }else {
            QueryWrapper<TbTypeTemplate> wrapper=new QueryWrapper<>();
            if(!Strings.isNullOrEmpty(tbTypeTemplate.getName())){
                wrapper.lambda().like(TbTypeTemplate::getName,tbTypeTemplate.getName());
            }
            return R.create(super.page(pageParam,wrapper));
        }
    }

    @Override
    public R<IPage<TbTypeTemplate>> page(Long page, Long rows) {
        return R.create(super.page(new Page<>(page,rows)));
    }
}
