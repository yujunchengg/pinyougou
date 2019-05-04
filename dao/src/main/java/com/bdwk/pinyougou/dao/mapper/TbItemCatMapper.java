package com.bdwk.pinyougou.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bdwk.pinyougou.entity.pojo.TbItemCat;
import com.bdwk.pinyougou.entity.vo.TbItemCatVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface TbItemCatMapper extends BaseMapper<TbItemCat> {

    List<TbItemCatVo> selectPage(@Param("page") Page<TbItemCatVo> page, @Param("parentId") Long parentId, @Param("name") String name);

    List<Map> select2(@Param("parentId") Long parentId);
}
