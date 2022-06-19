package com.simpleblog.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.simpleblog.blog.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentDao extends BaseMapper<Comment> {
}
