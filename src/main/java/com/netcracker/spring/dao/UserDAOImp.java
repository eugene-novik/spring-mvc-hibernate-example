package com.netcracker.spring.dao;

import com.netcracker.spring.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("UserRepository")
public class UserDAOImp extends AbstractDAOImp<Integer, User> {

    protected UserDAOImp() {
        super(User.class);
    }

    public List<User> readAllUser() {
        return getSession().createQuery("from users", User.class).list();
}

}
