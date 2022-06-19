package com.simpleblog.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.simpleblog.blog.pojo.Category;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryDao extends BaseMapper<Category> {
}
