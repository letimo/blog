package com.irm.blog.web.admin;

import com.irm.blog.pojo.Blog;
import com.irm.blog.pojo.User;
import com.irm.blog.service.BlogService;
import com.irm.blog.service.TagService;
import com.irm.blog.service.TypeService;
import com.irm.blog.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * @author Sheldor
 * @date 2020/8/14 - 17:29
 */
@Controller
@RequestMapping("/admin")
public class BlogsController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private TagService tagService;

    @GetMapping("/blogs")
    public String blogs(Page<Blog> page, Blog blog, Model model) {
        Page<Blog> blogPage = blogService.getBlogList(page, blog);
        model.addAttribute("blogPage", blogPage);
        model.addAttribute("typeList", typeService.getTypeList());
        return "admin/blogs";
    }

    @PostMapping("/blogs/search")
    public String search(Page<Blog> page, Blog blog, Model model) {
        Page<Blog> blogPage = blogService.getBlogList(page, blog);
        model.addAttribute("blogPage", blogPage);
        model.addAttribute("typeList", typeService.getTypeList());
        return "admin/blogs :: blogList";
    }

    @GetMapping("/blogs/input")
    public String input(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("typeList", typeService.getTypeList());
        model.addAttribute("tagList", tagService.getTagList());
        return "admin/blogs-input";
    }

    @PostMapping("/blogs")
    public String post(Blog blog, RedirectAttributes redirectAttributes, HttpSession session) {
        User user = (User)session.getAttribute("user");
        blog.setUserId(user.getId());
        if (blogService.saveBlog(blog) > 0) {
            redirectAttributes.addFlashAttribute("message", "操作成功");
        }
        else {
            redirectAttributes.addFlashAttribute("message", "操作失败");
        }
        return "redirect:/admin/blogs";
    }
}
