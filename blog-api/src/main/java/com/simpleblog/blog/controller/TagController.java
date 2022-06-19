package com.simpleblog.blog.controller;

import com.simpleblog.blog.service.TagService;
import com.simpleblog.blog.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tags")
public class TagController {
    @Autowired
    private TagService tagService;

    @GetMapping("/hot")
    public Result hots() {
        int limit = 6;
        return tagService.hots(limit);
    }

    @GetMapping
    public Result tags() {
        return tagService.findAll();
    }

    @GetMapping("/detail")
    public Result tagsDetails() {
        return tagService.findAllDetail();
    }

    @GetMapping("/detail/{id}")
    public Result tagDetails(@PathVariable Long id) {
        return tagService.findOneDetail(id);
    }
}
