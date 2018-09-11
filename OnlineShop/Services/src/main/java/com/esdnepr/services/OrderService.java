package com.esdnepr.services;

import com.esdnepr.services.DTO.OrderDTO;
import com.esdnepr.services.DTO.UserDTO;

import java.util.List;

public interface OrderService {

    void create(OrderDTO order);
    void update(Long id, OrderDTO order);
    void delete(Long id);
    OrderDTO get(Long id);
    List<OrderDTO> getAll();
    List<OrderDTO> getUserOrders(UserDTO user);
}
