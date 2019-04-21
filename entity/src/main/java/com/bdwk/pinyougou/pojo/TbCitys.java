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
 * 城市实体类
 */
@TableName("tb_citys")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Accessors(chain = true)
public class TbCitys extends Model<TbCitys> {

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
