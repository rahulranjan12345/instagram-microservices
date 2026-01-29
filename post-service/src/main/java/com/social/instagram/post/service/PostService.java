package com.social.instagram.post.service;

import com.social.instagram.post.entity.Post;
import java.util.List;

public interface PostService {
    Post create(Post post);
    List<Post> getAll();
}
