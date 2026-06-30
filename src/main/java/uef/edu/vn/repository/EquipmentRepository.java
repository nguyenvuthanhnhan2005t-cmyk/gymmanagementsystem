/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uef.edu.vn.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uef.edu.vn.model.Equipment;

/**
 *
 * @author Nguyen Nhu Trung
 */
@Repository
public class EquipmentRepository {

    private final JdbcTemplate jdbcTemplate;

    public EquipmentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private Equipment mapRow(
            ResultSet rs,
            int rowNum) throws SQLException {

        Equipment e = new Equipment();

        e.setEquipmentID(
                rs.getInt("equipmentID"));

        e.setEquipmentName(
                rs.getString("equipmentName"));

        e.setCategory(
                rs.getString("category"));

        e.setQuantity(
                rs.getInt("quantity"));

        e.setPurchaseDate(
                rs.getDate("purchaseDate")
                        .toLocalDate());

        e.setStatus(
                rs.getString("status"));

        e.setLocation(
                rs.getString("location"));

        return e;
    }

    public List<Equipment> findAll() {

        try {

            String sql
                    = "SELECT * FROM Equipment";

            return jdbcTemplate.query(
                    sql,
                    this::mapRow
            );

        } catch (Exception e) {

            System.err.println(
                    "Error loading equipment list: "
                    + e.getMessage());

            e.printStackTrace();

            return new ArrayList<>();
        }
    }

    public Equipment findById(int id) {

        try {

            String sql
                    = "SELECT * FROM Equipment WHERE equipmentID=?";

            return jdbcTemplate.queryForObject(
                    sql,
                    this::mapRow,
                    id
            );

        } catch (Exception e) {

            System.err.println(
                    "Error finding equipment: "
                    + e.getMessage());

            e.printStackTrace();

            return null;
        }
    }

    public void save(Equipment e) {

        try {

            String sql
                    = "INSERT INTO Equipment(equipmentName,category,quantity,purchaseDate,status,location) VALUES(?,?,?,?,?,?)";

            jdbcTemplate.update(
                    sql,
                    e.getEquipmentName(),
                    e.getCategory(),
                    e.getQuantity(),
                    e.getPurchaseDate(),
                    e.getStatus(),
                    e.getLocation()
            );

        } catch (Exception ex) {

            System.err.println(
                    "Error saving equipment: "
                    + ex.getMessage());

            ex.printStackTrace();
        }
    }

    public void update(Equipment e) {

        try {

            String sql
                    = "UPDATE Equipment SET equipmentName=?,category=?,quantity=?,purchaseDate=?,status=?,location=? WHERE equipmentID=?";

            jdbcTemplate.update(
                    sql,
                    e.getEquipmentName(),
                    e.getCategory(),
                    e.getQuantity(),
                    e.getPurchaseDate(),
                    e.getStatus(),
                    e.getLocation(),
                    e.getEquipmentID()
            );

        } catch (Exception ex) {

            System.err.println(
                    "Error updating equipment: "
                    + ex.getMessage());

            ex.printStackTrace();
        }
    }

    public void delete(int id) {

        try {

            jdbcTemplate.update(
                    "DELETE FROM Equipment WHERE equipmentID=?",
                    id
            );

        } catch (Exception e) {

            System.err.println(
                    "Error deleting equipment: "
                    + e.getMessage());

            e.printStackTrace();
        }
    }

    // Tìm kiếm Equipment theo tên, loại, trạng thái hoặc vị trí
    public List<Equipment> search(String keyword) {

        try {

            String sql = " SELECT * FROM Equipment WHERE equipmentName LIKE ? OR category LIKE ? OR status LIKE ? OR location LIKE ? ";

            String key = "%" + keyword + "%";

            return jdbcTemplate.query(
                    sql,
                    this::mapRow,
                    key,
                    key,
                    key,
                    key
            );

        } catch (Exception e) {

            System.err.println(
                    "Error searching equipment: "
                    + e.getMessage());

            e.printStackTrace();

            return new ArrayList<>();
        }
    }
}
