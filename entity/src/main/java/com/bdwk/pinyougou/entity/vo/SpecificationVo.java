package com.bdwk.pinyougou.entity.vo;

import com.bdwk.pinyougou.entity.pojo.TbSpecification;
import com.bdwk.pinyougou.entity.pojo.TbSpecificationOption;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Accessors(chain = true)
public class SpecificationVo implements Serializable {
    private static final long serialVersionUID = 3224248734017481735L;
    //规格实体
    private TbSpecification spec;
    //规格详情实体
    private List<TbSpecificationOption> specOps;
}
