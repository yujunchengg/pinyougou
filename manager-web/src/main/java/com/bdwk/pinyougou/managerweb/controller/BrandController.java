package com.bdwk.pinyougou.managerweb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bdwk.pinyougou.common.http.R;
import com.bdwk.pinyougou.entity.pojo.TbBrand;
import com.bdwk.pinyougou.sellergoods.service.IBrandService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/brand")
public class BrandController extends BaseController{

    @Reference(version = DUBBO_REFERENCE_VERSION,url =DUBBO_REFERENCE_URL)
    private IBrandService brandService;

    /**
     * 查询所有
     * @return
     */
    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    public R findAll(){
        return brandService.selectAll();
    }

    /**
     * 分页查询
     * @return
     */
    @RequestMapping(value = "/findPage",method = RequestMethod.GET)
    public R findPage(@RequestParam("page") Long page, @RequestParam("rows") Long rows){
        return brandService.page(page,rows);
    }

    /**
     * 条件搜索
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public R search(@RequestParam("page") Long page, @RequestParam("rows") Long rows,@RequestBody TbBrand tbBrand){
        return brandService.page(page,rows,tbBrand);
    }

    /**
     * 单条查询
     * @return
     */
    @RequestMapping(value = "/findOne",method = RequestMethod.GET)
    public R<TbBrand> findOne(@RequestParam("id")Long id){
        return R.create(brandService.getById(id));
    }

    /**
     * 新增
     * @param tbBrand
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public R add(@RequestBody TbBrand tbBrand){
        return brandService.add(tbBrand);
    }

    /**
     * 修改
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public R update(@RequestBody TbBrand tbBrand){
        return brandService.update(tbBrand);
    }

    /**
     * 删除
     * @param ids
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public R delete(@RequestParam List<Long> ids){
        return brandService.removeByIds(ids)?R.deleteSuccess():R.deleteFailed();
    }

    /**
     * 查询品牌列表(select2要求的格式)
     * @return
     */
    @RequestMapping(value = "/select2list",method = RequestMethod.GET)
    public R<List<Map>> select2list(){
        return brandService.select2list();
    }
}
