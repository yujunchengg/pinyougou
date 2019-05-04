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
 * 秒杀订单实体类
 */
@TableName("tb_seckill_order")
@Data
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class TbSeckillOrder extends Model<TbSeckillOrder> {


    private static final long serialVersionUID = -5715329432566489282L;
    @TableId(value = "id",type = IdType.INPUT)
    private Long id;
    //秒杀商品id
    private Long seckillId;
    //支付金额
    private BigDecimal money;
    //用户
    private String userId;
    //商家
    private String sellerId;
    //创建时间
    private Date createTime;
    //支付时间
    private Date payTime;
    //状态
    private String status;
    //收货人地址
    private String receiverAddress;
    //收货人电话
    private String receiverMobile;
    //收货人
    private String receiver;
    //交易流水
    private String transactionId;
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
