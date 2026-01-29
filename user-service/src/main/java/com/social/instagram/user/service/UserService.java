
package com.social.instagram.user.service;

import com.social.instagram.user.entity.User;
import java.util.List;

public interface UserService {
    User createUser(User user);
    User getUser(Long id);
    List<User> getAllUsers();
}
