package com.esdnepr.WEB.controllers;

import com.esdnepr.services.DTO.UserDTO;
import com.esdnepr.services.UserService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final static Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody UserDTO user){
        log.info("Create user: {}", user);
        userService.create(user);
    }
    @RequestMapping(value = "{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id){
        log.info("Delete user id: {}", id);
        userService.delete(id);
    }
    @RequestMapping(value = "{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void update(@PathVariable("id") Long id, @RequestBody UserDTO user){
        log.info("Update user id : {}, data: {}", id, user);
        userService.update(id, user);
    }
    @RequestMapping(value = "(id)", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public void get(@PathVariable("id") Long id){
        log.info("Get user by id: {}", id);
        userService.get(id);
    }
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody  List<UserDTO> getAllUsers(){
        log.info("Get all users");
        return userService.getAllUsers();
    }
}
