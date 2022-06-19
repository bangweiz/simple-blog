package com.simpleblog.blog.service;

import com.simpleblog.blog.vo.CategoryVo;
import com.simpleblog.blog.vo.Result;

public interface CategoryService {
    CategoryVo findCategoryById(Long categoryId);

    Result findAll();

    Result findAllDetail();

    Result findOneDetail(Long id);
}
