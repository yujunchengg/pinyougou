package com.bdwk.pinyougou.sellergoods.wrapper;

import com.alibaba.dubbo.rpc.RpcException;
import com.bdwk.pinyougou.common.enums.ResultEnum;

/**
 * 异常包装类
 */
public class ExceptionWrapper {

    public static RpcException wrap(ResultEnum resultEnum){
        return new RpcException(resultEnum.getCode(),resultEnum.getMsg());
    }
}
