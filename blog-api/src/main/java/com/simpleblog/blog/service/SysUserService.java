package com.simpleblog.blog.service;

import com.simpleblog.blog.pojo.SysUser;
import com.simpleblog.blog.vo.Result;
import com.simpleblog.blog.vo.UserVo;

public interface SysUserService {
    SysUser findUserById(Long id);

    SysUser findUser(String account, String password);

    Result findUserByToken(String token);

    SysUser findUserByAccount(String account);

    void save(SysUser sysUser);

    UserVo findUserVoById(Long id);
}
