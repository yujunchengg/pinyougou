package com.bdwk.pinyougou.managerweb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.bdwk.pinyougou.common.enums.ResultEnum;
import com.bdwk.pinyougou.common.http.R;
import com.bdwk.pinyougou.pojo.TbSpecification;
import com.bdwk.pinyougou.pojo.TbSpecificationOption;
import com.bdwk.pinyougou.sellergoods.service.ISpecificationOptionService;
import com.bdwk.pinyougou.sellergoods.service.ISpecificationService;
import com.bdwk.pinyougou.vo.SpecificationVo;
import com.google.common.base.Strings;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 规格controller
 */
@RestController
@RequestMapping("/specification")
public class SpecificationController {
    //规格服务
    @Reference(version = "1.0.0",url = "dubbo://127.0.0.1:20903")
    private ISpecificationService specificationService;
    //规格详情服务
    @Reference(version = "1.0.0",url = "dubbo://127.0.0.1:20903")
    private ISpecificationOptionService specificationOptionService;
    /**
     * 查询所有
     * @return
     */
    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    public R findAll(){
        return R.create(specificationService.findAll());
    }

    /**
     * 分页查询
     * @return
     */
    @RequestMapping(value = "/findPage",method = RequestMethod.GET)
    public R findPage(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows){
        return R.create(specificationService.selectPage(new Page<>(page,rows)));
    }

    /**
     * 条件搜索
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public R search(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows,@RequestBody TbSpecification tbSpecification){
        if(null==tbSpecification){
            return R.create(specificationService.selectPage(new Page<>(page,rows)));
        }else {
            Wrapper<TbSpecification> wrapper=new EntityWrapper<>();
            if(!Strings.isNullOrEmpty(tbSpecification.getSpecName())){
                wrapper.like("spec_name",tbSpecification.getSpecName());
            }
            return R.create(specificationService.selectPage(new Page<>(page,rows),wrapper));
        }
    }

    /**
     * 单条查询
     * @return
     */
    @RequestMapping(value = "/findOne",method = RequestMethod.GET)
    public R<SpecificationVo> findOne(@RequestParam("id")Long id){
        SpecificationVo specificationVo=null;
        //规格
        TbSpecification tbSpecification = specificationService.selectById(id);
        if(null!=tbSpecification){
            //查询规格详情
            Wrapper<TbSpecificationOption> wrapper=new EntityWrapper<>();
            wrapper.eq("spec_id",tbSpecification.getId());
            List<TbSpecificationOption> tbSpecificationOptions = specificationOptionService.selectList(wrapper);

            specificationVo=new SpecificationVo(tbSpecification,tbSpecificationOptions);
        }
        return R.create(specificationVo);
    }

    /**
     * 新增
     * @param specificationVo
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public R add(@RequestBody SpecificationVo specificationVo){
        if(null==specificationVo){
            return R.create(ResultEnum.DATA_SAVE_FAILED);
        }
        //添加规格的同时添加规格详情
        boolean ret=specificationService.addOne2Many(specificationVo.getSpec(),specificationVo.getSpecOps());
        return ret?R.create(ResultEnum.DATA_SAVE_SUCCESS):R.create(ResultEnum.DATA_SAVE_FAILED);
    }

    /**
     * 修改
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @Transactional(rollbackFor = Exception.class)
    public R update(@RequestBody SpecificationVo specificationVo){
        //先删除1对多中多的一方的记录再插入,更新1的一方
        if(null==specificationVo || null==specificationVo.getSpec()){
            return R.create(ResultEnum.DATA_UPDATE_FAILED);
        }
        List<TbSpecificationOption> specificationOptions = specificationVo.getSpecOps();
        Wrapper<TbSpecificationOption> wrapper=new EntityWrapper<>();
        wrapper.eq("spec_id",specificationVo.getSpec().getId());
        //删除多的一方的记录
        boolean ret1 = specificationOptionService.delete(wrapper);
        //添加多的一方
        boolean ret2 = specificationOptionService.insertBatch(specificationOptions);
        //修改1的一方
        boolean ret3 = specificationService.updateById(specificationVo.getSpec());
        return ret1 && ret2 && ret3?R.create(ResultEnum.DATA_UPDATE_SUCCESS):R.create(ResultEnum.DATA_UPDATE_FAILED);
    }

    /**
     * 删除
     * @param ids
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    @Transactional(rollbackFor = Exception.class)
    public R delete(@RequestParam List<Long> ids){
        //删除规格的同时删除规格详情
        Wrapper<TbSpecificationOption> wrapper=new EntityWrapper<>();
        wrapper.in("spec_id",ids);
        boolean ret1=specificationOptionService.delete(wrapper);
        //删除规格
        boolean ret2=specificationService.deleteBatchIds(ids);
        return ret1 && ret2?R.create(ResultEnum.DATA_DELETE_SUCCESS):R.create(ResultEnum.DATA_DELETE_FAILED);
    }

    /**
     * 查询品牌列表(select2要求的格式)
     * @return
     */
    @RequestMapping(value = "/select2list",method = RequestMethod.GET)
    public R<List<Map>> select2list(){
        return R.create(specificationService.select2list());
    }
}
