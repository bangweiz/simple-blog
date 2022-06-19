package com.simpleblog.blog.service;

import com.simpleblog.blog.vo.Result;
import com.simpleblog.blog.vo.TagVo;

import java.util.List;

public interface TagService {
    List<TagVo> findTagsByArticleId(Long articleId);

    Result hots(int limit);

    Result findAll();

    Result findAllDetail();

    Result findOneDetail(Long id);
}
