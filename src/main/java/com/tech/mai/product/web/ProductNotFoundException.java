package com.tech.mai.product.web;

/**
 * Created by c0251411 on 18/07/2018.
 */
public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(String message) {
        super(message);
    }

    public int getCode() {
        return 400001;
    }
}
