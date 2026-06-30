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
import uef.edu.vn.model.Member;
import uef.edu.vn.service.MemberService;

/**
 *
 * @author ADMIN
 */
@Controller
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    private final String path = "/WEB-INF/views/Member/";

    @GetMapping
    public String list(Model model) {

        try {

            model.addAttribute(
                    "members",
                    memberService.getAll());

        } catch (Exception e) {

            model.addAttribute(
                    "error",
                    "Cannot load member list!");

            e.printStackTrace();
        }

        model.addAttribute(
                "body",
                path + "list.jsp");

        return "layout/main";
    }

    @GetMapping("/add")
    public String addForm(Model model) {

        try {

            model.addAttribute(
                    "member",
                    new Member());

        } catch (Exception e) {

            model.addAttribute(
                    "error",
                    "Cannot open Add Member page.");

            e.printStackTrace();
        }

        model.addAttribute(
                "body",
                path + "form.jsp");

        return "layout/main";
    }

    @PostMapping("/add")
    public String save(@ModelAttribute Member member,
            Model model) {

        try {

            memberService.add(member);

            return "redirect:/members";

        } catch (Exception e) {

            model.addAttribute(
                    "error",
                    "Failed to add member.");

            model.addAttribute(
                    "member",
                    member);

            model.addAttribute(
                    "body",
                    path + "form.jsp");

            e.printStackTrace();

            return "layout/main";
        }

    }

    @GetMapping("/edit/{id}")
    public String edit(
            @PathVariable("id") int id,
            Model model) {

        try {

            model.addAttribute(
                    "member",
                    memberService.getById(id));

        } catch (Exception e) {

            model.addAttribute(
                    "error",
                    "Member not found.");

            e.printStackTrace();
        }

        model.addAttribute(
                "body",
                path + "form.jsp");

        return "layout/main";
    }

    @PostMapping("/edit")
    public String update(
            @ModelAttribute Member member,
            Model model) {

        try {

            memberService.update(member);

            return "redirect:/members";

        } catch (Exception e) {

            model.addAttribute(
                    "error",
                    "Failed to update member.");

            model.addAttribute(
                    "member",
                    member);

            model.addAttribute(
                    "body",
                    path + "form.jsp");

            e.printStackTrace();

            return "layout/main";
        }

    }

    @GetMapping("/delete/{id}")
    public String delete(
            @PathVariable("id") int id,
            Model model) {

        try {

            memberService.delete(id);

        } catch (Exception e) {

            model.addAttribute(
                    "error",
                    "Failed to delete member.");

            e.printStackTrace();
        }

        return "redirect:/members";
    }

    @GetMapping("/search")
    public String search(
            @RequestParam("keyword") String keyword,
            Model model) {

        try {

            model.addAttribute(
                    "members",
                    memberService.search(keyword));

            model.addAttribute(
                    "keyword",
                    keyword);

        } catch (Exception e) {

            model.addAttribute(
                    "error",
                    "Search member failed!");

            model.addAttribute(
                    "members",
                    memberService.getAll());

            e.printStackTrace();
        }

        model.addAttribute(
                "body",
                path + "list.jsp");

        return "layout/main";
    }
}
