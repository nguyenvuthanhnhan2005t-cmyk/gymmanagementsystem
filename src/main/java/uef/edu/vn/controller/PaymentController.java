/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uef.edu.vn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import uef.edu.vn.model.Payment;
import uef.edu.vn.service.PaymentService;

/**
 *
 * @author Nguyen Nhu Trung
 */
@Controller
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService service;

    private final String path = "/WEB-INF/views/payment/";

    // Hiển thị danh sách Payment
    @GetMapping
    public String list(Model model) {
        try {
            model.addAttribute("payments", service.findAll());
            model.addAttribute("body", path + "list.jsp");
            return "layout/main";
        } catch (Exception e) {
            model.addAttribute("error", "Không thể tải danh sách thanh toán: " + e.getMessage());
            model.addAttribute("body", "error.jsp");
            return "layout/main";
        }
    }

    // Hiển thị form thêm mới
    @GetMapping("/add")
    public String add(Model model) {
        try {
            model.addAttribute("payment", new Payment());
            model.addAttribute("body", path + "form.jsp");
            return "layout/main";
        } catch (Exception e) {
            model.addAttribute("error", "Không thể mở form thêm mới: " + e.getMessage());
            model.addAttribute("body", "error.jsp");
            return "layout/main";
        }
    }

    // Lưu Payment mới
    @PostMapping("/save")
    public String save(@ModelAttribute Payment payment, Model model) {
        try {
            service.save(payment);
            return "redirect:/payment";
        } catch (Exception e) {
            model.addAttribute("error", "Lưu thanh toán thất bại: " + e.getMessage());
            model.addAttribute("payment", payment);
            model.addAttribute("body", path + "form.jsp");
            return "layout/main";
        }
    }

    // Hiển thị form sửa
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        try {
            model.addAttribute("payment", service.findById(id));
            model.addAttribute("body", path + "form.jsp");
            return "layout/main";
        } catch (Exception e) {
            model.addAttribute("error", "Không tìm thấy thông tin thanh toán: " + e.getMessage());
            model.addAttribute("body", "error.jsp");
            return "layout/main";
        }
    }

    // Cập nhật Payment
    @PostMapping("/update")
    public String update(@ModelAttribute Payment payment, Model model) {
        try {
            service.update(payment);
            return "redirect:/payment";
        } catch (Exception e) {
            model.addAttribute("error", "Cập nhật thanh toán thất bại: " + e.getMessage());
            model.addAttribute("payment", payment);
            model.addAttribute("body", path + "form.jsp");
            return "layout/main";
        }
    }

    // Xóa Payment
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id, Model model) {
        try {
            service.delete(id);
            return "redirect:/payment";
        } catch (Exception e) {
            model.addAttribute("error", "Xóa thanh toán thất bại: " + e.getMessage());
            model.addAttribute("body", "error.jsp");
            return "layout/main";
        }
    }

    @GetMapping("/search")
    public String search(
            @RequestParam("keyword") String keyword,
            Model model) {

        try {

            model.addAttribute(
                    "payments",
                    service.search(keyword));

            model.addAttribute(
                    "keyword",
                    keyword);

        } catch (Exception e) {

            model.addAttribute(
                    "error",
                    "Search payment failed!");

            model.addAttribute(
                    "payments",
                    service.findAll());

            e.printStackTrace();
        }

        model.addAttribute(
                "body",
                path + "list.jsp");

        return "layout/main";
    }
}
