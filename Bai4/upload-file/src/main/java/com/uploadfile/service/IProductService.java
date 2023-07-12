package com.uploadfile.service;

import com.uploadfile.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    void save(Product product);
    Product findById(int id);
    void update(Product product);
    void remove(int id);
}
