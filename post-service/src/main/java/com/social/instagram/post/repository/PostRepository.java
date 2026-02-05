package com.social.instagram.post.repository;

import com.social.instagram.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    void deleteById(long postId);

    List<Post> findAllByUserId(Long userId);
}
