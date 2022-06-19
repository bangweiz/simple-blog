package com.simpleblog.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.simpleblog.blog.dao.TagDao;
import com.simpleblog.blog.pojo.Tag;
import com.simpleblog.blog.service.TagService;
import com.simpleblog.blog.vo.Result;
import com.simpleblog.blog.vo.TagVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class TagServiceImp implements TagService {
    @Autowired
    private TagDao tagDao;

    @Override
    public List<TagVo> findTagsByArticleId(Long articleId) {
        List<Tag> tags = tagDao.findTagsByArticleId(articleId);
        return copyList(tags);
    }

    @Override
    public Result hots(int limit) {
        List<Long> tagIds = tagDao.fidHotTags(limit);
        if (tagIds.isEmpty()) {
            return Result.success(Collections.emptyList());
        }
        List<Tag> tags = tagDao.selectBatchIds(tagIds);
        return Result.success(tags);
    }

    @Override
    public Result findAll() {
        LambdaQueryWrapper<Tag> wrapper = new LambdaQueryWrapper<>();
        wrapper.select(Tag::getId, Tag::getTagName);
        List<Tag> tags = tagDao.selectList(wrapper);
        return Result.success(copyList(tags));
    }

    @Override
    public Result findAllDetail() {
        List<Tag> tags = tagDao.selectList(null);
        return Result.success(copyList(tags));    }

    @Override
    public Result findOneDetail(Long id) {
        Tag tag = tagDao.selectById(id);
        return Result.success(copy(tag));
    }

    public TagVo copy(Tag tag){
        TagVo tagVo = new TagVo();
        BeanUtils.copyProperties(tag,tagVo);
        return tagVo;
    }

    public List<TagVo> copyList(List<Tag> tagList){
        List<TagVo> tagVoList = new ArrayList<>();
        for (Tag tag : tagList) {
            tagVoList.add(copy(tag));
        }
        return tagVoList;
    }
}
