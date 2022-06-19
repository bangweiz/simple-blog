package com.simpleblog.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.simpleblog.blog.dao.CategoryDao;
import com.simpleblog.blog.pojo.Category;
import com.simpleblog.blog.service.CategoryService;
import com.simpleblog.blog.vo.CategoryVo;
import com.simpleblog.blog.vo.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;

    @Override
    public CategoryVo findCategoryById(Long categoryId) {
        Category category = categoryDao.selectById(categoryId);
        return copy(category);
    }

    @Override
    public Result findAll() {
        LambdaQueryWrapper<Category> wrapper = new LambdaQueryWrapper<>();
        wrapper.select(Category::getId, Category::getCategoryName);
        List<Category> categories = categoryDao.selectList(wrapper);
        return Result.success(copyList(categories));
    }

    @Override
    public Result findAllDetail() {
        List<Category> categories = categoryDao.selectList(null);
        return Result.success(copyList(categories));
    }

    @Override
    public Result findOneDetail(Long id) {
        Category category = categoryDao.selectById(id);
        return Result.success(copy(category));
    }

    public CategoryVo copy(Category category) {
        CategoryVo categoryVo = new CategoryVo();
        BeanUtils.copyProperties(category, categoryVo);
        return categoryVo;
    }

    public List<CategoryVo> copyList(List<Category> categories) {
        List<CategoryVo> list = new ArrayList<>();
        for (Category category: categories) {
            list.add(copy(category));
        }
        return list;
    }
}
