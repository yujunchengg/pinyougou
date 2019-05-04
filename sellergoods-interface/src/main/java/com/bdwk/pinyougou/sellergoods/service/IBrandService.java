package com.bdwk.pinyougou.sellergoods.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bdwk.pinyougou.common.http.R;
import com.bdwk.pinyougou.entity.pojo.TbBrand;

import java.util.List;
import java.util.Map;

/**
 * 品牌业务接口
 */
public interface IBrandService extends IService<TbBrand> {

    R<List<TbBrand>> selectAll();

    /**
     * 查询select2格式的数据
     * @return
     */
    R<List<Map>> select2list();

    /**
     * 分页查询
     * @param page
     * @param rows
     * @return
     */
    R<IPage<TbBrand>> page(Long page,Long rows);

    /**
     * 分页查询
     * @param page
     * @param rows
     * @param tbBrand
     * @return
     */
    R<IPage<TbBrand>> page(Long page,Long rows,TbBrand tbBrand);

    /**
     * 新增
     * @param tbBrand
     * @return
     */
    R add(TbBrand tbBrand);

    /**
     * 修改
     * @param tbBrand
     * @return
     */
    R update(TbBrand tbBrand);
}
