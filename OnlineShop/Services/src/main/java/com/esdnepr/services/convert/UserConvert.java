package com.esdnepr.services.convert;

import com.esdnepr.DAO.Model.User;
import com.esdnepr.services.DTO.UserDTO;

public interface UserConvert {

    User toEntity(UserDTO dto);
    UserDTO toDto(User entity);

}
