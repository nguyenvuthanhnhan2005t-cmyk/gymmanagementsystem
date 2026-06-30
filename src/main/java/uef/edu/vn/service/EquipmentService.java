/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uef.edu.vn.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uef.edu.vn.model.Equipment;
import uef.edu.vn.repository.EquipmentRepository;

/**
 *
 * @author Nguyen Nhu Trung
 */
@Service
public class EquipmentService {

    @Autowired
    private EquipmentRepository repository;

    public List<Equipment> findAll() {

        try {

            return repository.findAll();

        } catch (Exception e) {

            System.err.println(
                    "EquipmentService - Error loading equipment list: "
                    + e.getMessage());

            e.printStackTrace();

            return new ArrayList<>();
        }
    }

    public Equipment findById(int id) {

        try {

            return repository.findById(id);

        } catch (Exception e) {

            System.err.println(
                    "EquipmentService - Error finding equipment: "
                    + e.getMessage());

            e.printStackTrace();

            return null;
        }
    }

    public void save(Equipment equipment) {

        try {

            repository.save(equipment);

        } catch (Exception e) {

            System.err.println(
                    "EquipmentService - Error saving equipment: "
                    + e.getMessage());

            e.printStackTrace();
        }
    }

    public void update(Equipment equipment) {

        try {

            repository.update(equipment);

        } catch (Exception e) {

            System.err.println(
                    "EquipmentService - Error updating equipment: "
                    + e.getMessage());

            e.printStackTrace();
        }
    }

    public void delete(int id) {

        try {

            repository.delete(id);

        } catch (Exception e) {

            System.err.println(
                    "EquipmentService - Error deleting equipment: "
                    + e.getMessage());

            e.printStackTrace();
        }
    }

    // Tìm kiếm Equipment theo tên, loại, trạng thái hoặc vị trí
    public List<Equipment> search(String keyword) {

        try {

            return repository.search(keyword);

        } catch (Exception e) {

            System.err.println(
                    "EquipmentService - Error searching equipment: "
                    + e.getMessage());

            e.printStackTrace();

            return new ArrayList<>();
        }
    }
}
