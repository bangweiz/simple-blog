package com.simpleblog.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.simpleblog.blog.dao.SysUserDao;
import com.simpleblog.blog.pojo.SysUser;
import com.simpleblog.blog.service.AuthService;
import com.simpleblog.blog.service.SysUserService;
import com.simpleblog.blog.vo.ErrorCode;
import com.simpleblog.blog.vo.LoginUserVo;
import com.simpleblog.blog.vo.Result;
import com.simpleblog.blog.vo.UserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserDao sysUserDao;
    @Autowired
    private AuthService authService;

    @Override
    public SysUser findUserById(Long id) {
        SysUser sysUser = sysUserDao.selectById(id);
        if (sysUser == null) {
            sysUser = new SysUser();
            sysUser.setNickname("Anonymous");
        }
        return sysUser;
    }

    @Override
    public SysUser findUser(String account, String password) {
        LambdaQueryWrapper<SysUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysUser::getAccount, account)
                .eq(SysUser::getPassword, password)
                .select(SysUser::getAccount, SysUser::getId, SysUser::getAccount, SysUser::getNickname)
                .last("limit 1");
        return sysUserDao.selectOne(wrapper);
    }

    @Override
    public Result findUserByToken(String token) {
        SysUser user = authService.checkToken(token);
        if (user == null) {
            return Result.fail(ErrorCode.TOKEN_INVALID.getCode(), ErrorCode.TOKEN_INVALID.getMsg());
        }
        LoginUserVo loginUserVo = new LoginUserVo();
        loginUserVo.setId(user.getId());
        loginUserVo.setNickname(user.getNickname());
        loginUserVo.setAvatar(user.getAvatar());
        loginUserVo.setAccount(user.getAccount());
        return Result.success(loginUserVo);
    }

    @Override
    public SysUser findUserByAccount(String account) {
        LambdaQueryWrapper<SysUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysUser::getAccount, account).last("limit 1");
        return sysUserDao.selectOne(wrapper);
    }

    @Override
    public void save(SysUser sysUser) {
        sysUserDao.insert(sysUser);
    }

    @Override
    public UserVo findUserVoById(Long id) {
        SysUser user = findUserById(id);
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(user, userVo);
        return userVo;
    }
}
