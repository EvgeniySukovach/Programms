package com.esdnepr.services.impl;

import com.esdnepr.DAO.Model.User;
import com.esdnepr.DAO.repo.UserDAO;
import com.esdnepr.services.DTO.UserDTO;
import com.esdnepr.services.UserService;
import com.esdnepr.services.convert.UserConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
 @Service
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;
    private UserConvert userConvert;
    @Autowired                         // without using Constructor (for learning)
    public void setUserDao(UserDAO userDao){
        this.userDAO = userDao;
    }
    @Autowired
    public void setUserConvert(UserConvert userConvert) {
        this.userConvert = userConvert;
    }

    @Override
    @Transactional
    public void create(UserDTO user) {
        userDAO.create(userConvert.toEntity(user));
    }

    @Override
    @Transactional
    public void update(Long id, UserDTO user) {
        userDAO.update(id, userConvert.toEntity(user));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        userDAO.delete(id);
    }

    @Override
    @Transactional
    public List<UserDTO> getAllUsers() {
        List<User> users =  userDAO.getAll();
        List<UserDTO> usersDTO = new ArrayList<>();
        for(User user: users){
            usersDTO.add(userConvert.toDto(user));
        }
        return usersDTO;
    }

    @Override
    @Transactional
    public UserDTO get(Long id) {
        return userConvert.toDto(userDAO.get(id));
    }
}
