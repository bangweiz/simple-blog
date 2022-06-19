package com.simpleblog.blog.controller;

import com.simpleblog.blog.service.CommentService;
import com.simpleblog.blog.vo.Result;
import com.simpleblog.blog.vo.param.CommentParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping("/{id}")
    public Result comments(@PathVariable Long id) {
        return commentService.commentsByArticleId(id);
    }

    @PostMapping
    public Result comment(@RequestBody CommentParam commentParam) {
        return commentService.comment(commentParam);
    }
}
