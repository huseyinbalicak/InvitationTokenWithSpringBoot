package com.blck.springdemo.exception;

public enum AppExceptionType {
	
	BAD_REQUEST("bad.request");

    String i18n;
    AppExceptionType(String i18n) {
        this.i18n = i18n;
    }

    public String getI18n() {
        return i18n;
    }

}
