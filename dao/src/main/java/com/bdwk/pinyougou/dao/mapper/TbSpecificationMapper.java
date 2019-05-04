package com.bdwk.pinyougou.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bdwk.pinyougou.entity.pojo.TbSpecification;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 规格Mapper
 */
@Mapper
public interface TbSpecificationMapper extends BaseMapper<TbSpecification> {
    List<Map> select2list();
}
