package com.esdnepr.DAO.repo.impl;

import com.esdnepr.DAO.Model.Product;
import com.esdnepr.DAO.repo.ProductDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductDAOImpl implements ProductDAO {

        private static final Logger logger = LoggerFactory.getLogger(ProductDAOImpl.class);

        @PersistenceContext
        private EntityManager entityManager;


    @Override
    public void create(Product product) {
       entityManager.persist(product);
        logger.info("Product created");
    }

    @Override
    public void update(Long id, Product product) {
        entityManager.merge(product);
        product.setId(id);
        logger.info("Product updated");
    }

    @Override
    public void delete(Long id) {

        Query query = entityManager.createQuery("DELETE FROM  Product p WHERE p.id = :id ");
        query.setParameter("id",id);
        query.executeUpdate();
        logger.info("Product removed");

    }

    @Override
    public List<Product> getAll() {
        TypedQuery<Product> getAll =
        entityManager.createQuery("SELECT p FROM Product p", Product.class);

        return getAll.getResultList() ;
    }

    @Override
    public Product get(Long id) {
        return entityManager.find(Product.class, id);
    }
}
