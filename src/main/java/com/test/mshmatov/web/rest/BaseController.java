package com.test.mshmatov.web.rest;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public abstract class BaseController {
//
//    @ExceptionHandler(IrisException.class)
//    @ResponseBody
//    public <T extends IrisException> ErrorMessage irisExceptionHandler(T e, HttpServletResponse response) {
//        logger.warn("Exception :{}", e.getClass().getSuperclass(), e);
//        ErrorMessage mes = new ErrorMessage(e);
//        response.setStatus(mes.getStatus());
//        return mes;
//    }
//
//    @ExceptionHandler(IllegalArgumentException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ResponseBody
//    public ErrorMessage IllegalArgumentExceptionHandler(Exception e) {
//        logger.warn("Exception :{}", e.getClass().getSuperclass(), e);
//        return new ErrorMessage(HttpStatus.BAD_REQUEST, e);
//    }
//
//    @ExceptionHandler(MissingPathVariableException.class)
//    @ResponseBody
//    public ErrorMessage missingPathVariableException(MissingPathVariableException e, HttpServletResponse response) {
//        logger.warn("Exception :{}", e.getMessage());
//        response.setStatus(HttpStatus.NOT_FOUND.value());
//        return new ErrorMessage(HttpStatus.NOT_FOUND, e.getMessage());
//    }
//
//    @ExceptionHandler(HttpClientErrorException.class)
//    @ResponseBody
//    public ErrorMessage httpClientErrorHandler(HttpClientErrorException e, HttpServletResponse response) {
//        response.setStatus(e.getStatusCode().value());
//        ErrorMessage errorMessage = JsonConverter.deserializeJsonToObject(e.getResponseBodyAsString(), ErrorMessage.class, false);
//        return errorMessage == null ? new ErrorMessage(e.getStatusCode(), e) : errorMessage;
//    }
//
//    @ExceptionHandler(RuntimeException.class)
//    @ResponseBody
//    public <T extends RuntimeException> ErrorMessage runtimeHandler(T e, HttpServletRequest request, HttpServletResponse response) {
//        logger.error("Runtime Ex->{}", e.getClass().getSuperclass(), e);
//        if (response.getStatus() == HttpStatus.OK.value()) {
//            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
//        }
//
//        ErrorMessage mes = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, e);
//        if (e.getCause() instanceof IrisException) {
//            IrisException th = (IrisException) e.getCause();
//            mes.setArgs(th.getArgs());
//        }
//
//        return mes;
//    }

}
