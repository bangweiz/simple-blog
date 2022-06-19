package com.simpleblog.blog.vo;

public enum ErrorCode {

    PARAMS_ERROR(10001,"Invalid Params"),
    ACCOUNT_PWD_NOT_EXIST(10002,"No such account in record"),
    TOKEN_INVALID(10003, "Invalid Token"),
    ACCOUNT_EXISTS(10004, "Account Exists"),
    NO_PERMISSION(70001,"No permission"),
    SESSION_TIME_OUT(90001,"Timeout"),
    NO_LOGIN(90002,"No authentication"),;

    private int code;
    private String msg;

    ErrorCode(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
