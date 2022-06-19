package com.simpleblog.blog.controller;

import com.simpleblog.blog.com.aop.LogAnnotation;
import com.simpleblog.blog.service.ArticleService;
import com.simpleblog.blog.vo.Result;
import com.simpleblog.blog.vo.param.ArticleParam;
import com.simpleblog.blog.vo.param.PageParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/articles")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @PostMapping
    @LogAnnotation(module = "Articles", operator = "All Articles")
    public Result listArticle(@RequestBody PageParams pageParams) {
        return articleService.listArticle(pageParams);
    }

    @GetMapping("/hot")
    public Result hotArticles() {
        int limit = 5;
        return articleService.hotArticles(limit);
    }

    @GetMapping("/new")
    public Result newArticles() {
        int limit = 5;
        return articleService.newArticles(limit);
    }

    @GetMapping("/listArchives")
    public Result listArchives() {
        return articleService.listArchives();
    }

    @GetMapping("/view/{id}")
    public Result findArticleById(@PathVariable Long id) {
        return articleService.findArticleById(id);
    }

    @PostMapping("/publish")
    public Result publish(@RequestBody ArticleParam articleParam) {
        return articleService.publish(articleParam);
    }
}
