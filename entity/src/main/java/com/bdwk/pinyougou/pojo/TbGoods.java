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
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品实体类
 */
@TableName("tb_goods")
@Data
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class TbGoods extends Model<TbGoods> {

    private static final long serialVersionUID = 7374715915148653834L;
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    //商家id
    private String sellerId;
    //SPU名
    private String goodsName;
    //默认SKU
    private Long defaultItemId;
    //状态
    private String auditStatus;
    //是否上架
    private String isMarketable;
    //所属品牌
    private Long brandId;
    //副标题
    private String caption;
    //一级类目
    private Long category1Id;
    //二级类目
    private Long category2Id;
    //三级类目
    private Long category3Id;
    //小图
    private String smallPic;
    //商城价
    private BigDecimal price;
    //分类模板id
    private Long typeTemplateId;
    //是否启用规格
    private String isEnableSpec;
    //是否删除
    private String isDelete;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
