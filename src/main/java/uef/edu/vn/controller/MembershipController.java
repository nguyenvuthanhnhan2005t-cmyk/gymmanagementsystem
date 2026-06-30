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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import uef.edu.vn.model.Membership;
import uef.edu.vn.service.MembershipService;

/**
 *
 * @author ADMIN
 */
@Controller
@RequestMapping("/memberships")
public class MembershipController {

    @Autowired
    private MembershipService membershipService;

    @GetMapping
    public String list(Model model) {

        try {

            model.addAttribute(
                    "memberships",
                    membershipService.getAll()
            );

            model.addAttribute(
                    "body",
                    "/WEB-INF/views/membership/list.jsp"
            );

        } catch (Exception e) {

            System.err.println(
                    "Error loading membership list: "
                    + e.getMessage());

            e.printStackTrace();

            model.addAttribute(
                    "error",
                    "Cannot load membership list.");

            model.addAttribute(
                    "body",
                    "/WEB-INF/views/membership/list.jsp"
            );
        }

        return "layout/main";
    }

    @GetMapping("/add")
    public String addForm(Model model) {

        try {

            model.addAttribute(
                    "membership",
                    new Membership()
            );

            model.addAttribute(
                    "body",
                    "/WEB-INF/views/membership/form.jsp"
            );

        } catch (Exception e) {

            System.err.println(
                    "Error opening membership form: "
                    + e.getMessage());

            e.printStackTrace();

            model.addAttribute(
                    "error",
                    "Cannot open membership form.");

            model.addAttribute(
                    "body",
                    "/WEB-INF/views/membership/form.jsp"
            );
        }

        return "layout/main";
    }

    @PostMapping("/add")
    public String save(
            @ModelAttribute Membership membership,
            Model model) {

        try {

            membershipService.add(membership);

            return "redirect:/memberships";

        } catch (Exception e) {

            System.err.println(
                    "Error saving membership: "
                    + e.getMessage());

            e.printStackTrace();

            model.addAttribute(
                    "membership",
                    membership);

            model.addAttribute(
                    "error",
                    "Save membership failed.");

            model.addAttribute(
                    "body",
                    "/WEB-INF/views/membership/form.jsp"
            );

            return "layout/main";
        }
    }

    @GetMapping("/search")
    public String search(
            @RequestParam("keyword") String keyword,
            Model model) {

        try {

            model.addAttribute(
                    "memberships",
                    membershipService.search(keyword));

            model.addAttribute(
                    "keyword",
                    keyword);

        } catch (Exception e) {

            System.err.println(
                    "Error searching membership: "
                    + e.getMessage());

            e.printStackTrace();

            model.addAttribute(
                    "error",
                    "Search membership failed.");

            model.addAttribute(
                    "memberships",
                    membershipService.getAll());
        }

        model.addAttribute(
                "body",
                "/WEB-INF/views/membership/list.jsp");

        return "layout/main";
    }
}
