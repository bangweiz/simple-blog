package com.simpleblog.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.simpleblog.blog.dos.Archives;
import com.simpleblog.blog.pojo.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ArticleDao extends BaseMapper<Article> {
    @Select("SELECT YEAR(FROM_UNIXTIME(create_date/1000)) AS year, MONTH(FROM_UNIXTIME(create_date/1000)) AS month, COUNT(*) AS count FROM ms_article GROUP BY year, month")
    List<Archives> listArchives();

    IPage<Article> listArchive(Page<Article> page, Long categoryId, Long tagId, String year, String month);
}
