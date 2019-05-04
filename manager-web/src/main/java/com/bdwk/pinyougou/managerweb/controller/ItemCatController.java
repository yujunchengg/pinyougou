package com.bdwk.pinyougou.managerweb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bdwk.pinyougou.common.http.R;
import com.bdwk.pinyougou.entity.pojo.TbItemCat;
import com.bdwk.pinyougou.sellergoods.service.IItemCatService;
import com.bdwk.pinyougou.sellergoods.service.ITypeTemplateService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/itemCat")
public class ItemCatController extends BaseController{

    @Reference(version = DUBBO_REFERENCE_VERSION,url =DUBBO_REFERENCE_URL)
    private IItemCatService itemCatService;
    @Reference(version = DUBBO_REFERENCE_VERSION,url =DUBBO_REFERENCE_URL)
    private ITypeTemplateService typeTemplateService;

    /**
     * 分页查询
     * @return
     */
    @RequestMapping(value = "/findPage",method = RequestMethod.GET)
    public R findPage(@RequestParam("page") Long page, @RequestParam("rows") Long rows,@RequestParam("parentId") Long parentId,
                      @RequestParam(value = "sk",required = false) String name){
        return itemCatService.page(page,rows,parentId,name);
    }

    /**
     * 条件搜索
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping(value = "/search",method = RequestMethod.GET)
    public R search(@RequestParam("page") Long page, @RequestParam("rows") Long rows,@RequestParam("parentId") Long parentId,
                    @RequestParam(value = "sk",required = false) String name){
        return itemCatService.page(page,rows,parentId,name);
    }


    /**
     * 单条查询
     * @return
     */
    @RequestMapping(value = "/findOne",method = RequestMethod.GET)
    public R<TbItemCat> findOne(@RequestParam("id")Long id){
        return R.create(itemCatService.getById(id));
    }


    /**
     * 新增
     * @param itemCat
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public R add(@RequestBody TbItemCat itemCat){
        return itemCatService.save(itemCat)?R.addSuccess():R.addFailed();
    }

    /**
     * 修改
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public R update(@RequestBody TbItemCat tbItemCat){
        return itemCatService.updateById(tbItemCat)?R.updateSuccess():R.updateFailed();
    }

    /**
     * 删除
     * @param ids
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public R delete(@RequestParam List<Long> ids){
        return itemCatService.deleteByIds(ids);
    }

    /**
     * 查询品牌列表(select2要求的格式)
     * @return
     */
    @RequestMapping(value = "/select2list",method = RequestMethod.GET)
    public R<List<Map>> select2list(){
        return typeTemplateService.select2List();
    }
}
