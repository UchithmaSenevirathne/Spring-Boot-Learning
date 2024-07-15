package com.example.spcourse.test.Domain.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<String> handleStudentNotFoundException(StudentNotFoundException studentNotFoundException){
        log.error("student not found exception occurred");
        ResponseEntity<String> responseEntity = new ResponseEntity<>(studentNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
        return responseEntity;
    }
}
