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
 * 商品规格详情实体类
 */
@TableName("tb_specification_option")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Accessors(chain = true)
public class TbSpecificationOption extends Model<TbSpecificationOption> {
    private static final long serialVersionUID = -236960855799863066L;
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    private String optionName;
    private Long specId;
    private Integer orders;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
