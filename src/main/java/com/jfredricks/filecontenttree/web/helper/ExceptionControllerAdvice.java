package com.jfredricks.filecontenttree.web.helper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;

@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(IOException.class)
    public ResponseEntity<ErrorResponse> exceptionResponse(HttpServletRequest request, Exception ex) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), new Date(), request.getRequestURI(), ex.getClass().getName());
        return new ResponseEntity<>(errorResponse ,HttpStatus.BAD_REQUEST);
    }
}
