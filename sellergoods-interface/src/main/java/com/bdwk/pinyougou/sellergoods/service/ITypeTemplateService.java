package com.bdwk.pinyougou.sellergoods.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bdwk.pinyougou.common.http.R;
import com.bdwk.pinyougou.entity.pojo.TbTypeTemplate;

import java.util.List;
import java.util.Map;

/**
 * 模板业务接口
 */
public interface ITypeTemplateService extends IService<TbTypeTemplate> {

    R<List<TbTypeTemplate>> selectAll();

    R<List<Map>> select2List();

    /**
     * 分页查询
     * @param page
     * @param rows
     * @param tbTypeTemplate
     * @return
     */
    R<IPage<TbTypeTemplate>> page(Long page,Long rows,TbTypeTemplate tbTypeTemplate);

    R<IPage<TbTypeTemplate>> page(Long page,Long rows);
}
