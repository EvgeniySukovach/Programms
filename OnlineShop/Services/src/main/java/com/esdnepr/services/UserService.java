package com.esdnepr.services;

import com.esdnepr.services.DTO.UserDTO;

import java.util.List;

public interface UserService {

    void create(UserDTO user);
    void update(Long id, UserDTO user);
    void delete(Long id);
    List<UserDTO> getAllUsers();
    UserDTO get(Long id);

}
