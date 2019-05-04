package com.bdwk.pinyougou.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bdwk.pinyougou.entity.pojo.TbSpecificationOption;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 规格详情Mapper
 */
@Mapper
public interface TbSpecificationOptionMapper extends BaseMapper<TbSpecificationOption> {
    /**
     * 批量插入规格详情
     * @param list
     * @return
     */
    int insertBatch(@Param("list") List<TbSpecificationOption> list);
}
