/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uef.edu.vn.service;

import java.util.ArrayList;
import uef.edu.vn.model.AttendanceModel;
import uef.edu.vn.repository.AttendanceRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository repository;

    public List<AttendanceModel> getAll() {

        try {

            return repository.findAll();

        } catch (Exception e) {

            System.err.println(
                    "Error getting attendance list: "
                    + e.getMessage());

            e.printStackTrace();

            return new ArrayList<>();
        }
    }

    public AttendanceModel getById(int id) {

        try {

            return repository.findById(id);

        } catch (Exception e) {

            System.err.println(
                    "Error finding attendance: "
                    + e.getMessage());

            e.printStackTrace();

            return null;
        }
    }

    public void add(AttendanceModel attendance) {

        try {

            repository.save(attendance);

        } catch (Exception e) {

            System.err.println(
                    "Error adding attendance: "
                    + e.getMessage());

            e.printStackTrace();
        }
    }

    public void update(AttendanceModel attendance) {

        try {

            repository.update(attendance);

        } catch (Exception e) {

            System.err.println(
                    "Error updating attendance: "
                    + e.getMessage());

            e.printStackTrace();
        }
    }

    public void delete(int id) {

        try {

            repository.delete(id);

        } catch (Exception e) {

            System.err.println(
                    "Error deleting attendance: "
                    + e.getMessage());

            e.printStackTrace();
        }
    }

    public List<AttendanceModel> search(String keyword) {

        try {

            return repository.search(keyword);

        } catch (Exception e) {

            System.err.println(
                    "Error searching attendance: "
                    + e.getMessage());

            e.printStackTrace();

            return new ArrayList<>();
        }
    }
}
