package com.social.instagram.post.controller;

import com.social.instagram.common.response.BaseResponse;
import com.social.instagram.post.entity.Post;
import com.social.instagram.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private  PostService service;

    @PostMapping
    public BaseResponse<Post> create(@RequestBody Post post) {
        return BaseResponse.success(service.create(post));
    }

    @GetMapping
    public BaseResponse<List<Post>> getAll() {
        return BaseResponse.success(service.getAll());
    }
    @GetMapping("/user/{userId}")
    public BaseResponse<List<Post>> getPostByrUserId(@PathVariable Long userId) {
        return BaseResponse.success(service.getPostByrUserId(userId));
    }

    @PostMapping("/delete/{postId}")
    public  BaseResponse deletePost(@PathVariable Long postId){
        service.deletePost(postId);
        return BaseResponse.success(null);
    }
    @GetMapping("/{postId}")
    public BaseResponse<Post> getPost(@PathVariable Long postId) {
        return BaseResponse.success(service.getPost(postId));
    }
}
