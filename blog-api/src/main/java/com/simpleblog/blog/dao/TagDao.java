package com.simpleblog.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.simpleblog.blog.pojo.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TagDao extends BaseMapper<Tag> {
    @Select("SELECT id, avatar, tag_name as tagName FROM ms_tag WHERE id IN" +
            " (SELECT tag_id FROM ms_article_tag WHERE article_id = #{articleId})")
    List<Tag> findTagsByArticleId(Long articleId);

    @Select("SELECT tag_id FROM ms_article_tag GROUP BY tag_id ORDER BY COUNT(*) DESC LIMIT #{limit}")
    List<Long> fidHotTags(Integer limit);
}
