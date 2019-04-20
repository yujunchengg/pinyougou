package com.bdwk.pinyougou.sellergoods.service;

import com.baomidou.mybatisplus.service.IService;
import com.bdwk.pinyougou.pojo.TbSpecificationOption;

import java.util.List;

/**
 * 商品规格详情业务接口
 */
public interface ISpecificationOptionService extends IService<TbSpecificationOption> {
    List<TbSpecificationOption> findAll();
}
