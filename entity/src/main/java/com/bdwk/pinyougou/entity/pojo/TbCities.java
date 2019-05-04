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
 * 城市实体类
 */
@TableName("tb_cities")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Accessors(chain = true)
public class TbCities extends Model<TbCities> {

    private static final long serialVersionUID = 7829374476226185648L;
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String cityid;
    private String city;
    private String provinceid;
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
