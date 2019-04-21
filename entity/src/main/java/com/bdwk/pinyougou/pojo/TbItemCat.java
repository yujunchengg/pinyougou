package com.bdwk.pinyougou.pojo;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品类目实体类
 */
@TableName("tb_item_cat")
@Data
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class TbItemCat extends Model<TbItemCat> {

    private static final long serialVersionUID = 9018600325842708056L;
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    //父类目ID=0时，代表的是一级的类目
    private Long parentId;
    //类目名称
    private String name;
    //类型id
    private Long typeId;
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
