package com.jfredricks.filecontenttree.web.helper;

import java.util.Date;

public class ErrorResponse {
    private Date timestamp;
    private int status;
    private String exception;
    private String message;
    private String path;


    public ErrorResponse() {

    }

    public ErrorResponse(int status, String message, Date timestamp, String path, String exception) {
        this.timestamp = timestamp;
        this.status = status;
        this.exception = exception;
        this.message = message;
        this.path = path;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
