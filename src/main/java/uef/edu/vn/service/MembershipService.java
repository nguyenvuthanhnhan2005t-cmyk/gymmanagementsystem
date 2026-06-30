/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uef.edu.vn.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uef.edu.vn.model.Membership;
import uef.edu.vn.repository.MembershipRepository;

/**
 *
 * @author ADMIN
 */
@Service
public class MembershipService {

    @Autowired
    private MembershipRepository membershipRepository;

    public List<Membership> getAll() {

        try {

            return membershipRepository.findAll();

        } catch (Exception e) {

            System.err.println(
                    "Error getting membership list: "
                    + e.getMessage());

            e.printStackTrace();

            return new ArrayList<>();
        }
    }

    public Membership getById(int id) {

        try {

            return membershipRepository.findById(id);

        } catch (Exception e) {

            System.err.println(
                    "Error finding membership: "
                    + e.getMessage());

            e.printStackTrace();

            return null;
        }
    }

    public void add(Membership membership) {

        try {

            if (membership.getEndDate().isBefore(LocalDate.now())) {

                membership.setStatus("Expired");

            } else {

                membership.setStatus("Active");
            }

            membershipRepository.save(membership);

        } catch (Exception e) {

            System.err.println(
                    "Error adding membership: "
                    + e.getMessage());

            e.printStackTrace();
        }
    }

    public void update(Membership membership) {

        try {

            if (membership.getEndDate().isBefore(LocalDate.now())) {

                membership.setStatus("Expired");

            } else {

                membership.setStatus("Active");
            }

            membershipRepository.update(membership);

        } catch (Exception e) {

            System.err.println(
                    "Error updating membership: "
                    + e.getMessage());

            e.printStackTrace();
        }
    }

    public void delete(int id) {

        try {

            membershipRepository.delete(id);

        } catch (Exception e) {

            System.err.println(
                    "Error deleting membership: "
                    + e.getMessage());

            e.printStackTrace();
        }
    }

    // Tìm kiếm Membership theo Member ID, Package Name hoặc Status
    public List<Membership> search(String keyword) {

        try {

            return membershipRepository.search(keyword);

        } catch (Exception e) {

            System.err.println(
                    "Error searching membership: "
                    + e.getMessage());

            e.printStackTrace();

            return new ArrayList<>();
        }
    }
}
