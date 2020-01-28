package com.aroha.HRMSProject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FileNotFoundException extends RuntimeException {

    //private static final long serialVersionUID = 1 L;
	
	private long userid;
	public FileNotFoundException(long userid) {
	        super(String.format("user is not found with id : '%s'", userid));
	        }

    public FileNotFoundException(String message) {
        super(message);
    }

    public FileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
