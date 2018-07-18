package com.tech.mai.product.domain;

import java.math.BigDecimal;

/**
 * Created by c0251411 on 17/07/2018.
 */
public class Product {
    private final BigDecimal retailPrice;
    private final String id;
    private final String name;

    public Product(String id, String name, BigDecimal retailPrice) {
        this.id = id;
        this.name = name;
        this.retailPrice = retailPrice;
    }

    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
