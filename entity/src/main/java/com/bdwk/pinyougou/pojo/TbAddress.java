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
import java.util.Date;

/**
 * 地址实体类
 */
@TableName("tb_address")
@Data
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class TbAddress extends Model<TbAddress> {

    private static final long serialVersionUID = 6040773810927068316L;
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    private String userId;
    private String provinceId;
    private String cityId;
    private String townId;
    private String mobile;
    private String address;
    private String contact;
    private String isDefault;
    private String notes;
    private Date createDate;
    private String alias;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
