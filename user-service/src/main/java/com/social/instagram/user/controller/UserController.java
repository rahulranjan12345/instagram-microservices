
package com.social.instagram.user.controller;

import com.social.instagram.common.response.BaseResponse;
import com.social.instagram.user.entity.User;
import com.social.instagram.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(UserService service) {
        this.userService = service;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse<User> create(@RequestBody User user) {
        return BaseResponse.success(userService.createUser(user));
    }

    @PostMapping(path = "/follow",consumes = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse<User> follow(@PathVariable Long targetUserId,@PathVariable Long userId) {
        userService.follow(targetUserId,userId);
        return BaseResponse.success(null);
    }
    @PostMapping(path = "/unfollow",consumes = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse<User> unfollow( @PathVariable Long targetUserId,@PathVariable Long userId) {
        userService.unfollow(targetUserId,userId);
        return BaseResponse.success(null);
    }

    @GetMapping("/{id}")
    public BaseResponse<User> get(@PathVariable Long id) {
        return BaseResponse.success(userService.getUser(id));
    }

    @GetMapping("followers/{userId}")
    public BaseResponse<List<User>> getFollowers(@PathVariable Long userId){
        return BaseResponse.success(userService.getFollowers(userId));
    }

    @GetMapping("following/{userId}")
    public BaseResponse<List<User>> getFollowing(@PathVariable Long userId){
        return BaseResponse.success(userService.getFollowing(userId));
    }
    @GetMapping
    public BaseResponse<List<User>> getAll() {
        return BaseResponse.success(userService.getAllUsers());
    }
}
