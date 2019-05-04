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
 * 广告分类实体类
 */
@TableName("tb_content_category")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Accessors(chain = true)
public class TbContentCategory extends Model<TbContentCategory> {

    private static final long serialVersionUID = -7850017569433852601L;
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    private String name;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
