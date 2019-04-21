package com.bdwk.pinyougou.pojo;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 秒杀商品实体类
 */
@TableName("tb_seckill_goods")
@Data
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class TbSeckillGoods extends Model<TbSeckillGoods> {
    private static final long serialVersionUID = -4404572778014751185L;
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    //SPU ID
    private Long goodsId;
    //SKU ID
    private Long itemId;
    //标题
    private String title;
    //商品图片
    private String smallPic;
    //原价格
    private BigDecimal price;
    //秒杀价格
    private BigDecimal costPrice;
    //商家ID
    private String sellerId;
    //添加日期
    private Date createTime;
    //审核日期
    private Date checkTime;
    //审核状态
    private String status;
    //开始时间
    private Date startTime;
    //结束时间
    private Date endTime;
    //秒杀商品数
    private Integer num;
    //剩余库存数
    private Integer stockCount;
    //描述
    private String introduction;
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
