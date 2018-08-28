package com.esdnepr.DAO.repo.impl;

import com.esdnepr.DAO.Model.Product;
import com.esdnepr.DAO.repo.ProductDAO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductDAOImpl implements ProductDAO {

    private final Map<Long, Product> productMap = new HashMap<>();
    private static volatile long idGenerator = 1l;

    @Override
    public void create(Product product) {
        product.setId(idGenerator);
        productMap.put(product.getId(), product);
    }

    @Override
    public void update(Long id, Product product) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Product> getAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public Product get(Long id) {
        return null;

    }
}
