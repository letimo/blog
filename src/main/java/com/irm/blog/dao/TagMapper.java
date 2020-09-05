package com.irm.blog.dao;

import com.irm.blog.pojo.Tag;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author Sheldor
 * @date 2020/8/18 - 8:28
 */
@Repository
public interface TagMapper {

    @Insert("INSERT INTO tag (name) VALUES (#{tag.name})")
    public Integer insertTag(@Param(value = "tag") Tag tag);

    @Select("SELECT  id,  name FROM  tag LIMIT #{pageParam.pageIndex}, #{pageParam.pageSize}")
    public List<Tag> getTagListByParam(@Param(value = "pageParam") Map<String, Object> pageParam);

    @Select("SELECT  id, name FROM tag")
    public List<Tag> getTagList();

    @Select("SELECT COUNT(1) FROM tag")
    public Integer getTagsCount();

    @Select("SELECT id, name FROM tag WHERE id=#{id}")
    public Tag getTagById(@Param(value = "id") Long id);

    @Select("SELECT id, name FROM tag WHERE name=#{name}")
    public Tag getTagByName(@Param(value = "name") String name);

    @Update("UPDATE tag SET name = #{tag.name} WHERE id = #{tag.id}")
    public Integer updateTag(@Param(value = "tag") Tag tag);

    @Delete("DELETE FROM tag WHERE id = #{id}")
    public Integer deleteTagById(@Param(value = "id") Long id);
}
