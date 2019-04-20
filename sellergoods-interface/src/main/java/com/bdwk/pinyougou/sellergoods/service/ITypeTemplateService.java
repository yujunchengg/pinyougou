package com.bdwk.pinyougou.sellergoods.service;

import com.baomidou.mybatisplus.service.IService;
import com.bdwk.pinyougou.pojo.TbTypeTemplate;

import java.util.List;

/**
 * 模板业务接口
 */
public interface ITypeTemplateService extends IService<TbTypeTemplate> {
    List<TbTypeTemplate> findAll();
}
