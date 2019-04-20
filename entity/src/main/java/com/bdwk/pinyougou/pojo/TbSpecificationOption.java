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
