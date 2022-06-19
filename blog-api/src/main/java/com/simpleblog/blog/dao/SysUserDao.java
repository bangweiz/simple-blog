package com.simpleblog.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.simpleblog.blog.pojo.SysUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserDao extends BaseMapper<SysUser> {
}
