package com.bdwk.pinyougou.sellergoods.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bdwk.pinyougou.common.http.R;
import com.bdwk.pinyougou.entity.pojo.TbSeller;

public interface ISellerService extends IService<TbSeller> {
    /**
     * 根据id修改状态值
     * @param id
     * @param status
     * @return
     */
    R updateStatusById(String id, String status);

    /**
     * 保存
     * @param tbSeller
     * @return
     */
    R add(TbSeller tbSeller);

    /**
     * 根据主键查询
     * @param id
     * @return
     */
    R<TbSeller> selectById(String id);

    /**
     * 分页查询
     * @param current
     * @param rows
     * @param status
     * @return
     */
    R<IPage<TbSeller>> page(Long current,Long rows,String status);

    /**
     * 分页查询
     * @param current
     * @param rows
     * @param status
     * @param seller
     * @return
     */
    R<IPage<TbSeller>> page(Long current,Long rows,String status,TbSeller seller);
}
