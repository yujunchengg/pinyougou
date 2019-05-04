package com.bdwk.pinyougou.entity.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
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
