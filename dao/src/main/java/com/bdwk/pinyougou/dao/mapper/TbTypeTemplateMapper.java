package com.bdwk.pinyougou.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bdwk.pinyougou.entity.pojo.TbTypeTemplate;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 模板Mapper
 */
@Mapper
public interface TbTypeTemplateMapper extends BaseMapper<TbTypeTemplate> {
    List<Map> select2List();
}
