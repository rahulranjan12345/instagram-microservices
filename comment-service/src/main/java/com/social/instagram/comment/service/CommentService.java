package com.social.instagram.comment.service;

import com.social.instagram.comment.entity.Comment;
import java.util.List;

public interface CommentService {
    Comment addComment(Comment comment);
    List<Comment> getByPost(Long postId);

    void deleteComment(Long postId);
}
