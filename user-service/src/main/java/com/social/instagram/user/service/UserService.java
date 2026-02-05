
package com.social.instagram.user.service;

import com.social.instagram.user.entity.User;
import java.util.List;

public interface UserService {
    User createUser(User user);
    User getUser(Long id);
    List<User> getAllUsers();
    void follow(long targetUserId,long userId);
    void unfollow(long targetUserId,long userId);
    public List<User> getFollowers(Long userId);
    public List<User> getFollowing(Long userId);

}
