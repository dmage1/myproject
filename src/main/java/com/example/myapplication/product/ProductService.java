package com.example.myapplication.product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final static Logger LOGGER = LoggerFactory.getLogger(ProductService.class.getName());

    @Autowired
    private ProductRepository repository;

    Product getProduct(int id) {
        LOGGER.info("getProduct({})", id);
        return repository.getProduct(id);
    }

    List<Product> getProducts() {
        LOGGER.info("getProducts()");
        return repository.getProducts();
    }
}
