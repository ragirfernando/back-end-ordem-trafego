package com.ordemtrafego.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNorFoundExcepition extends RuntimeException{
    public ResourceNorFoundExcepition(String message) {
        super(message);
    }
}
