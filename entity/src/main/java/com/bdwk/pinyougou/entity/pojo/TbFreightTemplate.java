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
