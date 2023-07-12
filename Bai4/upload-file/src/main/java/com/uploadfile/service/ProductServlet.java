package com.uploadfile.service;

import com.uploadfile.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServlet implements IProductService{
    List<Product> products=new ArrayList<>();
    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update( Product product) {
        products.set(product.getId(), product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
