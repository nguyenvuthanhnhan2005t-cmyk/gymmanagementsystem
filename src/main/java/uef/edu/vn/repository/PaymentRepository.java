/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uef.edu.vn.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;
import org.springframework.stereotype.Repository;
import uef.edu.vn.model.Payment;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Nguyen Nhu Trung
 */
@Repository
public class PaymentRepository {

    private final JdbcTemplate jdbcTemplate;

    public PaymentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private Payment mapRow(ResultSet rs, int rowNum)
            throws SQLException {

        Payment p = new Payment();

        p.setPaymentID(rs.getInt("paymentID"));
        p.setMemberID(rs.getInt("memberID"));
        p.setAmount(rs.getDouble("amount"));
        p.setPaymentDate(rs.getDate("paymentDate").toLocalDate());
        p.setPaymentMethod(rs.getString("paymentMethod"));
        p.setStatus(rs.getString("status"));

        return p;
    }

    public List<Payment> findAll() {
        try {
            String sql = "SELECT * FROM Payment";

            return jdbcTemplate.query(
                    sql,
                    this::mapRow
            );

        } catch (Exception e) {
            System.out.println("Error in findAll(): " + e.getMessage());
            throw e;
        }
    }

    public Payment findById(int id) {
        try {
            String sql = "SELECT * FROM Payment WHERE paymentID=?";

            return jdbcTemplate.queryForObject(
                    sql,
                    this::mapRow,
                    id
            );

        } catch (Exception e) {
            System.out.println("Error in findById(): " + e.getMessage());
            throw e;
        }
    }

    public void save(Payment payment) {
        try {
            String sql = "INSERT INTO Payment(memberID, amount, paymentDate, paymentMethod, status) VALUES(?,?,?,?,?)";

            jdbcTemplate.update(
                    sql,
                    payment.getMemberID(),
                    payment.getAmount(),
                    payment.getPaymentDate(),
                    payment.getPaymentMethod(),
                    payment.getStatus()
            );

        } catch (Exception e) {
            System.out.println("Error in save(): " + e.getMessage());
            throw e;
        }
    }

    public void update(Payment payment) {
        try {
            String sql = "UPDATE Payment SET memberID=?, amount=?, paymentDate=?, paymentMethod=?, status=? WHERE paymentID=?";

            jdbcTemplate.update(
                    sql,
                    payment.getMemberID(),
                    payment.getAmount(),
                    payment.getPaymentDate(),
                    payment.getPaymentMethod(),
                    payment.getStatus(),
                    payment.getPaymentID()
            );

        } catch (Exception e) {
            System.out.println("Error in update(): " + e.getMessage());
            throw e;
        }
    }

    public void delete(int id) {
        try {
            jdbcTemplate.update(
                    "DELETE FROM Payment WHERE paymentID=?",
                    id
            );

        } catch (Exception e) {
            System.out.println("Error in delete(): " + e.getMessage());
            throw e;
        }
    }
    
    // Tìm kiếm Payment theo Member ID, Payment Method hoặc Status
public List<Payment> search(String keyword) {

    try {

        String sql = " SELECT * FROM Payment WHERE CAST(memberID AS CHAR) LIKE ? OR paymentMethod LIKE ? OR status LIKE ? ";

        String key = "%" + keyword + "%";

        return jdbcTemplate.query(
                sql,
                this::mapRow,
                key,
                key,
                key
        );

    } catch (Exception e) {

        System.out.println("Error in search(): " + e.getMessage());
        throw e;
    }
}
}