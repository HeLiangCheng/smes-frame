package com.hlc.styd.smes.frame.sb.exception;

import com.hlc.styd.smes.frame.sb.constant.SmesConstant;
import com.hlc.styd.smes.frame.sb.dto.RespDto;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Liang on 2018/11/27.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = SmesException.class)
    @ResponseBody
    public RespDto<String> jsonErrorHandler(HttpServletRequest req, SmesException e) throws Exception {
        RespDto<String> errorInfo = new RespDto<>();
        errorInfo.setRspDesc(e.getMessage());
        errorInfo.setRspCode(SmesConstant.ERROE_CODE);
        errorInfo.setData(e.getMessage());
        return errorInfo;
    }

}
