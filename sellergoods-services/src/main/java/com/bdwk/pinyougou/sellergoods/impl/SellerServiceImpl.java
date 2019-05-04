package com.bdwk.pinyougou.sellergoods.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bdwk.pinyougou.common.enums.SellerStatus;
import com.bdwk.pinyougou.common.http.R;
import com.bdwk.pinyougou.common.util.Checker;
import com.bdwk.pinyougou.dao.mapper.TbSellerMapper;
import com.bdwk.pinyougou.entity.pojo.TbSeller;
import com.bdwk.pinyougou.sellergoods.service.ISellerService;
import com.google.common.base.Strings;
import lombok.extern.slf4j.Slf4j;

@Service(protocol = {"dubbo"},validation = "true",version ="1.0.0",timeout = 3000)
@Slf4j
public class SellerServiceImpl extends ServiceImpl<TbSellerMapper, TbSeller> implements ISellerService {

    @Override
    public R updateStatusById(String id, String status) {
        return this.baseMapper.updateStatusById(id,status)>0?R.updateSuccess():R.updateFailed();
    }

    @Override
    public R add(TbSeller tbSeller) {
        return super.save(tbSeller)?R.addSuccess():R.addFailed();
    }


    @Override
    public R<TbSeller> selectById(String id) {
        return R.create(super.getById(id));
    }

    @Override
    public R<IPage<TbSeller>> page(Long current,Long rows, String status) {
        Page<TbSeller> page = new Page<>(current, rows);
        QueryWrapper<TbSeller> wrapper=new QueryWrapper<>();
        wrapper.lambda().eq(TbSeller::getStatus,status);
        wrapper.lambda().orderByDesc(TbSeller::getCreateTime);
        return R.create(super.page(page,wrapper));
    }

    @Override
    public R<IPage<TbSeller>> page(Long current,Long rows,String status,TbSeller tbSeller) {
        Page<TbSeller> page = new Page<>(current, rows);
        //条件
        QueryWrapper<TbSeller> wrapper=new QueryWrapper<>();
        if(null==tbSeller || Strings.isNullOrEmpty(status)){
            wrapper.lambda().orderByDesc(TbSeller::getCreateTime);
        }else {
            wrapper.lambda().eq(TbSeller::getStatus,status);
            //未审核按照注册时间排序，其他按照审核时间排序
            if(Checker.eq(SellerStatus.HAS_NOT_CHECK,status)){
                wrapper.lambda().orderByDesc(TbSeller::getCreateTime);
            }else {
                wrapper.lambda().orderByDesc(TbSeller::getCheckTime);
            }
            if(!Strings.isNullOrEmpty(tbSeller.getName())){
                wrapper.lambda().like(TbSeller::getName,tbSeller.getName());
            }
            if(!Strings.isNullOrEmpty(tbSeller.getNickName())){
                wrapper.lambda().like(TbSeller::getNickName,tbSeller.getNickName());
            }
        }
        return R.create(super.page(page,wrapper));
    }
}
