/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uef.edu.vn.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uef.edu.vn.model.MembershipPackage;
import uef.edu.vn.repository.MembershipPackageRepository;

/**
 *
 * @author ADMIN
 */
@Service
public class MembershipPackageService {
    
    @Autowired
    private MembershipPackageRepository repository;
    
    public List<MembershipPackage> getAll() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            System.err.println("Service error getAll: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public MembershipPackage getById(int id) {
        try {
            return repository.findById(id);
        } catch (Exception e) {
            System.err.println("Service error getById: " + e.getMessage());
            return null;
        }
    }

    public List<MembershipPackage> search(String keyword) {
        try {
            return repository.search(keyword);
        } catch (Exception e) {
            System.err.println("Service error search: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
