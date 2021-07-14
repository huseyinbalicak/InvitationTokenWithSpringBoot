package com.blck.springdemo.exception;

public class AppRuntimeException extends RuntimeException {
    public AppRuntimeException(String i18n) {
        super(i18n);
    }
}
