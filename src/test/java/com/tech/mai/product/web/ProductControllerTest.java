package com.tech.mai.product.web;

import com.tech.mai.product.domain.Product;
import com.tech.mai.product.domain.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

/**
 * Created by c0251411 on 17/07/2018.
 */
@RunWith(MockitoJUnitRunner.class)
public class ProductControllerTest {

    @InjectMocks
    ProductController productController;

    @Mock
    ProductRepository repository;

    @Test
    public void getProduct_byValidId_shouldReturnProduct() {

        String id = "bcd234";
        String name = "White iPad 250GB";
        String price = "149.99";

        when(repository.findById(id))
                .thenReturn(new Product(id, name, new BigDecimal(price)));

        Product product = productController.getProduct(id);

        assertNotNull(product);
        assertThat(product.getId()).isEqualTo(id);
        assertThat(product.getName()).isEqualTo(name);
        assertThat(product.getRetailPrice()).isEqualTo(price);
    }

    @Test(expected = ProductNotFoundException.class)
    public void getProduct_byInvalidId_shouldReturnError() {

        String id = "bcd234";

        when(repository.findById(anyString()))
                .thenReturn(null);

        productController.getProduct(id);
    }
}
