package com.social.instagram.user.repository;

import com.social.instagram.user.entity.Follower;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FollowerRepository extends JpaRepository<Follower,Long> {
    List<Follower> findByUserId(Long userId);

    List<Follower> findByFollowerId(Long followerId);

    void deleteByUserIdAndFollowerId(long targetUserId, long userId);

    boolean existsByFollowerIdAndUserId(long targetUserId,long userId);
}
