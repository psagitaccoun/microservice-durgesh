package com.kiran.userservice.exception;

import com.kiran.userservice.payload.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobaleException {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception){
        ErrorDetails errorDetailsResponse = ErrorDetails.builder().message(exception.getMessage()).status(HttpStatus.NOT_FOUND).succes(true).build();
   return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDetailsResponse);
    }


}
