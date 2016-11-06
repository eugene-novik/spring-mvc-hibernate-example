package com.netcracker.spring.controller;

import com.netcracker.spring.model.User;
import com.netcracker.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List<User> findAllUser() {

        return userService.findAllUser();

    }

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    public User findUser(@PathVariable int userId) {
        return userService.findUserById(userId);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public User addUser(User user) {
        return userService.addUser(user);
    }

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.DELETE)
    public void removeUser(@PathVariable int userId) {
        User user = userService.findUserById(userId);
        userService.removeUser(user);
    }


}
