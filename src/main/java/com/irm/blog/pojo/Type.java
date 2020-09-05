package com.irm.blog.pojo;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author Sheldor
 * @date 2020/8/12 - 20:06
 * 分类实体类
 */
public class Type implements Serializable {

    // 分类 id
    private Long id;
    // 分类名称
    @NotBlank(message = "分类名称不能为空")
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
        return "Type{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
