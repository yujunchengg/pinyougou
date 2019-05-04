package com.bdwk.pinyougou.entity.dto;

import com.bdwk.pinyougou.entity.pojo.TbGoods;
import com.bdwk.pinyougou.entity.pojo.TbGoodsDesc;
import com.bdwk.pinyougou.entity.pojo.TbItem;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * 商品组合实体类
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class GoodsDto implements Serializable {
    private static final long serialVersionUID = -3186355012804920165L;
    //商品基本信息(SPU)
    private TbGoods goods;
    //商品扩展信息(SPU)
    private TbGoodsDesc goodsDesc;
    //商品信息(SKU)
    private List<TbItem> itemList;
}
