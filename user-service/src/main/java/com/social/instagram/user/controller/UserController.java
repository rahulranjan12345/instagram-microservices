
package com.social.instagram.user.controller;

import com.social.instagram.common.response.BaseResponse;
import com.social.instagram.user.entity.User;
import com.social.instagram.user.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public BaseResponse<User> create(@RequestBody User user) {
        return BaseResponse.success(service.createUser(user));
    }

    @GetMapping("/{id}")
    public BaseResponse<User> get(@PathVariable Long id) {
        return BaseResponse.success(service.getUser(id));
    }

    @GetMapping
    public BaseResponse<List<User>> getAll() {
        return BaseResponse.success(service.getAllUsers());
    }
}
