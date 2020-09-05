package com.irm.blog.service;

import com.irm.blog.pojo.Tag;
import com.irm.blog.util.Page;

import java.util.List;

/**
 * @author Sheldor
 * @date 2020/8/18 - 8:44
 */
public interface TagService {
    public Integer saveTag(Tag tag);

    public Tag getTagById(Long id);

    public Page<Tag> getTagListByParam(Page<Tag> page);

    public List<Tag> getTagList();

    public Tag checkName(String name);

    public Integer updateTag(Tag tag);

    public Integer deleteTagById(Long id);
}
