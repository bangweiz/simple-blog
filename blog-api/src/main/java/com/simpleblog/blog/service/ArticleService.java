package com.simpleblog.blog.service;

import com.simpleblog.blog.vo.Result;
import com.simpleblog.blog.vo.param.ArticleParam;
import com.simpleblog.blog.vo.param.PageParams;

public interface ArticleService {
    Result listArticle(PageParams pageParams);

    Result hotArticles(Integer limit);

    Result newArticles(Integer limit);

    Result listArchives();

    Result findArticleById(Long id);

    Result publish(ArticleParam articleParam);
}
