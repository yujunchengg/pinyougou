package com.bdwk.pinyougou.sellergoods.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bdwk.pinyougou.common.http.R;
import com.bdwk.pinyougou.entity.dto.GoodsDto;
import com.bdwk.pinyougou.entity.pojo.TbGoods;
import com.bdwk.pinyougou.entity.vo.GoodsSelect2Vo;

/**
 * 商品业务接口
 */
public interface IGoodsService extends IService<TbGoods> {
    /**
     * 插入商品信息
     * @param goodsDto  商品信息组合实体类
     * @return
     */
    R add(GoodsDto goodsDto, String authedId);

    /**
     * 查询select2的数据
     * @return
     */
    R<GoodsSelect2Vo> select2(Integer lv,Long parentId);
}
