package com.simpleblog.blog.controller;

import com.simpleblog.blog.service.CategoryService;
import com.simpleblog.blog.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public Result categories() {
        return categoryService.findAll();
    }

    @GetMapping("/detail")
    public Result categoriesDetails() {
        return categoryService.findAllDetail();
    }

    @GetMapping("/detail/{id}")
    public Result categoryDetail(@PathVariable Long id) {
        return categoryService.findOneDetail(id);
    }
}
