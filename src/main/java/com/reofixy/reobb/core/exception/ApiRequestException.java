package com.reofixy.reobb.core.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ApiRequestException extends RuntimeException {

    public ApiRequestException(String message){
        super(message);
    }

    public ApiRequestException(){
        super("Server error, your request can't allowed.");
    }
}
