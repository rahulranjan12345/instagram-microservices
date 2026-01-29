
package com.social.instagram.user.service;

import com.social.instagram.user.entity.User;
import com.social.instagram.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    public User createUser(User user) {
        return repository.save(user);
    }

    public User getUser(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }
}
