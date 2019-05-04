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
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品实体类
 */
@TableName("tb_item")
@Data
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class TbItem extends Model<TbItem> {

    private static final long serialVersionUID = 8854055089296068767L;
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    //商家标题
    private String title;
    //商品卖点
    private String sellPoint;
    //价格
    private BigDecimal price;
    //
    private Integer stockCount;
    //库存数量
    private Integer num;
    //商品条形码
    private String barcode;
    //商品图片
    private String image;
    //所属类目，叶子类目
    private Long categoryId;
    //商品状态，1-正常，2-下架，3-删除
    private String status;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;
    //
    private String itemSn;
    //花费价格
    private BigDecimal costPirce;
    //
    private BigDecimal marketPrice;
    //
    private String isDefault;
    //
    private Long goodsId;

    private String sellerId;

    private String cartThumbnail;

    private String category;

    private String brand;

    private String spec;

    private String seller;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
