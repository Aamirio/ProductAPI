package com.tech.mai.product.web;

public class Error {

    private String description;

    private int code;

    public Error(String description, int code) {
        this.description = description;
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public int getCode() {
        return code;
    }
}
