package com.user.constant;

public enum LoginConstant {

    LOGIN_SUCCESS_SIGN("log_success_sign");

    private String value;

    LoginConstant(String value) {

        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
