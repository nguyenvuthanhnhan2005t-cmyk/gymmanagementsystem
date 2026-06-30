/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uef.edu.vn.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uef.edu.vn.model.Payment;
import uef.edu.vn.repository.PaymentRepository;

/**
 *
 * @author Nguyen Nhu Trung
 */
@Service
public class PaymentService {

    @Autowired
    private PaymentRepository repository;

    // Lấy tất cả Payment
    public List<Payment> findAll() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            System.err.println("Error in findAll(): " + e.getMessage());
            throw e;
        }
    }

    // Tìm theo ID
    public Payment findById(int id) {
        try {
            return repository.findById(id);
        } catch (Exception e) {
            System.err.println("Error in findById(): " + e.getMessage());
            throw e;
        }
    }

    // Thêm Payment
    public void save(Payment payment) {
        try {
            repository.save(payment);
        } catch (Exception e) {
            System.err.println("Error in save(): " + e.getMessage());
            throw e;
        }
    }

    // Cập nhật Payment
    public void update(Payment payment) {
        try {
            repository.update(payment);
        } catch (Exception e) {
            System.err.println("Error in update(): " + e.getMessage());
            throw e;
        }
    }

    // Xóa Payment
    public void delete(int id) {
        try {
            repository.delete(id);
        } catch (Exception e) {
            System.err.println("Error in delete(): " + e.getMessage());
            throw e;
        }
    }

    // Tìm kiếm Payment theo Member ID, Payment Method hoặc Status
    public List<Payment> search(String keyword) {
        try {
            return repository.search(keyword);
        } catch (Exception e) {
            System.err.println("Error in search(): " + e.getMessage());
            throw e;
        }
    }
}
