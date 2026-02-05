package com.social.instagram.post.service;

import com.social.instagram.post.entity.Post;
import com.social.instagram.post.repository.PostRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository repository;

    public PostServiceImpl(PostRepository repository) {
        this.repository = repository;
    }

    public Post create(Post post) {
        return repository.save(post);
    }

    public List<Post> getAll() {
        return repository.findAll();
    }
}
