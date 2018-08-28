package com.esdnepr.DAO.repo.impl;

import com.esdnepr.DAO.Model.User;
import com.esdnepr.DAO.repo.UserDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public class UserDAOImpl implements UserDAO {

    private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void create(User user) {
        entityManager.persist(user);
        logger.info("User created");
    }

    @Override
    public void update(Long id, User user) {

        user.setId(id);
        entityManager.merge(user);
        logger.info("User updated");
    }

    @Override
    public void delete(Long id) {
        Query query = entityManager.createQuery("DELETE FROM User u WHERE u.id = :id");
            query.setParameter("id", id);
            query.executeUpdate();
    }

    @Override
    public List<User> getAll() {
        TypedQuery<User> getAllUsers =
                entityManager.createQuery("SELECT u FROM Users u", User.class);
        return getAllUsers.getResultList();
    }

    @Override
    public User get(Long id) {
        return entityManager.find(User.class, id);
    }
}
