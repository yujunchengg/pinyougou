package com.bdwk.pinyougou.managerweb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bdwk.pinyougou.common.http.R;
import com.bdwk.pinyougou.entity.pojo.TbSpecification;
import com.bdwk.pinyougou.sellergoods.service.ISpecificationOptionService;
import com.bdwk.pinyougou.sellergoods.service.ISpecificationService;
import com.bdwk.pinyougou.entity.vo.SpecificationVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 规格controller
 */
@RestController
@RequestMapping("/specification")
@Slf4j
public class SpecificationController extends BaseController{
    //规格服务
    @Reference(version = DUBBO_REFERENCE_VERSION,url =DUBBO_REFERENCE_URL)
    private ISpecificationService specificationService;
    //规格详情服务
    @Reference(version = DUBBO_REFERENCE_VERSION,url =DUBBO_REFERENCE_URL)
    private ISpecificationOptionService specificationOptionService;
    /**
     * 查询所有
     * @return
     */
    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    public R findAll(){
        return specificationService.selectAll();
    }

    /**
     * 分页查询
     * @return
     */
    @RequestMapping(value = "/findPage",method = RequestMethod.GET)
    public R findPage(@RequestParam("page") Long page, @RequestParam("rows") Long rows){
        return specificationService.page(page,rows);
    }

    /**
     * 条件搜索
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public R search(@RequestParam("page") Long page, @RequestParam("rows") Long rows,@RequestBody TbSpecification tbSpecification){
        return specificationService.page(page,rows,tbSpecification);
    }

    /**
     * 单条查询
     * @return
     */
    @RequestMapping(value = "/findOne",method = RequestMethod.GET)
    public R<SpecificationVo> findOne(@RequestParam("id")Long id){
        return specificationService.selectById(id);
    }

    /**
     * 新增
     * @param specificationVo
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public R add(@RequestBody SpecificationVo specificationVo){
        return specificationService.add(specificationVo);
    }

    /**
     * 修改
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public R update(@RequestBody SpecificationVo specificationVo){
        return specificationService.update(specificationVo);
    }

    /**
     * 删除
     * @param ids
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public R delete(@RequestParam List<Long> ids){
        return specificationService.deleteByIds(ids);
    }

    /**
     * 查询品牌列表(select2要求的格式)
     * @return
     */
    @RequestMapping(value = "/select2list",method = RequestMethod.GET)
    public R<List<Map>> select2list(){
        return specificationService.select2list();
    }
}
