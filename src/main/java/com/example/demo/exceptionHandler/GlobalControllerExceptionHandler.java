package com.example.demo.exceptionHandler;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(GlobalControllerExceptionHandler.class);

    @ExceptionHandler(value = {MethodArgumentTypeMismatchException.class, MissingServletRequestParameterException.class})
    public ResponseEntity handleInvalidArgumentException() {
        logger.error("#######catch exception - parameter is invalid");
        return new ResponseEntity(JsonNodeFactory.instance.objectNode().put("errorMsg", "parameter is invalid"),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {NoSuchElementException.class})
    public ResponseEntity handleNoSuchElementException() {
        logger.error("#######catch exception - NoSuchElementException");
        return new ResponseEntity(JsonNodeFactory.instance.objectNode().put("errorMsg", "resource is not exist"),
                HttpStatus.NOT_FOUND);
    }

}
