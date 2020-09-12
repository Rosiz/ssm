package com.gdpi.ssm.service;

import com.gdpi.ssm.domain.Product;

import java.util.List;

public interface IProductService {
    public List<Product> findAll() throws Exception;
    public void save(Product product);
    public Product select(String id);
    public void update(Product product);
    public void delete(String id);
}
