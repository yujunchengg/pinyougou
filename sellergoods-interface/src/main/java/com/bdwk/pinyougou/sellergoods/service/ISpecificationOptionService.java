package com.bdwk.pinyougou.sellergoods.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bdwk.pinyougou.common.http.R;
import com.bdwk.pinyougou.entity.pojo.TbSpecificationOption;

import java.util.List;

/**
 * 商品规格详情业务接口
 */
public interface ISpecificationOptionService extends IService<TbSpecificationOption> {

    R<List<TbSpecificationOption>> selectAll();
}
