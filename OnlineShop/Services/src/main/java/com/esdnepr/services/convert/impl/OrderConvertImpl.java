package com.esdnepr.services.convert.impl;

import com.esdnepr.DAO.Model.Order;
import com.esdnepr.services.DTO.OrderDTO;
import com.esdnepr.services.convert.OrderConvert;

public class OrderConvertImpl implements OrderConvert {

   @Override
    public Order toEntity(OrderDTO dto) {
        return new Order(dto.getUser(), dto.getProducts(), dto.getStatus(), dto.getDate(), null);
    }

    @Override
    public OrderDTO toDto(Order entity) {
        return new OrderDTO(entity.getUser(), entity.getProducts(), entity.getStatus(), entity.getDate());
    }
}
