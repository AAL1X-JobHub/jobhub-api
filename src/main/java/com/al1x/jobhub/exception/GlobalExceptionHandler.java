package com.al1x.jobhub.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomErrorResponse> handleModelNotFoundException(ResourceNotFoundException ex) {
        CustomErrorResponse errorDetails = new CustomErrorResponse();
        errorDetails.setTitle("Resource not found");
        errorDetails.setStatus(404);
        errorDetails.setDetails(ex.getMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<CustomErrorResponse> handleModelNotFoundException(BadRequestException ex){
        CustomErrorResponse errorDetails = new CustomErrorResponse();
        errorDetails.setTitle("Bad request");
        errorDetails.setStatus(400);
        errorDetails.setDetails(ex.getMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public ResponseEntity<CustomErrorResponse> handleMembershipAlreadyExistsException(ResourceAlreadyExistsException ex) {
        CustomErrorResponse errorDetails = new CustomErrorResponse();
        errorDetails.setTitle("Resource already exists");
        errorDetails.setStatus(400);
        errorDetails.setDetails(ex.getMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomErrorResponse> handleAllException(Exception ex){
        CustomErrorResponse errorDetails = new CustomErrorResponse();
        errorDetails.setTitle("Internal Server Error");
        errorDetails.setStatus(500);
        errorDetails.setDetails(ex.getMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        String msg = ex.getBindingResult().getFieldErrors().stream()
                .map(e -> e.getField().concat(":").concat(e.getDefaultMessage())
                ).collect(Collectors.joining(","));

        CustomErrorResponse errorDetails = new CustomErrorResponse();
        errorDetails.setTitle("Validation Error");
        errorDetails.setStatus(400);
        errorDetails.setDetails(msg);

        return new ResponseEntity<>(errorDetails, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}