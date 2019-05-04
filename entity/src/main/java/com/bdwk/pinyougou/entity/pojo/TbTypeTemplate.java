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
 * 模板数据载体
 */
@TableName("tb_type_template")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Accessors(chain = true)
public class TbTypeTemplate extends Model<TbTypeTemplate> {
    private static final long serialVersionUID = 595621629276598180L;
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    private String name;
    private String specIds;
    private String brandIds;
    private String customAttributeItems;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
