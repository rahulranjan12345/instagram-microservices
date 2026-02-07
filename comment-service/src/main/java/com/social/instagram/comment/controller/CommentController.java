package com.social.instagram.comment.controller;

import com.social.instagram.common.response.BaseResponse;
import com.social.instagram.comment.entity.Comment;
import com.social.instagram.comment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping
    public BaseResponse<Comment> create(@RequestBody Comment comment) {
        return BaseResponse.success(commentService.addComment(comment));
    }

    @GetMapping("/post/{postId}")
    public BaseResponse<List<Comment>> getcommentByPost(@PathVariable Long postId) {
        return BaseResponse.success(commentService.getByPost(postId));
    }

    @PostMapping("delete/{postId}")
    public BaseResponse<Comment> deleteComment(@PathVariable Long postId) {
        commentService.deleteComment(postId);
        return BaseResponse.success(null);
    }
}
