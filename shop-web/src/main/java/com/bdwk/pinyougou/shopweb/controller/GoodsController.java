package com.bdwk.pinyougou.shopweb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.rpc.RpcException;
import com.bdwk.pinyougou.common.exception.BizException;
import com.bdwk.pinyougou.common.http.R;
import com.bdwk.pinyougou.entity.dto.GoodsDto;
import com.bdwk.pinyougou.sellergoods.service.IGoodsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/goods")
public class GoodsController extends BaseController{

    @Reference(version =DUBBO_REFERENCE_VERSION,url = DUBBO_REFERENCE_URL)
    private IGoodsService goodsService;

    /**
     * 添加
     * @param goodsDto
     * @return
     */
    @RequestMapping("/add")
    public R add(@RequestBody GoodsDto goodsDto){
        return goodsService.add(goodsDto, getAuthedId());
    }

    /**
     * 查询select2模型数据
     * @return
     */
    @RequestMapping("/select2")
    public R select2(@RequestParam(value = "lv")Integer lv,@RequestParam("parentId")Long parentId){
        return goodsService.select2(lv,parentId);
    }
}
