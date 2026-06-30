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
import uef.edu.vn.model.Equipment;
import uef.edu.vn.service.EquipmentService;

/**
 *
 * @author Nguyen Nhu Trung
 */
@Controller
@RequestMapping("/equipment")
public class EquipmentController {

    @Autowired
    private EquipmentService service;

    private final String path
            = "/WEB-INF/views/equipment/";

    // Hiển thị danh sách thiết bị
    @GetMapping
    public String list(Model model) {

        try {

            model.addAttribute(
                    "equipments",
                    service.findAll());

            model.addAttribute(
                    "body",
                    path + "list.jsp");

        } catch (Exception e) {

            System.err.println(
                    "Error loading equipment list: "
                    + e.getMessage());

            e.printStackTrace();

            model.addAttribute(
                    "error",
                    "Cannot load equipment list.");

            model.addAttribute(
                    "body",
                    path + "list.jsp");
        }

        return "layout/main";
    }

    // Hiển thị form thêm mới
    @GetMapping("/add")
    public String add(Model model) {

        try {

            model.addAttribute(
                    "equipment",
                    new Equipment());

            model.addAttribute(
                    "body",
                    path + "form.jsp");

        } catch (Exception e) {

            System.err.println(
                    "Error opening add form: "
                    + e.getMessage());

            e.printStackTrace();

            model.addAttribute(
                    "error",
                    "Cannot open add equipment form.");

            model.addAttribute(
                    "body",
                    path + "form.jsp");
        }

        return "layout/main";
    }

    // Lưu thiết bị mới
    @PostMapping("/save")
    public String save(
            @ModelAttribute Equipment equipment,
            Model model) {

        try {

            service.save(equipment);

            return "redirect:/equipment";

        } catch (Exception e) {

            System.err.println(
                    "Error saving equipment: "
                    + e.getMessage());

            e.printStackTrace();

            model.addAttribute(
                    "equipment",
                    equipment);

            model.addAttribute(
                    "error",
                    "Save equipment failed.");

            model.addAttribute(
                    "body",
                    path + "form.jsp");

            return "layout/main";
        }
    }

    // Hiển thị form sửa
    @GetMapping("/edit/{id}")
    public String edit(
            @PathVariable("id") int id,
            Model model) {

        try {

            model.addAttribute(
                    "equipment",
                    service.findById(id));

            model.addAttribute(
                    "body",
                    path + "form.jsp");

        } catch (Exception e) {

            System.err.println(
                    "Error loading equipment: "
                    + e.getMessage());

            e.printStackTrace();

            model.addAttribute(
                    "error",
                    "Equipment not found.");

            model.addAttribute(
                    "body",
                    path + "list.jsp");
        }

        return "layout/main";
    }

    // Cập nhật thiết bị
    @PostMapping("/update")
    public String update(
            @ModelAttribute Equipment equipment,
            Model model) {

        try {

            service.update(equipment);

            return "redirect:/equipment";

        } catch (Exception e) {

            System.err.println(
                    "Error updating equipment: "
                    + e.getMessage());

            e.printStackTrace();

            model.addAttribute(
                    "equipment",
                    equipment);

            model.addAttribute(
                    "error",
                    "Update equipment failed.");

            model.addAttribute(
                    "body",
                    path + "form.jsp");

            return "layout/main";
        }
    }

    // Xóa thiết bị
    @GetMapping("/delete/{id}")
    public String delete(
            @PathVariable("id") int id,
            Model model) {

        try {

            service.delete(id);

        } catch (Exception e) {

            System.err.println(
                    "Error deleting equipment: "
                    + e.getMessage());

            e.printStackTrace();
        }

        return "redirect:/equipment";
    }

    // Tìm kiếm thiết bị
    @GetMapping("/search")
    public String search(
            @RequestParam("keyword") String keyword,
            Model model) {

        try {

            model.addAttribute(
                    "equipments",
                    service.search(keyword));

            model.addAttribute(
                    "keyword",
                    keyword);

        } catch (Exception e) {

            System.err.println(
                    "Error searching equipment: "
                    + e.getMessage());

            e.printStackTrace();

            model.addAttribute(
                    "error",
                    "Search equipment failed.");

            model.addAttribute(
                    "equipments",
                    service.findAll());
        }

        model.addAttribute(
                "body",
                path + "list.jsp");

        return "layout/main";
    }
}
