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

/**
 * 订单条目实体类
 */
@TableName("tb_order_item")
@Data
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class TbOrderItem extends Model<TbOrderItem> {

    private static final long serialVersionUID = 3246079442749014949L;
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    //商品id
    private Long itemId;
    //SPU_ID
    private Long goodsId;
    //订单id
    private Long orderId;
    //商品标题
    private String title;
    //商品单价
    private BigDecimal price;
    //商品购买数量
    private Integer num;
    //商品总金额
    private BigDecimal totalFee;
    //商品图片地址
    private String picPath;
    //商家id
    private String sellerId;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
