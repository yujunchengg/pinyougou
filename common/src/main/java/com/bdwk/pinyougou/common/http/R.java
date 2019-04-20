package com.bdwk.pinyougou.common.http;

import com.bdwk.pinyougou.common.enums.ResultEnum;

import java.io.Serializable;

/**
 * 高复用响应体对象
 * @param <T>
 */
public class R<T> implements Serializable {
    private static final long serialVersionUID = -2780429836888099489L;
    private int code;
    private String msg;
    private T data;

    private R(){}

    private R(int code,String msg){
        this.code=code;
        this.msg=msg;
    }

    private R(int code,String msg,T data){
        this.code=code;
        this.msg=msg;
        this.data=data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static R create(Integer code, String msg) {
        return new R(code,msg);
    }
    public static <T> R create(Integer code, String msg, T data) {
        return new R(code,msg,data);
    }
    public static R create(ResultEnum resultEnum) {
        return create(resultEnum.getCode(),resultEnum.getMsg());
    }
    public static <T> R create(ResultEnum resultEnum, T data) {
        return create(resultEnum.getCode(),resultEnum.getMsg(),data);
    }
    public static <T> R create(T data) {
        return create(ResultEnum.OK,data);
    }
}
