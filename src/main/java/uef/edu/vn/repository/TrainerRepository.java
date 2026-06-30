/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uef.edu.vn.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uef.edu.vn.model.Trainer;

/**
 *
 * @author ADMIN
 */
@Repository
public class TrainerRepository {

    private final JdbcTemplate jdbcTemplate;

    public TrainerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private Trainer mapRow(
            ResultSet rs,
            int rowNum) throws SQLException {

        Trainer t = new Trainer();

        t.setTrainerID(
                rs.getInt("trainerID"));

        t.setFullName(
                rs.getString("fullName"));

        t.setPhone(
                rs.getString("phone"));

        t.setEmail(
                rs.getString("email"));

        t.setGender(
                rs.getString("gender"));

        t.setSpecialty(
                rs.getString("specialty"));

        t.setExperienceYears(
                rs.getInt("experienceYears"));

        t.setSalary(
                rs.getDouble("salary"));

        t.setStatus(
                rs.getString("status"));

        return t;
    }

    public List<Trainer> findAll() {
        try {
            return jdbcTemplate.query(
                    "SELECT * FROM Trainer",
                    this::mapRow
            );
        } catch (Exception e) {
            System.err.println("Error in findAll(): " + e.getMessage());
            throw e;
        }
    }

    public Trainer findById(int id) {
        try {
            return jdbcTemplate.queryForObject(
                    "SELECT * FROM Trainer WHERE trainerID=?",
                    this::mapRow,
                    id
            );
        } catch (Exception e) {
            System.err.println("Error in findById(): " + e.getMessage());
            throw e;
        }
    }

    public void save(Trainer t) {
        try {
            String sql
                    = "INSERT INTO Trainer(fullName,phone,email,gender,specialty,experienceYears,salary,status) VALUES(?,?,?,?,?,?,?,?)";

            jdbcTemplate.update(
                    sql,
                    t.getFullName(),
                    t.getPhone(),
                    t.getEmail(),
                    t.getGender(),
                    t.getSpecialty(),
                    t.getExperienceYears(),
                    t.getSalary(),
                    t.getStatus()
            );
        } catch (Exception e) {
            System.err.println("Error in save(): " + e.getMessage());
            throw e;
        }
    }

    public void update(Trainer t) {
        try {
            String sql
                    = "UPDATE Trainer SET fullName=?,phone=?,email=?,gender=?,specialty=?,experienceYears=?,salary=?,status=? WHERE trainerID=?";

            jdbcTemplate.update(
                    sql,
                    t.getFullName(),
                    t.getPhone(),
                    t.getEmail(),
                    t.getGender(),
                    t.getSpecialty(),
                    t.getExperienceYears(),
                    t.getSalary(),
                    t.getStatus(),
                    t.getTrainerID()
            );
        } catch (Exception e) {
            System.err.println("Error in update(): " + e.getMessage());
            throw e;
        }
    }

    public void delete(int id) {
        try {
            jdbcTemplate.update(
                    "DELETE FROM Trainer WHERE trainerID=?",
                    id
            );
        } catch (Exception e) {
            System.err.println("Error in delete(): " + e.getMessage());
            throw e;
        }
    }

    public List<Trainer> search(String keyword) {
        try {

           String sql = " SELECT * FROM Trainer WHERE fullName LIKE ? OR email LIKE ? OR phone LIKE ? ";

            String key = "%" + keyword + "%";

            return jdbcTemplate.query(
                    sql,
                    this::mapRow,
                    key,
                    key,
                    key
            );

        } catch (Exception e) {

            System.err.println("Error in search(): " + e.getMessage());
            throw e;
        }
    }
}
