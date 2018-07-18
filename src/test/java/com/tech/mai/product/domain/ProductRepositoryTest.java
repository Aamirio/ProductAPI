package com.tech.mai.product.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;


/**
 * Created by c0251411 on 17/07/2018.
 */
public class ProductRepositoryTest {

    ProductRepository repository = new ProductRepository();

    @Test
    public void getProductById() {
        String id = "abc123";

        Product product = repository.findById(id);

        assertNotNull(product);
        assertThat(product.getId()).isEqualTo(id);
        assertThat(product.getName()).isEqualTo("Macbook");
        assertThat(product.getRetailPrice().toString()).isEqualTo("1499.99");


    }

}