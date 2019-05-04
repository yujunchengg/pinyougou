package com.bdwk.pinyougou.entity.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 品牌实体类
 */
@TableName("tb_brand")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Accessors(chain = true)
public class TbBrand extends Model<TbBrand> {
    private static final long serialVersionUID = -6703760242334715270L;
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    private String name;
    private String firstChar;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
