package com.bdwk.pinyougou.managerweb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.bdwk.pinyougou.common.enums.ResultEnum;
import com.bdwk.pinyougou.common.http.R;
import com.bdwk.pinyougou.pojo.TbTypeTemplate;
import com.bdwk.pinyougou.sellergoods.service.ITypeTemplateService;
import com.google.common.base.Strings;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/typeTemplate")
public class TypeTemplateController {

    @Reference(version = "1.0.0",url = "dubbo://127.0.0.1:20903")
    private ITypeTemplateService typeTemplateService;

    /**
     * 查询所有
     * @return
     */
    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    public R findAll(){
        return R.create(typeTemplateService.findAll());
    }

    /**
     * 分页查询
     * @return
     */
    @RequestMapping(value = "/findPage",method = RequestMethod.GET)
    public R findPage(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows){
        return R.create(typeTemplateService.selectPage(new Page<>(page,rows)));
    }

    /**
     * 条件搜索
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public R search(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows,@RequestBody TbTypeTemplate tbTypeTemplate){
        if(null==tbTypeTemplate){
            return R.create(typeTemplateService.selectPage(new Page<>(page,rows)));
        }else {
            Wrapper<TbTypeTemplate> wrapper=new EntityWrapper<>();
            if(!Strings.isNullOrEmpty(tbTypeTemplate.getName())){
                wrapper.like("name",tbTypeTemplate.getName());
            }
            return R.create(typeTemplateService.selectPage(new Page<>(page,rows),wrapper));
        }
    }

    /**
     * 单条查询
     * @return
     */
    @RequestMapping(value = "/findOne",method = RequestMethod.GET)
    public R<TbTypeTemplate> findOne(@RequestParam("id")Long id){
        return R.create(typeTemplateService.selectById(id));
    }

    /**
     * 新增
     * @param tbTypeTemplate
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public R add(@RequestBody TbTypeTemplate tbTypeTemplate){
        return typeTemplateService.insert(tbTypeTemplate)?R.create(ResultEnum.DATA_SAVE_SUCCESS):R.create(ResultEnum.DATA_SAVE_FAILED);
    }

    /**
     * 修改
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public R update(@RequestBody TbTypeTemplate tbTypeTemplate){
        return typeTemplateService.updateById(tbTypeTemplate)?R.create(ResultEnum.DATA_UPDATE_SUCCESS):R.create(ResultEnum.DATA_UPDATE_FAILED);
    }

    /**
     * 删除
     * @param ids
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public R delete(@RequestParam List<Long> ids){
        return typeTemplateService.deleteBatchIds(ids)?R.create(ResultEnum.DATA_DELETE_SUCCESS):R.create(ResultEnum.DATA_DELETE_FAILED);
    }
}
