package com.irm.blog.service.impl;

import com.irm.blog.dao.TypeMapper;
import com.irm.blog.pojo.Type;
import com.irm.blog.service.TypeService;
import com.irm.blog.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Sheldor
 * @date 2020/8/15 - 7:37
 */
@Service
@Transactional(readOnly = true)
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeMapper typeMapper;

    @Transactional(readOnly = false)
    @Override
    public Integer saveType(Type type) {
        return typeMapper.insertType(type);
    }

    @Override
    public Type getTypeById(Long id) {
        return typeMapper.getTypeById(id);
    }

    @Override
    public Page<Type> getTypeList(Page<Type> page) {
        Map<String, Object> pageParam = new HashMap<String, Object>();
        if (page.getPageIndex() == 1) {
            pageParam.put("pageIndex", 0);
        } else {
            pageParam.put("pageIndex", (page.getPageIndex() - 1) * page.getPageSize());
        }
        pageParam.put("pageSize", page.getPageSize());
        page.setTotalCount(typeMapper.getTypesCount());
        page.setData(typeMapper.getTypeListByParam(pageParam));
        return page;
    }

    @Override
    public List<Type> getTypeList() {
        return typeMapper.getTypeList();
    }

    @Transactional(readOnly = false)
    @Override
    public Integer updateType(Type type) {
        return typeMapper.updateType(type);
    }

    @Transactional(readOnly = false)
    @Override
    public Integer deleteTypeById(Long id) {
        return typeMapper.deleteTypeById(id);
    }

    @Override
    public Type checkName(String name) {
        return typeMapper.getTypeByName(name);
    }
}
