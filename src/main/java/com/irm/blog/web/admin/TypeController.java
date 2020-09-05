package com.irm.blog.web.admin;

import com.irm.blog.pojo.Type;
import com.irm.blog.service.TypeService;
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
public class TypeController {

    @Autowired
    private TypeService typeService;

    @GetMapping("/types")
    public String getTypes(Page<Type> page, Model model) {
        Page<Type> typePage = typeService.getTypeList(page);
        model.addAttribute("typePage", typePage);
        return "admin/types";
    }

    @GetMapping("/types/input")
    public String input(Model model) {
        model.addAttribute("type", new Type());
        return "admin/types-input";
    }

    @PostMapping("/types/save")
    public String save(
            // @Valid 验证该参数
            @Valid Type type,
            // BindingResult 获取验证结果
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {
        // 判断输入的分类是否存在
        if (null != typeService.checkName(type.getName())) {
            // 自定义添加错误信息
            bindingResult.rejectValue("name", "nameError", "不能添加重复的分类");
        }
        if (bindingResult.hasErrors()) {
            return "admin/types-input";
        }
        if (typeService.saveType(type) > 0) {
            redirectAttributes.addFlashAttribute("message", "新增成功");
        } else {
            redirectAttributes.addFlashAttribute("message", "新增失败");
        }
        return "redirect:/admin/types";
    }

    @PostMapping("/types/update/{id}")
    public String update(
            // @Valid 验证该参数
            @Valid Type type,
            // BindingResult 获取验证结果
            BindingResult bindingResult,
            @PathVariable Long id,
            RedirectAttributes redirectAttributes) {
        // 判断输入的分类是否存在
        if (null != typeService.checkName(type.getName())) {
            // 自定义添加错误信息
            bindingResult.rejectValue("name", "nameError", "不能添加重复的分类");
        }
        if (bindingResult.hasErrors()) {
            return "admin/types-input";
        }
        type.setId(id);
        if (typeService.updateType(type) > 0) {
            redirectAttributes.addFlashAttribute("message", "更新成功");
        } else {
            redirectAttributes.addFlashAttribute("message", "更新失败");
        }
        return "redirect:/admin/types";
    }

    @GetMapping("/types/goUpdate/{id}")
    public String goUpdate(@PathVariable Long id, Model model) {
        Type type = typeService.getTypeById(id);
        model.addAttribute("type", type);
        return "admin/types-input";
    }

    @GetMapping("/types/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes attributes){
        if (typeService.deleteTypeById(id) > 0) {
            attributes.addFlashAttribute("message", "删除成功");
        }
        else {
            attributes.addFlashAttribute("message", "删除失败");
        }
        return "redirect:/admin/types";
    }
}
