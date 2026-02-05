
package com.social.instagram.user.service;

import com.social.instagram.user.entity.Follower;
import com.social.instagram.user.entity.User;
import com.social.instagram.user.repository.FollowerRepository;
import com.social.instagram.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private  UserRepository userRepository;

    @Autowired
    private FollowerRepository followerRepository;

    public UserServiceImpl(UserRepository repository) {
        this.userRepository = repository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void follow(long targetUserId,long userId) {
        if (userId == targetUserId) {
            throw new IllegalArgumentException("You cannot follow yourself");
        }
        if (followerRepository.existsByFollowerIdAndUserId(userId, targetUserId)) {
            return; // already following (idempotent)
        }

        User follower = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        User target = userRepository.findById(targetUserId)
                .orElseThrow(() -> new RuntimeException("Target user not found"));

        Follower relation = new Follower();
        relation.setFollower(follower);
        relation.setUser(target);

        followerRepository.save(relation);

    }

    @Override
    public void unfollow(long targetUserId,long userId) {
        followerRepository.deleteByUserIdAndFollowerId(targetUserId,userId);
    }

    @Override
    public List<User> getFollowers(Long userId) {
        return followerRepository.findByUserId(userId)
                .stream()
                .map(Follower::getFollower)
                .toList();
    }

    @Override
    public List<User> getFollowing(Long userId) {
        return followerRepository.findByFollowerId(userId)
                .stream()
                .map(Follower::getUser)
                .toList();
    }
}
