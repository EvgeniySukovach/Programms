package com.esdnepr.DAO.repo;

import com.esdnepr.DAO.Model.Order;
import com.esdnepr.DAO.Model.User;

import java.util.List;

public interface OrderDAO {

    void create(Order order);
    void update(Long id, Order order );
    void delete(Long id);
    Order get(Long id);
    List<Order> getAll();
    List<Order> getUserOrders(User user);
}
