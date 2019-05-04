package com.bdwk.pinyougou.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bdwk.pinyougou.entity.pojo.TbBrand;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 品牌实体类数据访问接口
 */
@Mapper
public interface TbBrandMapper extends BaseMapper<TbBrand> {
    List<Map> select2list();
}
