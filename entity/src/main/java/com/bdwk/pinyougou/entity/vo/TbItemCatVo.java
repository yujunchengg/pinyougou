package com.bdwk.pinyougou.entity.vo;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 商品类目实体类
 */
@Data
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class TbItemCatVo implements Serializable{

    private static final long serialVersionUID = 9018600325842708056L;

    private Long id;
    //父类目ID=0时，代表的是一级的类目
    private Long parentId;
    //类目名称
    private String name;
    //模板id
    private Long typeId;
    //模板名称
    private String typeName;
}
