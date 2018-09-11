package com.esdnepr.services.impl;

import com.esdnepr.DAO.Model.Order;
import com.esdnepr.DAO.Model.Product;
import com.esdnepr.DAO.repo.OrderDAO;
import com.esdnepr.DAO.repo.ProductDAO;
import com.esdnepr.DAO.repo.UserDAO;
import com.esdnepr.services.DTO.OrderDTO;
import com.esdnepr.services.DTO.UserDTO;
import com.esdnepr.services.OrderService;
import com.esdnepr.services.convert.OrderConvert;
import com.esdnepr.services.convert.UserConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderDAO orderDAO;
    private final OrderConvert orderConvert;
    private final UserConvert userConvert;
    private final ProductDAO productDAO;
    private final UserDAO userDAO;
    @Autowired
    public OrderServiceImpl(OrderDAO orderDAO, OrderConvert orderConvert, UserConvert userConvert, ProductDAO productDAO, UserDAO userDAO) {
        this.orderDAO = orderDAO;
        this.orderConvert = orderConvert;
        this.userConvert = userConvert;
        this.productDAO = productDAO;
        this.userDAO = userDAO;
    }

     @Override
     @Transactional
    public void create(OrderDTO order) {
        orderDAO.create(orderConvert.toEntity(order));
    }

    @Override
    @Transactional
    public void update(Long id, OrderDTO order) {
        orderDAO.update(id, orderConvert.toEntity(order) );
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Order order = orderDAO.get(id);
        Set<Product> productsInOrder = order.getProducts();

        for (Product product: productsInOrder) {
            product.getOrders().remove(order);
            productDAO.update(product.getId(), product);
        }
        order.setStatus("deleted");
        orderDAO.delete(id);
    }

    @Override
    @Transactional
    public OrderDTO get(Long id) {
        return null;
    }

    @Override
    @Transactional
    public List<OrderDTO> getAll() {
        return null;
    }

    @Override
    @Transactional
    public List<OrderDTO> getUserOrders(UserDTO user) {
    return null;
    }
}
