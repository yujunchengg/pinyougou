package com.bdwk.pinyougou.sellergoods.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bdwk.pinyougou.common.http.R;
import com.bdwk.pinyougou.entity.pojo.TbItemCat;
import com.bdwk.pinyougou.entity.vo.TbItemCatVo;

import java.util.List;


/**
 * 商品分类业务接口
 */
public interface IItemCatService extends IService<TbItemCat> {
    /**
     * 带条件分页查询
     * @param page
     * @param rows
     * @param parentId
     * @param name
     * @return
     */
    R<Page<TbItemCatVo>> page(Long page, Long rows, Long parentId, String name);

    /**
     * 删除
     * @param ids
     * @return
     */
    R deleteByIds(List<Long> ids);
}
