package com.irm.blog.dao;

import com.irm.blog.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author Sheldor
 * @date 2020/8/14 - 8:51
 */
@Repository
public interface UserMapper {

    @Select("SELECT\n" +
            "  u.id AS id,\n" +
            "  u.`nickname` AS nickName,\n" +
            "  u.`username` AS userName,\n" +
            "  u.`password` AS `password`,\n" +
            "  u.`email` AS email,\n" +
            "  u.`avatar` AS avatar,\n" +
            "  u.`type` AS `type`,\n" +
            "  u.`createtime` AS createTime,\n" +
            "  u.`updatetime` AS updateTime\n" +
            "FROM\n" +
            "  `user` AS u\n" +
            "WHERE\n" +
            "\tu.`username` = #{userName}\n" +
            "AND\n" +
            "\tu.`password` = #{password}")
    public User getUserByUserNameAndPassword(@Param(value = "userName") String userName, @Param(value = "password") String password);
}
