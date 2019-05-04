package com.bdwk.pinyougou.sellergoods.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bdwk.pinyougou.common.enums.ResultEnum;
import com.bdwk.pinyougou.common.http.R;
import com.bdwk.pinyougou.dao.mapper.TbSpecificationMapper;
import com.bdwk.pinyougou.dao.mapper.TbSpecificationOptionMapper;
import com.bdwk.pinyougou.entity.pojo.TbSpecification;
import com.bdwk.pinyougou.entity.pojo.TbSpecificationOption;
import com.bdwk.pinyougou.entity.vo.SpecificationVo;
import com.bdwk.pinyougou.sellergoods.service.ISpecificationService;
import com.bdwk.pinyougou.common.util.CollectionUtils;
import com.google.common.base.Strings;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service(protocol = {"dubbo"},validation = "true",version ="1.0.0",timeout = 3000)
@Slf4j
public class SpecificationServiceImpl extends ServiceImpl<TbSpecificationMapper, TbSpecification> implements ISpecificationService {
    @Autowired
    private TbSpecificationOptionMapper tbSpecificationOptionMapper;

    @Override
    public R<List<TbSpecification>> selectAll() {
        Wrapper<TbSpecification> wrapper=new QueryWrapper<>();
        return R.create(this.baseMapper.selectList(wrapper));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public R add(SpecificationVo specificationVo) {
        if(null==specificationVo ||
                null==specificationVo.getSpec()){
            return R.create(ResultEnum.PARAM_IS_BLANK);
        }
        TbSpecification specification=specificationVo.getSpec();
        List<TbSpecificationOption> specificationOptions=specificationVo.getSpecOps();
        //添加规格
        boolean f1 = super.save(specification);
        //批量添加的容器
        List<TbSpecificationOption> insertEntitys=new ArrayList<>();

        int ret=1;

        //若有规格详情则添加规格详情,没有则只添加规格
        if(CollectionUtils.isNotEmpty(specificationOptions)){
            if(specificationOptions.size()==1){
                specificationOptions.get(0).setSpecId(specification.getId());
                ret=tbSpecificationOptionMapper.insert(specificationOptions.get(0));
            }else {
                specificationOptions.stream().forEach((e)->{
                    e.setSpecId(specification.getId());
                    insertEntitys.add(e);
                });
                ret=tbSpecificationOptionMapper.insertBatch(insertEntitys);
            }
        }
        return (f1 && ret>0) ?R.addSuccess():R.addFailed();
    }

    @Override
    @Transactional
    public R update(SpecificationVo specificationVo){
        //判断
        if(null==specificationVo || null==specificationVo.getSpec()){
            R.create(ResultEnum.PARAM_IS_BLANK);
        }
        List<TbSpecificationOption> specificationOptions = specificationVo.getSpecOps();
        //条件
        QueryWrapper<TbSpecificationOption> wrapper=new QueryWrapper<>();
        wrapper.lambda().eq(TbSpecificationOption::getSpecId,specificationVo.getSpec().getId());
        //先删除1对多中多的一方的记录再插入,更新1的一方，删除多的一方的记录
        int ret1 = tbSpecificationOptionMapper.delete(wrapper);
        int ret2=1;
        if(specificationOptions.size()>0){
            if(specificationOptions.size()==1){
                ret2 = tbSpecificationOptionMapper.insert(specificationOptions.get(0));
            }else {
                //添加多的一方
                ret2 = tbSpecificationOptionMapper.insertBatch(specificationOptions);
            }
        }
        //修改1的一方
        boolean ret3 = super.updateById(specificationVo.getSpec());
        return (ret1>=0 && ret2>0 && ret3) ?R.updateSuccess():R.updateFailed();
    }

    @Override
    public R<List<Map>> select2list() {
        return R.create(this.baseMapper.select2list());
    }

    @Override
    public R<IPage<TbSpecification>> page(Long current,Long rows) {
        return R.create(super.page(new Page<>(current,rows)));
    }

    @Override
    public R<IPage<TbSpecification>> page(Long current,Long rows,TbSpecification tbSpecification) {
        Page<TbSpecification> page = new Page<>(current, rows);
        if(null==tbSpecification){
            return R.create(super.page(page));
        }else {
            QueryWrapper<TbSpecification> wrapper=new QueryWrapper<>();
            if(!Strings.isNullOrEmpty(tbSpecification.getSpecName())){
                wrapper.lambda().like(TbSpecification::getSpecName,tbSpecification.getSpecName());
            }
            return R.create(super.page(page,wrapper));
        }
    }

    @Override
    public R<SpecificationVo> selectById(Long id) {
        //组合实体类
        SpecificationVo specificationVo=null;
        //规格
        TbSpecification tbSpecification = super.getById(id);
        if(null!=tbSpecification){
            //查询规格详情
            QueryWrapper<TbSpecificationOption> wrapper=new QueryWrapper<>();
            wrapper.lambda().eq(TbSpecificationOption::getSpecId,tbSpecification.getId());
            List<TbSpecificationOption> tbSpecificationOptions = tbSpecificationOptionMapper.selectList(wrapper);
            specificationVo=new SpecificationVo(tbSpecification,tbSpecificationOptions);
        }
        return R.create(specificationVo);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public R deleteByIds(List<Long> ids) {
        //删除规格详情
        QueryWrapper<TbSpecificationOption> wrapper=new QueryWrapper<>();
        wrapper.lambda().in(TbSpecificationOption::getSpecId,ids);
        int ret1=tbSpecificationOptionMapper.delete(wrapper);
        //删除规格
        boolean b = super.removeByIds(ids);
        return (ret1>=0 && b)?R.deleteSuccess():R.deleteFailed();
    }
}
