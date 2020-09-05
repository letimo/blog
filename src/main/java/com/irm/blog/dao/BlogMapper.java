package com.irm.blog.dao;

import com.irm.blog.pojo.Blog;
import com.irm.blog.util.Page;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author Sheldor
 * @date 2020/8/18 - 16:26
 */
@Repository
public interface BlogMapper {

    @Insert("INSERT INTO blog (\n" +
            "  title,\n" +
            "  content,\n" +
            "  firstPicture,\n" +
            "  flag,\n" +
            "  views,\n" +
            "  appreciation,\n" +
            "  shareStatement,\n" +
            "  commentTabled,\n" +
            "  published,\n" +
            "  recommend,\n" +
            "  typeId,\n" +
            "  tagId,\n" +
            "  userId\n" +
            ")\n" +
            "VALUES\n" +
            "  (\n" +
            "    #{blog.title},\n" +
            "    #{blog.content},\n" +
            "    #{blog.firstPicture},\n" +
            "    #{blog.flag},\n" +
            "    #{blog.views},\n" +
            "    #{blog.appreciation},\n" +
            "    #{blog.shareStatement},\n" +
            "    #{blog.commentTabled},\n" +
            "    #{blog.published},\n" +
            "    #{blog.recommend},\n" +
            "    #{blog.typeId},\n" +
            "    #{blog.tagId},\n" +
            "    #{blog.userId}\n" +
            "  )")
    public Integer insertBlog(@Param(value = "blog") Blog blog);

    @Select("SELECT  id,  title,  content,  firstPicture,  flag,  views,  appreciation,  shareStatement,  commentTabled,  published,  recommend,  createTime,  updateTime,  typeId,  tagId,  userId FROM  blog  WHERE  id=#{id}")
    public Blog getBlogById(@Param(value = "id") Long id);

    @Select("<script>SELECT\n" +
            "  id,\n" +
            "  title,\n" +
            "  content,\n" +
            "  firstPicture,\n" +
            "  flag,\n" +
            "  views,\n" +
            "  appreciation,\n" +
            "  shareStatement,\n" +
            "  commentTabled,\n" +
            "  published,\n" +
            "  recommend,\n" +
            "  createTime,\n" +
            "  updateTime,\n" +
            "  typeId,\n" +
            "  tagId,\n" +
            "  userId\n" +
            "FROM\n" +
            "  blog\n" +
            "<where>\n"+
            "<if test='null != blog.title and \"\" != blog.title'> and title LIKE CONCAT('%',#{blog.title},'%') </if>\n"+
            "<if test='null != blog.typeId'> and typeId=#{blog.typeId} </if>\n"+
            "<if test='null != blog.recommend'> and recommend=#{blog.recommend} </if>\n"+
            "</where>\n"+
            "LIMIT #{pageParam.pageIndex}, #{pageParam.pageSize}</script>")
    public List<Blog> getBlogList(@Param(value = "pageParam") Map<String, Object> pageParam, @Param(value = "blog") Blog blog);

    @Update("UPDATE\n" +
            "  blog\n" +
            "SET\n" +
            "  id = #{blog.id},\n" +
            "  title = #{blog.title},\n" +
            "  content = #{blog.content},\n" +
            "  firstPicture = #{blog.firstPicture},\n" +
            "  flag = #{blog.flag},\n" +
            "  views = #{blog.views},\n" +
            "  appreciation = #{blog.appreciation},\n" +
            "  shareStatement = #{blog.shareStatement},\n" +
            "  commentTabled = #{blog.commentTabled},\n" +
            "  published = #{blog.published},\n" +
            "  recommend = #{blog.recommend},\n" +
            "  createTime = #{blog.createTime},\n" +
            "  updateTime = #{blog.updateTime},\n" +
            "  typeId = #{blog.typeId},\n" +
            "  tagId = #{blog.tag},\n" +
            "  userId = #{blog.userId}\n" +
            "WHERE id = #{blog.id}")
    public Integer updateBlog(@Param(value = "blog") Blog blog);

    @Select("<script>SELECT\n" +
            "  count(1)\n" +
            "FROM\n" +
            "  blog\n" +
            "<where>\n"+
            "<if test='null != blog.title and \"\" != blog.title'> and title LIKE CONCAT('%',#{blog.title},'%') </if>\n"+
            "<if test='null != blog.typeId'> and typeId=#{blog.typeId} </if>\n"+
            "<if test='null != blog.recommend'> and recommend=#{blog.recommend} </if>\n"+
            "</where>\n"+
            "</script>")
    public Integer getBlogsCount(@Param(value = "blog") Blog blog);

    @Delete("DELETE FROM  blog WHERE id = #{id}")
    public Integer deleteBlogById(@Param(value = "id") Long id);
}
