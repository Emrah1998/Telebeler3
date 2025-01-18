package com.postandpost_details.telebeler3.Exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.postandpost_details.telebeler3.Exception.ExceptionConstant.UNEXPECTED_EXCEPTION_CODE;
import static com.postandpost_details.telebeler3.Exception.ExceptionConstant.UNEXPECTED_EXCEPTION_MESSAGE;

@Slf4j
@RestControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionResponse handleException(Exception e) {
        log.error("Exception:",e);
        return new ExceptionResponse(UNEXPECTED_EXCEPTION_CODE,UNEXPECTED_EXCEPTION_MESSAGE);
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse handleNotFoundException(NotFoundException e) {
        log.error("NotFoundException:",e);
        return new ExceptionResponse(e.getCode(),e.getMessage());
    }

}
