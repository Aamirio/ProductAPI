package com.tech.mai.product.web;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {ProductNotFoundException.class})
    protected ResponseEntity<Error> handle(ProductNotFoundException ex) {

        // Change the response to use the correct status code
        // The response body is a JSON encoded Error
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new Error(ex.getMessage(), ex.getCode()));
    }

}
