package com.bdwk.pinyougou.pojo;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
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
