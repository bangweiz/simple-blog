package com.simpleblog.blog.service;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.simpleblog.blog.dao.ArticleDao;
import com.simpleblog.blog.pojo.Article;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class ThreadService {
    @Async("taskExecutor")
    public void updateArticleViewCount(ArticleDao articleDao, Article article) {
        int viewCounts = article.getViewCounts();
        Article updatedArticle = new Article();
        updatedArticle.setViewCounts(viewCounts + 1);
        LambdaUpdateWrapper<Article> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(Article::getId, article.getId()).eq(Article::getViewCounts, article.getViewCounts());
        articleDao.update(updatedArticle,wrapper);
    }
}
