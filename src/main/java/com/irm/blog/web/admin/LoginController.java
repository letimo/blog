package com.irm.blog.web.admin;

import com.irm.blog.pojo.User;
import com.irm.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * @author Sheldor
 * @date 2020/8/14 - 9:12
 */
@Controller
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public String loginPage() {
        return "admin/login";
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam(value = "userName", required = true) String userName,
                          @RequestParam(value = "password", required = true) String password,
                          HttpSession session,
                          RedirectAttributes redirectAttributes) {
        User user = userService.checkUser(userName, password);

        if (null != user) {
            user.setPassword(null);
            session.setAttribute("user", user);
            return "admin/index";
        }
        else {
            redirectAttributes.addFlashAttribute("message", "用户名或密码错误");
            return "redirect:/admin/";
        }
    }

    @GetMapping("/loginOut")
    public String loginOut(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/admin/";
    }
}
