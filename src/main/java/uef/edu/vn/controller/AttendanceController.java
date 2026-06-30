/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uef.edu.vn.controller;

import uef.edu.vn.model.AttendanceModel;
import uef.edu.vn.service.AttendanceService;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Admin
 */
@Controller
@RequestMapping("/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    private final String path
            = "/WEB-INF/views/attendance/";

    @GetMapping
    public String list(Model model) {

        try {

            model.addAttribute(
                    "attendanceList",
                    attendanceService.getAll());

            model.addAttribute(
                    "body",
                    path + "list.jsp");

        } catch (Exception e) {

            e.printStackTrace();

            model.addAttribute(
                    "error",
                    "Cannot load attendance list!");

            model.addAttribute(
                    "body",
                    path + "list.jsp");
        }

        return "layout/main";
    }

    @GetMapping("/add")
    public String addForm(Model model) {

        try {

            model.addAttribute(
                    "attendance",
                    new AttendanceModel());

            model.addAttribute(
                    "body",
                    path + "form.jsp");

        } catch (Exception e) {

            e.printStackTrace();

            model.addAttribute(
                    "error",
                    "Cannot open add attendance form!");

            model.addAttribute(
                    "body",
                    path + "form.jsp");
        }

        return "layout/main";
    }

    @PostMapping("/add")
    public String save(
            @ModelAttribute AttendanceModel attendance,
            Model model) {

        try {

            attendanceService.add(attendance);

            return "redirect:/attendance";

        } catch (Exception e) {

            e.printStackTrace();

            model.addAttribute(
                    "error",
                    "Add attendance failed!");

            model.addAttribute(
                    "attendance",
                    attendance);

            model.addAttribute(
                    "body",
                    path + "form.jsp");

            return "layout/main";
        }
    }

    @GetMapping("/edit/{id}")
    public String edit(
            @PathVariable("id") int id,
            Model model) {

        try {

            model.addAttribute(
                    "attendance",
                    attendanceService.getById(id));

            model.addAttribute(
                    "body",
                    path + "form.jsp");

        } catch (Exception e) {

            e.printStackTrace();

            model.addAttribute(
                    "error",
                    "Attendance not found!");

            model.addAttribute(
                    "body",
                    path + "list.jsp");
        }

        return "layout/main";
    }

    @PostMapping("/edit")
    public String update(
            @ModelAttribute AttendanceModel attendance,
            Model model) {

        try {

            attendanceService.update(attendance);

            return "redirect:/attendance";

        } catch (Exception e) {

            e.printStackTrace();

            model.addAttribute(
                    "error",
                    "Update attendance failed!");

            model.addAttribute(
                    "attendance",
                    attendance);

            model.addAttribute(
                    "body",
                    path + "form.jsp");

            return "layout/main";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(
            @PathVariable("id") int id,
            Model model) {

        try {

            attendanceService.delete(id);

        } catch (Exception e) {

            e.printStackTrace();

            model.addAttribute(
                    "error",
                    "Delete attendance failed!");
        }

        return "redirect:/attendance";
    }

    @GetMapping("/search")
    public String search(
            @RequestParam("keyword") String keyword,
            Model model) {

        try {

            model.addAttribute(
                    "attendanceList",
                    attendanceService.search(keyword));

            model.addAttribute(
                    "keyword",
                    keyword);

            model.addAttribute(
                    "body",
                    path + "list.jsp");

        } catch (Exception e) {

            e.printStackTrace();

            model.addAttribute(
                    "error",
                    "Search attendance failed!");

            model.addAttribute(
                    "attendanceList",
                    attendanceService.getAll());

            model.addAttribute(
                    "body",
                    path + "list.jsp");
        }

        return "layout/main";
    }
}
