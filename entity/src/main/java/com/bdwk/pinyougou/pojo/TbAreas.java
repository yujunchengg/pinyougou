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
 * 区域实体类
 */
@TableName("tb_areas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Accessors(chain = true)
public class TbAreas extends Model<TbAreas> {
    private static final long serialVersionUID = -9217853309510104446L;
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String areaid;
    private String area;
    private String cityid;
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
