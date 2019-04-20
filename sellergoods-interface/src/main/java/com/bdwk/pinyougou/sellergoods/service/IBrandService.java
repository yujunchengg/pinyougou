package com.bdwk.pinyougou.sellergoods.service;

import com.baomidou.mybatisplus.service.IService;
import com.bdwk.pinyougou.pojo.TbBrand;

import java.util.List;
import java.util.Map;

/**
 * 品牌业务接口
 */
public interface IBrandService extends IService<TbBrand> {
    List<TbBrand> findAll();

    /**
     * 查询select2格式的数据
     * @return
     */
    List<Map> select2list();
}
