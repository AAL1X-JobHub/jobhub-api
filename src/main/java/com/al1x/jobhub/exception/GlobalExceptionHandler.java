package com.al1x.jobhub.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public CustomErrorDetails resourceNotFound(ResourceNotFoundException ex) {
        CustomErrorDetails errorDetails = new CustomErrorDetails();
        errorDetails.setTitle("Resource not found");
        errorDetails.setStatus(404);
        errorDetails.setDetail(ex.getMessage());
        return errorDetails;
    }

}
