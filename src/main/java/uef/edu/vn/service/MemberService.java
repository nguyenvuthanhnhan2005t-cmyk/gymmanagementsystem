/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uef.edu.vn.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uef.edu.vn.model.Member;
import uef.edu.vn.repository.MemberRepository;

/**
 *
 * @author ADMIN
 */
@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public List<Member> getAll() {

        try {

            return memberRepository.findAll();

        } catch (Exception e) {

            System.out.println("Service Error - getAll(): " + e.getMessage());
            e.printStackTrace();

            return new ArrayList<>();
        }
    }

    public Member getById(int id) {

        try {

            return memberRepository.findById(id);

        } catch (Exception e) {

            System.out.println("Service Error - getById(): " + e.getMessage());
            e.printStackTrace();

            return null;
        }
    }

    public void add(Member m) {

        try {

            memberRepository.save(m);

        } catch (Exception e) {

            System.out.println("Service Error - add(): " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void update(Member m) {

        try {

            memberRepository.update(m);

        } catch (Exception e) {

            System.out.println("Service Error - update(): " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void delete(int id) {

        try {

            memberRepository.delete(id);

        } catch (Exception e) {

            System.out.println("Service Error - delete(): " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Tìm kiếm Member theo tên, email hoặc số điện thoại
    public List<Member> search(String keyword) {

        try {

            return memberRepository.search(keyword);

        } catch (Exception e) {

            System.out.println("Service Error - search(): " + e.getMessage());
            e.printStackTrace();

            return new ArrayList<>();
        }
    }
}
