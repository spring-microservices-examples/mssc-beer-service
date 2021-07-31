package com.exaltpawarikanda.msscbeerservice.util;

import java.io.Serializable;


public class ApiResponse<T> implements Serializable {

    private static final long serialVersionUID = -0x32EA84E37FFB508EL;

    private String statusCode;
    private String message;
    private T responseBody;

    public ApiResponse() {
        statusCode = ApiConstants.StatusCodes.SUCCESS;
        message = ApiConstants.Messages.OK;
    }

    public ApiResponse(final String statusCode, final String message, final T responseBody) {
        this.statusCode = statusCode;
        this.message = message;
        this.responseBody = responseBody;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(T responseBody) {
        this.responseBody = responseBody;
    }
}