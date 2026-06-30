/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uef.edu.vn.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import uef.edu.vn.model.User;
import uef.edu.vn.service.UserService;

/**
 *
 * @author ADMIN
 */
@Controller
public class ChangePasswordController {

    @Autowired
    private UserService service;

    @GetMapping("/change-password")
    public String form(Model model) {

        model.addAttribute(
                "body",
                "/WEB-INF/views/changepassword/form.jsp");

        return "layout/main";
    }

    // ==========================
    // Xử lý đổi mật khẩu
    // ==========================
    @PostMapping("/change-password")
    public String changePassword(
            @RequestParam("oldPassword") String oldPassword,
            @RequestParam("newPassword") String newPassword,
            @RequestParam("confirmPassword") String confirmPassword,
            HttpSession session,
            Model model) {

        User user = (User) session.getAttribute("user");

        // Chưa đăng nhập
        if (user == null) {

            return "redirect:/login";

        }

        // Kiểm tra xác nhận mật khẩu
        if (!newPassword.equals(confirmPassword)) {

            model.addAttribute(
                    "error",
                    "New Password và Confirm Password không khớp!");

            model.addAttribute(
                    "body",
                    "/WEB-INF/views/changepassword/form.jsp");

            return "layout/main";

        }

        boolean ok = service.changePassword(
                user.getUserId(),
                oldPassword,
                newPassword);

        if (!ok) {

            model.addAttribute(
                    "error",
                    "Old Password không đúng!");

            model.addAttribute(
                    "body",
                    "/WEB-INF/views/changepassword/form.jsp");

            return "layout/main";

        }

// Đổi thành công
        session.invalidate();

        return "redirect:/login";
    }

}
