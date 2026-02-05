package com.social.instagram.post.controller;

import com.social.instagram.common.response.BaseResponse;
import com.social.instagram.post.entity.Post;
import com.social.instagram.post.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService service;

    public PostController(PostService service) {
        this.service = service;
    }

    @PostMapping
    public BaseResponse<Post> create(@RequestBody Post post) {
        return BaseResponse.success(service.create(post));
    }

    @GetMapping
    public BaseResponse<List<Post>> getAll() {
        return BaseResponse.success(service.getAll());
    }
}
