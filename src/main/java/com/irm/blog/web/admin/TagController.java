package com.irm.blog.web.admin;

import com.irm.blog.pojo.Tag;
import com.irm.blog.service.TagService;
import com.irm.blog.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * @author Sheldor
 * @date 2020/8/15 - 7:57
 * 分类控制器
 */
@Controller
@RequestMapping("/admin")
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping("/tags")
    public String getTypes(Page<Tag> page, Model model) {
        Page<Tag> tagPage = tagService.getTagListByParam(page);
        model.addAttribute("tagPage", tagPage);
        return "admin/tags";
    }

    @GetMapping("/tags/input")
    public String input(Model model) {
        model.addAttribute("tag", new Tag());
        return "admin/tags-input";
    }

    @PostMapping("/tags/save")
    public String save(
            // @Valid 验证该参数
            @Valid Tag tag,
            // BindingResult 获取验证结果
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {
        // 判断输入的分类是否存在
        if (null != tagService.checkName(tag.getName())) {
            // 自定义添加错误信息
            bindingResult.rejectValue("name", "nameError", "不能添加重复的标签");
        }
        if (bindingResult.hasErrors()) {
            return "admin/tags-input";
        }
        if (tagService.saveTag(tag) > 0) {
            redirectAttributes.addFlashAttribute("message", "新增成功");
        } else {
            redirectAttributes.addFlashAttribute("message", "新增失败");
        }
        return "redirect:/admin/tags";
    }

    @PostMapping("/tags/update/{id}")
    public String update(
            // @Valid 验证该参数
            @Valid Tag tag,
            // BindingResult 获取验证结果
            BindingResult bindingResult,
            @PathVariable Long id,
            RedirectAttributes redirectAttributes) {
        // 判断输入的分类是否存在
        if (null != tagService.checkName(tag.getName())) {
            // 自定义添加错误信息
            bindingResult.rejectValue("name", "nameError", "不能添加重复的标签");
        }
        if (bindingResult.hasErrors()) {
            return "admin/tags-input";
        }
        tag.setId(id);
        if (tagService.updateTag(tag) > 0) {
            redirectAttributes.addFlashAttribute("message", "更新成功");
        } else {
            redirectAttributes.addFlashAttribute("message", "更新失败");
        }
        return "redirect:/admin/tags";
    }

    @GetMapping("/tags/goUpdate/{id}")
    public String goUpdate(@PathVariable Long id, Model model) {
        Tag tag = tagService.getTagById(id);
        model.addAttribute("tag", tag);
        return "admin/tags-input";
    }

    @GetMapping("/tags/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes attributes){
        if (tagService.deleteTagById(id) > 0) {
            attributes.addFlashAttribute("message", "删除成功");
        }
        else {
            attributes.addFlashAttribute("message", "删除失败");
        }
        return "redirect:/admin/tags";
    }
}
