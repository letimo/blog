package com.irm.blog.dao;

import com.irm.blog.pojo.Type;
import com.irm.blog.util.Page;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author Sheldor
 * @date 2020/8/15 - 7:38
 */
@Repository
public interface TypeMapper {

    @Insert("INSERT INTO type (name) VALUES (#{type.name})")
    public Integer insertType(@Param(value = "type") Type type);

    @Select("SELECT id, name FROM type WHERE id=#{id}")
    public Type getTypeById(@Param(value = "id") Long id);

    @Select("SELECT id, name FROM type LIMIT #{pageParam.pageIndex}, #{pageParam.pageSize}")
    public List<Type> getTypeListByParam(@Param(value = "pageParam") Map<String, Object> pageParam);

    @Select("SELECT id, name FROM type")
    public List<Type> getTypeList();

    @Select("SELECT COUNT(1) FROM type")
    public Integer getTypesCount();

    @Update("UPDATE type SET name = #{type.name} WHERE id = #{type.id}")
    public Integer updateType(@Param(value = "type") Type type);

    @Delete("DELETE FROM type WHERE id = #{id}")
    public Integer deleteTypeById(@Param(value = "id") Long id);

    @Select("SELECT id, name FROM type WHERE name=#{name}")
    public Type getTypeByName(@Param("name") String name);
}
