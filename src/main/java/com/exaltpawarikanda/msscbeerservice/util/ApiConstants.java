package com.exaltpawarikanda.msscbeerservice.util;

import org.springframework.http.HttpStatus;

public interface ApiConstants {

    interface StatusCodes {
        String SUCCESS = HttpStatus.OK.toString();
        String CREATED = HttpStatus.CREATED.toString();
        String NO_CONTENT = HttpStatus.NO_CONTENT.toString();
        String NOT_FOUND = HttpStatus.NOT_FOUND.toString();
        String SERVER_ERROR = HttpStatus.INTERNAL_SERVER_ERROR.toString();
        String UNAUTHORIZED = HttpStatus.UNAUTHORIZED.toString();
        String UNACCEPTABLE = HttpStatus.NOT_ACCEPTABLE.toString();
    }

    interface Messages {
        String OK = "OK";
        String CREATED = "CREATED";
        String NO_CONTENT = "NO_CONTENT";
        String ACCESS_DENIED = "Access Denied";
        String NOT_FOUND = "Not Found";
        String UNAUTHORIZED = "Login Error : Unauthorized";
    }

    interface TokenConstants {
        String DATE_CREATED = "created";
        String USERNAME = "sub";
    }

    interface Defaults {
        String DEFAULT_DATE_FORMAT_FROM_UI = "dd-MM-yyyy";
        String DEFAULT_DATETIME_FORMAT_FROM_UI = "dd-MM-yyyy'T'HH:mm:ss";
    }
}
