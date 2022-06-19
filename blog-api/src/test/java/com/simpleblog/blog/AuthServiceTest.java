package com.simpleblog.blog;

import com.simpleblog.blog.service.AuthService;
import com.simpleblog.blog.vo.Result;
import com.simpleblog.blog.vo.param.LoginParam;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AuthServiceTest {
    @Autowired
    private AuthService authService;

    @Test
    public void login(){
        LoginParam loginParam = new LoginParam();
        loginParam.setAccount("admin");
        loginParam.setPassword("admin");
        Result res = authService.login(loginParam);
        System.out.println(res.getData());
    }
}
