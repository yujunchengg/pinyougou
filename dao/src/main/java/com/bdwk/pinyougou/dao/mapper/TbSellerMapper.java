package com.bdwk.pinyougou.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bdwk.pinyougou.entity.pojo.TbSeller;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TbSellerMapper extends BaseMapper<TbSeller> {

    int updateStatusById(@Param("id") String id, @Param("status") String status);
}
