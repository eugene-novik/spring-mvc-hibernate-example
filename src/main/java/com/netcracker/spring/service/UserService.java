package com.netcracker.spring.service;

import com.netcracker.spring.dao.UserDAOImp;
import com.netcracker.spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("UserService")
@Transactional
public class UserService {

    @Autowired
    private UserDAOImp daoImp;

    public User addUser(User user) {
        return daoImp.create(user);
    }

    public void updateUser(User user) {
        daoImp.update(user);
    }

    public void removeUser(User user) {
        daoImp.delete(user);
    }

    public List<User> findAllUser() {
        return daoImp.readAllUser();
    }

    public User findUserById(int id) {
        return daoImp.read(id);
    }

}
