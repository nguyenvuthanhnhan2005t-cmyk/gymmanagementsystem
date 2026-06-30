/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uef.edu.vn.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author ADMIN
 */
@Controller
public class HomeController {

    @GetMapping("/")
    public String home(HttpSession session, Model model) {

        // Chưa đăng nhập -> chuyển sang Login
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }

        // Đã đăng nhập
        model.addAttribute(
                "body",
                "/WEB-INF/views/home/index.jsp"
        );

        return "layout/main";
    }
}