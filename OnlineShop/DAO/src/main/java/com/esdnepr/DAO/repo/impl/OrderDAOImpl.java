package com.esdnepr.DAO.repo.impl;

import com.esdnepr.DAO.Model.Order;
import com.esdnepr.DAO.Model.User;
import com.esdnepr.DAO.repo.OrderDAO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class OrderDAOImpl implements OrderDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public OrderDAOImpl() {
    }

    @Override
    @Transactional
    public void create(Order order) {
        entityManager.persist(order);
        order.setStatus("Order created");
    }

    @Override
    public void update(Long id, Order order) {
        order.setId(id);
        entityManager.merge(order);
        order.setStatus("Order changed");
    }

    @Override
    public void delete(Long id) {
        Query query = entityManager.createQuery("DELETE FROM Order o WHERE o.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
         }

    @Override
    public Order get(Long id) {
        return entityManager.find(Order.class, id) ;
    }

    @Override
    public List<Order> getAll() {
        TypedQuery<Order> getAll = entityManager.createQuery("SELECT o FROM Order o", Order.class);
        return getAll.getResultList();
    }

    @Override
    public List<Order> getUserOrders(User user) {

        TypedQuery<Order> getUserOrders = entityManager.createQuery("SELECT o FROM Order o WHERE o.user = :user", Order.class);
        return getUserOrders.getResultList();
    }
}
