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
 * 广告实体类
 */
@TableName("tb_content")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Accessors(chain = true)
public class TbContent extends Model<TbContent> {

    private static final long serialVersionUID = 3763482707113496102L;
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    private Long categoryId;
    private String title;
    private String url;
    private String pic;
    private String status;
    private Integer sortOrder;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
