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
 * 品牌实体类
 */
@TableName("tb_brand")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Accessors(chain = true)
public class TbBrand extends Model<TbBrand> {
    private static final long serialVersionUID = -236960855799863066L;
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    private String name;
    private String firstChar;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
