package com.esdnepr.DAO.repo;

import com.esdnepr.DAO.Model.User;

import java.util.List;

public interface UserDAO {

    void create(User user);
    void update(Long id, User user);
    void delete(Long id);
    List<User> getAll();
    User get(Long id);
}
