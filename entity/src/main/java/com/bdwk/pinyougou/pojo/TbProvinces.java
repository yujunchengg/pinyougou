package com.bdwk.pinyougou.pojo;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 省份实体类
 */
@TableName("tb_provinces")
@Data
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class TbProvinces extends Model<TbProvinces> {

    private static final long serialVersionUID = 945874126650490569L;
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    //省份id
    private String provinceid;
    //省份名称
    private String province;
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
