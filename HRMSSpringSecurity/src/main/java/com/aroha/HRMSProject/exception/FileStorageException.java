package com.aroha.HRMSProject.exception;

public class FileStorageException extends RuntimeException {

    //private static final long serialVersionUID = 1 L;

    public FileStorageException(String message) {
        super(message);
    }

    public FileStorageException(String message, Throwable cause) {
        super(message, cause);
    }
}