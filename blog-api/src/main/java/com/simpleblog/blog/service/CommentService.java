package com.simpleblog.blog.service;

import com.simpleblog.blog.vo.Result;
import com.simpleblog.blog.vo.param.CommentParam;

public interface CommentService {
    Result commentsByArticleId(Long articleId);

    Result comment(CommentParam commentParam);
}
