package edu.mum.cs545.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason="error saving")
public class SaveErrorException extends RuntimeException{
    private String message;
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public SaveErrorException(String message) {
        this.message = message;
    }
    
}