package com.tech.mai.product.web;

import com.tech.mai.product.domain.Product;
import com.tech.mai.product.domain.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Provisions service endpoints and handles all requests
 */
@RestController
public class ProductController {

    @Autowired
    ProductRepository repository;

    @GetMapping(path = "/product/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Product getProduct(@PathVariable String id) {
        Product product = repository.findById(id);
        if (product == null)  {
            throw new ProductNotFoundException(String.format("Product not found for %s", id));
        }
        return product;
    }
}
