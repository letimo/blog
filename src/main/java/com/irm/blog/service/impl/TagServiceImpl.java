package com.irm.blog.service.impl;

import com.irm.blog.dao.TagMapper;
import com.irm.blog.pojo.Tag;
import com.irm.blog.service.TagService;
import com.irm.blog.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Sheldor
 * @date 2020/8/18 - 8:48
 */
@Service
@Transactional(readOnly = true)
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper tagMapper;

    @Transactional(readOnly = false)
    @Override
    public Integer saveTag(Tag tag) {
        return tagMapper.insertTag(tag);
    }

    @Override
    public Tag getTagById(Long id) {
        return tagMapper.getTagById(id);
    }

    @Override
    public Page<Tag> getTagListByParam(Page<Tag> page) {
        Map<String, Object> pageParam = new HashMap<String, Object>();
        if (page.getPageIndex() == 1) {
            pageParam.put("pageIndex", 0);
        } else {
            pageParam.put("pageIndex", (page.getPageIndex() - 1) * page.getPageSize());
        }
        pageParam.put("pageSize", page.getPageSize());
        page.setTotalCount(tagMapper.getTagsCount());
        page.setData(tagMapper.getTagListByParam(pageParam));
        return page;
    }

    @Override
    public List<Tag> getTagList() {
        return tagMapper.getTagList();
    }

    @Override
    public Tag checkName(String name) {
        return tagMapper.getTagByName(name);
    }

    @Transactional(readOnly = false)
    @Override
    public Integer updateTag(Tag tag) {
        return tagMapper.updateTag(tag);
    }

    @Transactional(readOnly = false)
    @Override
    public Integer deleteTagById(Long id) {
        return tagMapper.deleteTagById(id);
    }
}
