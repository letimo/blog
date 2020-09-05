package com.irm.blog.service;

import com.irm.blog.pojo.Blog;
import com.irm.blog.util.Page;

import java.util.List;
import java.util.Map;

/**
 * @author Sheldor
 * @date 2020/8/18 - 16:21
 */
public interface BlogService {

    public Integer saveBlog(Blog blog);

    public Blog getBlogById(Long id);

    public Page<Blog> getBlogList(Page<Blog> page, Blog blog);

    public Integer updateBlog(Blog blog);

    public Integer deleteBlogById(Long id);
}
