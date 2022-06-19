package com.simpleblog.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.simpleblog.blog.pojo.ArticleTag;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleTagDao extends BaseMapper<ArticleTag> {
}
