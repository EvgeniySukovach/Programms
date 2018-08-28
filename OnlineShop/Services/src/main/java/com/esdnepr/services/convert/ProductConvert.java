package com.esdnepr.services.convert;

import com.esdnepr.DAO.Model.Product;
import com.esdnepr.services.DTO.ProductDTO;

public interface ProductConvert {

    Product toEntity(ProductDTO dto);
    ProductDTO toDto(Product entity);
}
