/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uef.edu.vn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import uef.edu.vn.service.MembershipPackageService;

/**
 *
 * @author ADMIN
 */
@Controller
@RequestMapping("/packages")
public class MembershipPackageController {

    @Autowired
    private MembershipPackageService service;

   private final String path = "/WEB-INF/views/membershippackage/";

    // LIST PUBLIC
    @GetMapping
    public String list(Model model) {

        try {
            model.addAttribute("packages", service.getAll());
        } catch (Exception e) {
            model.addAttribute("error", "Cannot load packages");
        }

        model.addAttribute("body", path + "list.jsp");
        return "layout/main";
    }
    
    

    // VIEW DETAIL
    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model) {

        try {
            model.addAttribute("pkg", service.getById(id));
        } catch (Exception e) {
            model.addAttribute("error", "Package not found");
        }

        model.addAttribute("body", path + "view.jsp");
        return "layout/main";
    }

    // SEARCH
    @GetMapping("/search")
    public String search(@RequestParam String keyword, Model model) {

        try {
            model.addAttribute("packages", service.search(keyword));
            model.addAttribute("keyword", keyword);
        } catch (Exception e) {
            model.addAttribute("error", "Search failed");
        }

        model.addAttribute("body", path + "list.jsp");
        return "layout/main";
    }
}
