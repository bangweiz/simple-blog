package com.simpleblog.blog.service;

import com.simpleblog.blog.pojo.SysUser;
import com.simpleblog.blog.vo.Result;
import com.simpleblog.blog.vo.param.LoginParam;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface AuthService {
    Result login(LoginParam loginParam);

    SysUser checkToken(String token);

    Result logout(String token);

    Result register(LoginParam loginParam);
}
