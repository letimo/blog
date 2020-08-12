package com.irm.blog.web;

import com.irm.blog.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Sheldor
 * @date 2020/8/10 - 9:49
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/types")
    public String types() {
        return "types";
    }

    @GetMapping("/tags")
    public String tags() {
        return "tags";
    }

    @GetMapping("/archives")
    public String archives() {
        return "archives";
    }

    @GetMapping("/blogs")
    public String blogs() {
        return "admin/blogs";
    }

    @GetMapping("/input")
    public String input() {
        return "admin/blogs-input";
    }
}
