package com.bdwk.pinyougou.common.exception;

import com.bdwk.pinyougou.common.enums.ResultEnum;

/**
 * 自定义业务异常
 */
public class BizException extends RuntimeException{
    private int code;

    private BizException(){}
    private BizException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code=resultEnum.getCode();
    }
    private BizException(int code,String msg){
        super(msg);
        this.code=code;
    }

    public static BizException create(ResultEnum resultEnum){
        return new BizException(resultEnum);
    }

    public static BizException create(int code,String msg){
        return new BizException(code,msg);
    }

    public int getCode() {
        return code;
    }
}
