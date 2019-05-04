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
 * 商品详情实体类(SPU表扩展信息)
 */
@TableName("tb_goods_desc")
@Data
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class TbGoodsDesc extends Model<TbGoodsDesc> {

    private static final long serialVersionUID = 3626282646576839367L;
    //SPU_ID
    @TableId(value = "goods_id",type = IdType.INPUT)
    private Long goodsId;
    //描述
    private String introduction;
    //规格结果集，所有规格，包含isSelected
    private String specificationItems;
    //自定义属性（参数结果）
    private String customAttributeItems;
    //图片
    private String itemImages;
    //包装列表
    private String packageList;
    //售后服务
    private String saleService;
    @Override
    protected Serializable pkVal() {
        return this.goodsId;
    }
}
