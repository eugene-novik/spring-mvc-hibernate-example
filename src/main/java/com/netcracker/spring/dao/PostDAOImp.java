package com.netcracker.spring.dao;

import com.netcracker.spring.model.Post;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("PostRepository")
public class PostDAOImp extends AbstractDAOImp<Integer, Post> {

    protected PostDAOImp() {
        super(Post.class);
    }

    public List<Post> readAllPostByUserId(int id) {
        Query<Post> query = getSession().createQuery("SELECT p FROM posts p where p.user.id = :userId", Post.class);
        query.setParameter("userId", id);

        return query.list();
    }
}
