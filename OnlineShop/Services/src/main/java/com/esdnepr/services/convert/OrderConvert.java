package com.esdnepr.services.convert;

import com.esdnepr.DAO.Model.Order;
import com.esdnepr.services.DTO.OrderDTO;

public interface OrderConvert {
    Order toEntity(OrderDTO dto);
    OrderDTO toDto(Order entity);
}
