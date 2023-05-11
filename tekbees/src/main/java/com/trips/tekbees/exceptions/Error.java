package com.trips.tekbees.exceptions;

import org.springframework.http.HttpStatus;

public class Error {
    private HttpStatus status;
    private int code;
    private String message;

    public Error(int code, String message) {
        this.code = code;
        this.message = message;
    }
    public Error(HttpStatus status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
