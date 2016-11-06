package com.netcracker.spring.service;


import com.netcracker.spring.dao.PostDAOImp;
import com.netcracker.spring.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("PostService")
@Transactional
public class PostService {

    @Autowired
    private PostDAOImp daoImp;

    public Post addPost(Post post){
        return daoImp.create(post);
    }

    public Post findPostById(int id){
        return daoImp.read(id);
    }

    public void updatePost(Post post){
        daoImp.update(post);
    }

    public void removePost(Post post){
        daoImp.delete(post);
    }

    public List<Post> findAllPostsByUserId(int id){
        return daoImp.readAllPostByUserId(id);
    }


}
