package com.MoneyMatch.dto.response;

public class ResponseDTO {

    private String errorCode;
    private String errorDescr;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorDescr() {
        return errorDescr;
    }

    public void setErrorDescr(String errorDescr) {
        this.errorDescr = errorDescr;
    }
}
