package com.esdnepr.services.impl;

import com.esdnepr.DAO.Model.Product;
import com.esdnepr.DAO.repo.ProductDAO;
import com.esdnepr.services.DTO.ProductDTO;
import com.esdnepr.services.ProductService;
import com.esdnepr.services.convert.ProductConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductDAO productDAO;
    private final ProductConvert productConvert;

    @Autowired
    ProductServiceImpl(ProductDAO productDAO, ProductConvert productConvert) {
        this.productDAO = productDAO;
        this.productConvert = productConvert;
    }

    @Override
    @Transactional
    public void create(ProductDTO product) {
        productDAO.create(productConvert.toEntity(product));
    }

    @Override
    @Transactional
    public void update(Long id, ProductDTO product) {
        productDAO.update(id, productConvert.toEntity(product));
    }

    @Override
    public void delete(Long id) {
        productDAO.delete(id);
    }

    @Override
    public ProductDTO get(Long id) {
        return productConvert.toDto(productDAO.get(id));

    }

    @Override
    public List<ProductDTO> getAll() {
        List<Product> products = productDAO.getAll();
        List<ProductDTO> productsDTO = new ArrayList<>();
        for(Product product: products){
            productsDTO.add(productConvert.toDto(product));
        }
        return productsDTO;
    }
}
