package com.bdwk.pinyougou.managerweb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bdwk.pinyougou.common.http.R;
import com.bdwk.pinyougou.entity.pojo.TbSeller;
import com.bdwk.pinyougou.sellergoods.service.ISellerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seller")
public class SellerController extends BaseController{

    @Reference(version = DUBBO_REFERENCE_VERSION,url =DUBBO_REFERENCE_URL)
    private ISellerService sellerService;

    /**
     * 分页查询
     * @return
     */
    @RequestMapping(value = "/findPage",method = RequestMethod.GET)
    public R findPage(@RequestParam("page") Long page, @RequestParam("rows") Long rows,@RequestParam("status") String status){
        return sellerService.page(page,rows,status);
    }

    /**
     * 条件搜索
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public R search(@RequestParam("page") Long page, @RequestParam("rows") Long rows,@RequestParam("status") String status,@RequestBody TbSeller tbSeller){

        return sellerService.page(page,rows,status,tbSeller);
    }


    /**
     * 单条查询
     * @return
     */
    @RequestMapping(value = "/findOne",method = RequestMethod.GET)
    public R<TbSeller> findOne(@RequestParam("id")String id){
        return sellerService.selectById(id);
    }


    /**
     * 修改
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public R update(@RequestBody TbSeller tbSeller){
        return sellerService.updateById(tbSeller)?R.updateSuccess():R.updateFailed();
    }

    /**
     * 审核
     * @param id
     * @param status
     * @return
     */
    @RequestMapping(value = "/check",method = RequestMethod.GET)
    public R check(@RequestParam("id")String id,@RequestParam("status")String status){
        return sellerService.updateStatusById(id,status);
    }

    /**
     * 删除
     * @param ids
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public R delete(@RequestParam List<Long> ids){
        return sellerService.removeByIds(ids)?R.deleteSuccess():R.deleteFailed();
    }
}
