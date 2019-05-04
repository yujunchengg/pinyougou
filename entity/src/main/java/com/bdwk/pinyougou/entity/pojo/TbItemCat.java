package com.bdwk.pinyougou.entity.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

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
    //模板id
    private Long typeId;
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
