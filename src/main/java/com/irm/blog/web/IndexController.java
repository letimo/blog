package com.irm.blog.web;

import com.irm.blog.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Sheldor
 * @date 2020/8/10 - 9:49
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        //int i = 1 / 0;
        String blog = null;
        if (null == blog) {
            throw  new NotFoundException("博客不存在");
        }
        return "index";
    }
}
