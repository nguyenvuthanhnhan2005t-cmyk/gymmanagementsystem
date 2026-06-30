/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uef.edu.vn.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uef.edu.vn.model.Trainer;
import uef.edu.vn.repository.TrainerRepository;

/**
 *
 * @author ADMIN
 */
@Service
public class TrainerService {

    @Autowired
    private TrainerRepository repository;

    public List<Trainer> getAll() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            System.err.println("Error in getAll(): " + e.getMessage());
            throw e;
        }
    }

    public Trainer getById(int id) {
        try {
            return repository.findById(id);
        } catch (Exception e) {
            System.err.println("Error in getById(): " + e.getMessage());
            throw e;
        }
    }

    public void add(Trainer trainer) {
        try {
            repository.save(trainer);
        } catch (Exception e) {
            System.err.println("Error in add(): " + e.getMessage());
            throw e;
        }
    }

    public void update(Trainer trainer) {
        try {
            repository.update(trainer);
        } catch (Exception e) {
            System.err.println("Error in update(): " + e.getMessage());
            throw e;
        }
    }

    public void delete(int id) {
        try {
            repository.delete(id);
        } catch (Exception e) {
            System.err.println("Error in delete(): " + e.getMessage());
            throw e;
        }
    }

    public List<Trainer> search(String keyword) {
        try {
            return repository.search(keyword);
        } catch (Exception e) {
            System.err.println("Error in search(): " + e.getMessage());
            throw e;
        }
    }
}
