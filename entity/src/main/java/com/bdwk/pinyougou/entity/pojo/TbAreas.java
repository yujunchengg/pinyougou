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
