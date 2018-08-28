package com.esdnepr.DAO.repo;

import com.esdnepr.DAO.Model.Product;

import java.util.List;

public interface ProductDAO {
    void create(Product product);
    void update(Long id, Product product);
    void delete(Long id);
    Product get(Long id);
    List<Product> getAll();
}
