package com.ecommerce.project.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

import static java.io.FileDescriptor.err;

@RestControllerAdvice//intercept exception thrown by any controller

public class myGlobalExceptionHandler
{
    @ExceptionHandler(MethodArgumentNotValidException.class)// method to handle specific
    public ResponseEntity<Map<String , String>> myMethodArgumentValidException(MethodArgumentNotValidException e)
    {
        Map<String, String> response = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach(err -> {
            String fieldName = ((FieldError) err).getField();
            String message = err.getDefaultMessage();
            response.put(fieldName, message);
        });

        return new ResponseEntity<Map<String,String>>(response,
            HttpStatus.BAD_REQUEST);
    }

    //creating own exception handler
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> myResorceNotFoundException(ResourceNotFoundException e)
    {
        String message = e.getMessage();
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(APIException.class)
    public ResponseEntity<String> myAPIException(APIException e)
    {
        String message = e.getMessage();
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }


}
