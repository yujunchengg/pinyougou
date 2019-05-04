package com.bdwk.pinyougou.managerweb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bdwk.pinyougou.common.http.R;
import com.bdwk.pinyougou.entity.pojo.TbTypeTemplate;
import com.bdwk.pinyougou.sellergoods.service.ITypeTemplateService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/typeTemplate")
public class TypeTemplateController extends BaseController{

    @Reference(version = DUBBO_REFERENCE_VERSION,url =DUBBO_REFERENCE_URL)
    private ITypeTemplateService typeTemplateService;

    /**
     * 查询所有
     * @return
     */
    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    public R findAll(){
        return typeTemplateService.selectAll();
    }

    /**
     * 分页查询
     * @return
     */
    @RequestMapping(value = "/findPage",method = RequestMethod.GET)
    public R findPage(@RequestParam("page") Long page, @RequestParam("rows") Long rows){
        return typeTemplateService.page(page,rows);
    }

    /**
     * 条件搜索
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public R search(@RequestParam("page") Long page, @RequestParam("rows") Long rows,@RequestBody TbTypeTemplate tbTypeTemplate){
        return typeTemplateService.page(page,rows,tbTypeTemplate);
    }

    /**
     * 单条查询
     * @return
     */
    @RequestMapping(value = "/findOne",method = RequestMethod.GET)
    public R<TbTypeTemplate> findOne(@RequestParam("id")Long id){
        return R.create(typeTemplateService.getById(id));
    }

    /**
     * 新增
     * @param tbTypeTemplate
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public R add(@RequestBody TbTypeTemplate tbTypeTemplate){
        return typeTemplateService.save(tbTypeTemplate)?R.addSuccess():R.addFailed();
    }

    /**
     * 修改
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public R update(@RequestBody TbTypeTemplate tbTypeTemplate){
        return typeTemplateService.updateById(tbTypeTemplate)?R.updateSuccess():R.updateFailed();
    }

    /**
     * 删除
     * @param ids
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public R delete(@RequestParam List<Long> ids){
        return typeTemplateService.removeByIds(ids)?R.deleteSuccess():R.deleteFailed();
    }
}
