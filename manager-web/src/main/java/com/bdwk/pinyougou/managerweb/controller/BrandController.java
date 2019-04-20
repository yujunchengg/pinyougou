package com.bdwk.pinyougou.managerweb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.bdwk.pinyougou.common.enums.ResultEnum;
import com.bdwk.pinyougou.common.http.R;
import com.bdwk.pinyougou.pojo.TbBrand;
import com.bdwk.pinyougou.sellergoods.service.IBrandService;
import com.google.common.base.Strings;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/brand")
public class BrandController {

    @Reference(version = "1.0.0",url = "dubbo://127.0.0.1:20903")
    private IBrandService brandService;

    /**
     * 查询所有
     * @return
     */
    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    public R findAll(){
        return R.create(brandService.findAll());
    }

    /**
     * 分页查询
     * @return
     */
    @RequestMapping(value = "/findPage",method = RequestMethod.GET)
    public R findPage(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows){
        return R.create(brandService.selectPage(new Page<>(page,rows)));
    }

    /**
     * 条件搜索
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public R search(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows,@RequestBody TbBrand tbBrand){
        if(null==tbBrand){
            return R.create(brandService.selectPage(new Page<>(page,rows)));
        }else {
            Wrapper<TbBrand> wrapper=new EntityWrapper<>();
            if(!Strings.isNullOrEmpty(tbBrand.getName())){
                wrapper.like("name",tbBrand.getName());
            }
            if(!Strings.isNullOrEmpty(tbBrand.getFirstChar())){
                wrapper.like("first_char",tbBrand.getFirstChar());
            }
            return R.create(brandService.selectPage(new Page<>(page,rows),wrapper));
        }
    }


    /**
     * 单条查询
     * @return
     */
    @RequestMapping(value = "/findOne",method = RequestMethod.GET)
    public R<TbBrand> findOne(@RequestParam("id")Long id){
        return R.create(brandService.selectById(id));
    }

    /**
     * 新增
     * @param tbBrand
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public R add(@RequestBody TbBrand tbBrand){
        return brandService.insert(tbBrand)?R.create(ResultEnum.DATA_SAVE_SUCCESS):R.create(ResultEnum.DATA_SAVE_FAILED);
    }

    /**
     * 修改
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public R update(@RequestBody TbBrand tbBrand){
        return brandService.updateById(tbBrand)?R.create(ResultEnum.DATA_UPDATE_SUCCESS):R.create(ResultEnum.DATA_UPDATE_FAILED);
    }

    /**
     * 删除
     * @param ids
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public R delete(@RequestParam List<Long> ids){
        return brandService.deleteBatchIds(ids)?R.create(ResultEnum.DATA_DELETE_SUCCESS):R.create(ResultEnum.DATA_DELETE_FAILED);
    }

    /**
     * 查询品牌列表(select2要求的格式)
     * @return
     */
    @RequestMapping(value = "/select2list",method = RequestMethod.GET)
    public R<List<Map>> select2list(){
        return R.create(brandService.select2list());
    }
}
