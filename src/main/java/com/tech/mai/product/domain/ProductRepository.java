package com.tech.mai.product.domain;

import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

/**
 * Created by c0251411 on 17/07/2018.
 */
@Repository
public class ProductRepository {

    public Product findById(String id) {
        return id.equals("abc123") ? new Product("abc123", "Macbook", new BigDecimal("1499.99")) : null;
    }
}
