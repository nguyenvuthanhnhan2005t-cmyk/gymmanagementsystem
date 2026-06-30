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
public class LoginController {

    @Autowired
    private UserService service;

    // ==========================
    // Hiển thị form Login
    // ==========================
    @GetMapping("/login")
    public String loginForm(HttpSession session) {

        // Nếu đã đăng nhập thì chuyển về Home
        if (session.getAttribute("user") != null) {
            return "redirect:/";
        }

        return "login/form";
    }

    // ==========================
    // Xử lý Login
    // ==========================
    @PostMapping("/login")
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            HttpSession session,
            Model model) {

        // Debug (sau này có thể xóa)
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);

        User user = service.login(username, password);

        System.out.println("User: " + user);

        if (user == null) {

            model.addAttribute(
                    "error",
                    "Username hoặc Password không đúng hoặc tài khoản đã bị khóa!");

            return "login/form";
        }

        // Lưu thông tin User vào Session
        session.setAttribute("user", user);

        // Chuyển về Home
        return "redirect:/";
    }

    // ==========================
    // Logout
    // ==========================
    @GetMapping("/logout")
    public String logout(HttpSession session) {

        session.invalidate();

        return "redirect:/login";
    }

}
