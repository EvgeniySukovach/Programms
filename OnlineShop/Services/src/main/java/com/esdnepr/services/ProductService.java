package com.esdnepr.services;

import com.esdnepr.services.DTO.ProductDTO;

import java.util.List;

public interface ProductService {

    void create(ProductDTO product);
    void update(Long id, ProductDTO product);
    void delete(Long id);
    ProductDTO get(Long id);
    List<ProductDTO> getAll();




}
