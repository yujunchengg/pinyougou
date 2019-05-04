package com.bdwk.pinyougou.sellergoods.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bdwk.pinyougou.common.http.R;
import com.bdwk.pinyougou.entity.pojo.TbSpecification;
import com.bdwk.pinyougou.entity.vo.SpecificationVo;

import java.util.List;
import java.util.Map;

/**
 * 商品规格业务接口
 */
public interface ISpecificationService extends IService<TbSpecification> {
    R<List<TbSpecification>> selectAll();

    /**
     * 添加规格和规格详情
     * @param specificationVo
     * @return
     */
    R add(SpecificationVo specificationVo);

    /**
     * 更新组合实体类
     * @param specificationVo
     * @return
     */
    R update(SpecificationVo specificationVo);
    /**
     * 查询规格列表(select2格式的)
     * @return
     */
    R<List<Map>> select2list();

    /**
     * 分页查询不带条件
     * @param current
     * @param rows
     * @return
     */
    R<IPage<TbSpecification>> page(Long current,Long rows);

    /**
     * 分页查询带条件
     * @param current
     * @param rows
     * @param tbSpecification
     * @return
     */
    R<IPage<TbSpecification>> page(Long current,Long rows,TbSpecification tbSpecification);

    /**
     * 查询组合实体类
     * @param id
     * @return
     */
    R<SpecificationVo> selectById(Long id);

    /**
     * 删除多条记录
     * @param ids
     * @return
     */
    R deleteByIds(List<Long> ids);
}
