package com.bdwk.pinyougou.sellergoods.service;

import com.baomidou.mybatisplus.service.IService;
import com.bdwk.pinyougou.pojo.TbSpecification;
import com.bdwk.pinyougou.pojo.TbSpecificationOption;

import java.util.List;
import java.util.Map;

/**
 * 商品规格业务接口
 */
public interface ISpecificationService extends IService<TbSpecification> {
    List<TbSpecification> findAll();

    /**
     * 添加规格和规格详情
     * @param specification
     * @param specificationOptions
     * @return
     */
    boolean addOne2Many(TbSpecification specification, List<TbSpecificationOption> specificationOptions);

    /**
     * 查询规格列表(select2格式的)
     * @return
     */
    List<Map> select2list();
}
