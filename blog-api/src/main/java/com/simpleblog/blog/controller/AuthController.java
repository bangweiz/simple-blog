package com.simpleblog.blog.controller;

import com.simpleblog.blog.service.AuthService;
import com.simpleblog.blog.vo.Result;
import com.simpleblog.blog.vo.param.LoginParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public Result login(@RequestBody LoginParam loginParam) {
        return authService.login(loginParam);
    }

    @GetMapping("/logout")
    public Result logout(@RequestHeader("Authorization") String token) {
        return authService.logout(token);
    }

    @PostMapping("/register")
    public Result register(@RequestBody LoginParam loginParam) {
        return authService.register(loginParam);
    }
}
