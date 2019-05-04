package com.bdwk.pinyougou.exception.handler;

import com.bdwk.pinyougou.common.enums.ResultEnum;
import com.bdwk.pinyougou.common.exception.BizException;
import com.bdwk.pinyougou.common.http.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

/**
 * 全局异常处理类
 */
@ControllerAdvice
@Slf4j
@Order(10000)
public class GlobalExceptionHandler {

    GlobalExceptionHandler(){
        log.info("GlobalExceptionHandler is executed.................");
    }

    /**
     * 处理自定义业务异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = {BizException.class})
    @ResponseBody
    public R hand(BizException e){
        log.info("GlobalExceptionHandler.hand(BizException e) is excuted ..........");
        return R.create(e.getCode(),e.getMessage());
    }


    /**
     * 处理参数类型不匹配的异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = {MethodArgumentTypeMismatchException.class})
    @ResponseBody
    public R hand(MethodArgumentTypeMismatchException e){
        log.info("GlobalExceptionHandler.hand(MethodArgumentTypeMismatchException e) is excuted ..........");
        return R.create(ResultEnum.ARGUMENTTYPEMISMATCH);
    }

}
