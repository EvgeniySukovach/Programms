package com.esdnepr.services.convert.impl;

import com.esdnepr.DAO.Model.Product;
import com.esdnepr.services.DTO.ProductDTO;
import com.esdnepr.services.convert.ProductConvert;
import org.springframework.stereotype.Component;

@Component
public class ProductConvertImpl implements ProductConvert {
    @Override
    public Product toEntity(ProductDTO dto) {
        return new Product(null, dto.getName(), dto.getCategory(),
                dto.getParameter(), dto.getCount(), dto.getPrice() );
    }

    @Override
    public ProductDTO toDto(Product entity) {
        return new ProductDTO(entity.getName(), entity.getCategory(),
                entity.getParameter(), entity.getCount(), entity.getPrice());

    }
}
