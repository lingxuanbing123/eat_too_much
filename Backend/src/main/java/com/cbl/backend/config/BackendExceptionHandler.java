package com.cbl.backend.config;

import com.cbl.backend.utils.NewResult;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * newbee-mall全局异常处理
 */
@RestControllerAdvice
public class BackendExceptionHandler {

    @ExceptionHandler(BindException.class)
    public Object bindException(BindException e) {
        BindingResult bindingResult = e.getBindingResult();
        NewResult result = NewResult.error(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
        return result;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Object bindException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        NewResult result = NewResult.error(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
        return result;
    }

    @ExceptionHandler(Exception.class)
    public Object handleException(Exception e, HttpServletRequest req) {
        e.printStackTrace();
        NewResult result = NewResult.error("出现异常");
        return result;

    }
}
