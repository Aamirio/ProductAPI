package com.tech.mai.product.web;

import com.tech.mai.product.domain.Product;
import com.tech.mai.product.domain.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Provisions service endpoints and handles all requests
 */
@RestController
public class ProductController {

    @Autowired
    ProductRepository repository;
    private String errorMsg;

    @GetMapping(path = "/product/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Product getProduct(@PathVariable String id) {
        Product product = repository.findById(id);
        if (product == null)  {
            errorMsg = String.format("Product not found for %s", id);
            throw new ProductNotFoundException(errorMsg);
        }
        return product;
    }

    @ExceptionHandler( {ProductNotFoundException.class} )
    @ResponseBody
    public ResponseEntity<Error> handleException() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Error(errorMsg, 400001));
    }
}
