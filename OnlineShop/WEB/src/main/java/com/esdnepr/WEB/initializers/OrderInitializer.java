package com.esdnepr.WEB.initializers;


import com.esdnepr.DAO.Model.Order;
import com.esdnepr.DAO.Model.Product;
import com.esdnepr.DAO.repo.OrderDAO;
import com.esdnepr.DAO.repo.ProductDAO;
import com.esdnepr.DAO.repo.UserDAO;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Component
public class OrderInitializer implements ApplicationListener<ContextRefreshedEvent> {
   private final OrderDAO orderDAO;
   private final ProductDAO productDAO;
   private final UserDAO userDAO;

    public OrderInitializer(OrderDAO orderDAO, ProductDAO productDAO, UserDAO userDAO) {
        this.orderDAO = orderDAO;
        this.productDAO = productDAO;
        this.userDAO = userDAO;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        Set<Product> products = new HashSet<>();

        products.add(productDAO.get(1L));
        products.add(productDAO.get(2L));
        products.add(productDAO.get(3L));
        orderDAO.create(new Order(userDAO.get(1L), products, "initialized", new Date(2017-1900, 10, 12), null));
        orderDAO.create(new Order(userDAO.get(1L), products, "initialized", new Date(2017-1900, 11, 12), null));
        orderDAO.create(new Order(userDAO.get(1L), products, "initialized", new Date(2017-1900, 11, 18), null));

        products.remove(productDAO.get(2L));

        orderDAO.create(new Order(userDAO.get(2L), products, "initialized", new Date(2017-1900, 11, 18), null));
        orderDAO.create(new Order(userDAO.get(2L), products, "initialized", new Date(2018-1900, 1, 8), null));
    }

}
