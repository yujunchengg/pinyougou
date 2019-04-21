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
import java.math.BigDecimal;
import java.util.Date;

@TableName("tb_freight_template")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Accessors(chain = true)
public class TbFreightTemplate extends Model<TbFreightTemplate> {

    private static final long serialVersionUID = -6674091635462997100L;
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    //商家id
    private String sellerId;
    //是否默认,是Y,否N
    private String isDefault;
    //模板名称
    private String name;
    //发货时间
    private String sendTimeType;
    //统一价格
    private BigDecimal price;
    //创建时间
    private Date createTime;
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
