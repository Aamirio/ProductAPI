package com.tech.mai.product.web;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {ProductNotFoundException.class})
    protected ResponseEntity<Object> handleProductNotFoundException(RuntimeException ex, WebRequest request) {

        // Cast the exception to Domain Exception
        // Note - spring guarantees the exception passed here matches the annotation
        ProductNotFoundException pEx = (ProductNotFoundException) ex;

        // Change the response to use the correct status code
        // The response body is a JSON encoded Error
        return handleExceptionInternal(pEx, new Error(pEx.getMessage(), pEx.getCode()),
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

}
