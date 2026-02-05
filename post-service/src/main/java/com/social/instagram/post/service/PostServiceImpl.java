package com.social.instagram.post.service;

import com.social.instagram.post.entity.Post;
import com.social.instagram.post.repository.PostRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository repository) {
        this.postRepository = repository;
    }

    public Post create(Post post) {
        return postRepository.save(post);
    }

    public List<Post> getAll() {
        return postRepository.findAll();
    }

    @Override
    public void deletePost(long postId) {
        postRepository.deleteById(postId);
    }

    @Override
    public Post getPost(long postId) {
        return postRepository.findById(postId).orElse(null);
    }
}
