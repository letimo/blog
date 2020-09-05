package com.irm.blog.pojo;

import java.io.Serializable;

/**
 * @author Sheldor
 * @date 2020/8/12 - 20:08
 * 标签实体类
 */
public class Tag implements Serializable {

    // 标签 id
    private Long id;
    // 标签名称
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
