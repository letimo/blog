package com.irm.blog.service.impl;

import com.irm.blog.dao.BlogMapper;
import com.irm.blog.dao.TagMapper;
import com.irm.blog.dao.TypeMapper;
import com.irm.blog.pojo.Blog;
import com.irm.blog.service.BlogService;
import com.irm.blog.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Sheldor
 * @date 2020/8/18 - 16:31
 */
@Service
@Transactional(readOnly = true)
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogMapper blogMapper;

    @Autowired
    private TypeMapper typeMapper;

    @Autowired
    private TagMapper tagMapper;

    @Override
    @Transactional(readOnly = false)
    public Integer saveBlog(Blog blog) {
        return blogMapper.insertBlog(blog);
    }

    @Override
    public Blog getBlogById(Long id) {
        return blogMapper.getBlogById(id);
    }

    @Override
    public Page<Blog> getBlogList(Page<Blog> page, Blog blog) {
        Map<String, Object> pageParam = new HashMap<String, Object>();
        if (page.getPageIndex() == 1) {
            pageParam.put("pageIndex", 0);
        } else {
            pageParam.put("pageIndex", (page.getPageIndex() - 1) * page.getPageSize());
        }
        pageParam.put("pageSize", page.getPageSize());
        page.setTotalCount(blogMapper.getBlogsCount(blog));
        List<Blog> blogList = blogMapper.getBlogList(pageParam, blog);
        for (int i = 0; i < blogList.size(); i++) {
            blogList.get(i).setTypeName(typeMapper.getTypeById(blogList.get(i).getTypeId()).getName());
        }
        page.setData(blogList);
        return page;
    }

    @Override
    @Transactional(readOnly = false)
    public Integer updateBlog(Blog blog) {
        return blogMapper.updateBlog(blog);
    }

    @Override
    @Transactional(readOnly = false)
    public Integer deleteBlogById(Long id) {
        return blogMapper.deleteBlogById(id);
    }
}
