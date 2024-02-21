package com.hotelservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String,Object>> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest){
        HashMap<String, Object> detalis = new HashMap<>();
        detalis.put("exception",exception.getMessage());
        detalis.put("status", HttpStatus.NOT_FOUND);
        detalis.put("success",false);
        detalis.put("webRequest",webRequest.getDescription(false));

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(detalis);

    }
}
