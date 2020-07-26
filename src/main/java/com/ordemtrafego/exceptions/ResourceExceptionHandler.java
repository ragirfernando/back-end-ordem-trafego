package com.ordemtrafego.exceptions;

import com.ordemtrafego.error.StandardError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest httpServletRequest){
        String error = "Resource not found";
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        StandardError standardError = new StandardError(Instant.now(), httpStatus.value(), error, e.getMessage(), httpServletRequest.getRequestURI());

        return ResponseEntity.status(httpStatus).body(standardError);
    }
}
