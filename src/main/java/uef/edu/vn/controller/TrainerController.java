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
import uef.edu.vn.model.Trainer;
import uef.edu.vn.service.TrainerService;

/**
 *
 * @author ADMIN
 */
@Controller
@RequestMapping("/trainers")
public class TrainerController {

    @Autowired
    private TrainerService service;

    private final String path
            = "/WEB-INF/views/trainer/";

    @GetMapping
    public String list(Model model) {
        try {
            model.addAttribute(
                    "trainers",
                    service.getAll());

            model.addAttribute(
                    "body",
                    path + "list.jsp");

            return "layout/main";
        } catch (Exception e) {
            model.addAttribute("error", "Không thể tải danh sách huấn luyện viên: " + e.getMessage());
            model.addAttribute("body", "error.jsp");
            return "layout/main";
        }
    }

    @GetMapping("/add")
    public String add(Model model) {
        try {
            model.addAttribute(
                    "trainer",
                    new Trainer());

            model.addAttribute(
                    "body",
                    path + "form.jsp");

            return "layout/main";
        } catch (Exception e) {
            model.addAttribute("error", "Không thể mở form thêm huấn luyện viên: " + e.getMessage());
            model.addAttribute("body", "error.jsp");
            return "layout/main";
        }
    }

    @PostMapping("/save")
    public String save(
            @ModelAttribute Trainer trainer,
            Model model) {
        try {
            service.add(trainer);
            return "redirect:/trainers";
        } catch (Exception e) {
            model.addAttribute("error", "Thêm huấn luyện viên thất bại: " + e.getMessage());
            model.addAttribute("trainer", trainer);
            model.addAttribute("body", path + "form.jsp");
            return "layout/main";
        }
    }

    @GetMapping("/edit/{id}")
    public String edit(
            @PathVariable("id") int id,
            Model model) {
        try {
            model.addAttribute(
                    "trainer",
                    service.getById(id));

            model.addAttribute(
                    "body",
                    path + "form.jsp");

            return "layout/main";
        } catch (Exception e) {
            model.addAttribute("error", "Không tìm thấy huấn luyện viên: " + e.getMessage());
            model.addAttribute("body", "error.jsp");
            return "layout/main";
        }
    }

    @PostMapping("/update")
    public String update(
            @ModelAttribute Trainer trainer,
            Model model) {
        try {
            service.update(trainer);
            return "redirect:/trainers";
        } catch (Exception e) {
            model.addAttribute("error", "Cập nhật huấn luyện viên thất bại: " + e.getMessage());
            model.addAttribute("trainer", trainer);
            model.addAttribute("body", path + "form.jsp");
            return "layout/main";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(
            @PathVariable("id") int id,
            Model model) {
        try {
            service.delete(id);
            return "redirect:/trainers";
        } catch (Exception e) {
            model.addAttribute("error", "Xóa huấn luyện viên thất bại: " + e.getMessage());
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
                    "trainers",
                    service.search(keyword));

            model.addAttribute(
                    "keyword",
                    keyword);

            model.addAttribute(
                    "body",
                    path + "list.jsp");

            return "layout/main";

        } catch (Exception e) {

            model.addAttribute(
                    "error",
                    "Tìm kiếm huấn luyện viên thất bại: " + e.getMessage());

            model.addAttribute(
                    "trainers",
                    service.getAll());

            model.addAttribute(
                    "body",
                    path + "list.jsp");

            return "layout/main";
        }
    }
}
