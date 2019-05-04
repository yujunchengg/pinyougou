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
import java.util.Date;

/**
 * 支付日志实体类
 */
@TableName("tb_pay_log")
@Data
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class TbPayLog extends Model<TbPayLog> {

    private static final long serialVersionUID = -3263478183234863846L;
    //支付单号
    @TableId(value = "out_trade_no",type = IdType.INPUT)
    private String outTradeNo;
    //创建时间
    private Date createTime;
    //支付完成时间
    private Date payTime;
    //支付金额(分)
    private Long totalFee;
    //用户id
    private String userId;
    //交易号码
    private String transactionId;
    //交易状态
    private String tradeState;
    //订单编号列表
    private String orderList;
    //支付类型
    private String payType;

    @Override
    protected Serializable pkVal() {
        return this.outTradeNo;
    }
}
