package com.netcracker.spring.controller;

import com.netcracker.spring.model.Post;
import com.netcracker.spring.model.User;
import com.netcracker.spring.service.PostService;
import com.netcracker.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {


    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;


    @RequestMapping(value = "/post/{userId}", method = RequestMethod.GET)
    public List<Post> findAllPost(@PathVariable int userId) {
        return postService.findAllPostsByUserId(userId);
    }

    @RequestMapping(value = "/post/{userId}/{name}", method = RequestMethod.POST)
    public Post addPost(@PathVariable("userId") int userId, @PathVariable("name") String name) {
        User user = userService.findUserById(userId);

        Post post = new Post();

        post.setUser(user);
        post.setName(name);

        return postService.addPost(post);

    }

    @RequestMapping(value = "/post/{postId}", method = RequestMethod.DELETE)
    public void removePost(@PathVariable int postId) {
        Post post = postService.findPostById(postId);
        postService.removePost(post);

    }

}
