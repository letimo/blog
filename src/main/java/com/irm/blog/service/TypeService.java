package com.irm.blog.service;

import com.irm.blog.pojo.Type;
import com.irm.blog.util.Page;

import java.util.List;

/**
 * @author Sheldor
 * @date 2020/8/29 - 10:38
 */
public interface TypeService {
    public Integer saveType(Type type);

    public Type getTypeById(Long id);

    public Page<Type> getTypeList(Page<Type> page);

    public List<Type> getTypeList();

    public Integer updateType(Type type);

    public Integer deleteTypeById(Long id);

    public Type checkName(String name);
}
