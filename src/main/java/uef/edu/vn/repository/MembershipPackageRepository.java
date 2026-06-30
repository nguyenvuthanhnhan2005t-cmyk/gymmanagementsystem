/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uef.edu.vn.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uef.edu.vn.model.MembershipPackage;

/**
 *
 * @author ADMIN
 */
@Repository
public class MembershipPackageRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private MembershipPackage mapRow(ResultSet rs, int rowNum) throws SQLException {

        MembershipPackage p = new MembershipPackage();

        p.setPackageId(rs.getInt("package_id"));
        p.setPackageName(rs.getString("package_name"));
        p.setDescription(rs.getString("description"));
        p.setDurationMonths(rs.getInt("duration_months"));
        p.setPrice(rs.getDouble("price"));
        p.setStatus(rs.getString("status"));

        return p;
    }

    // LIST ALL
    public List<MembershipPackage> findAll() {
        try {
            return jdbcTemplate.query(
                    "SELECT * FROM membership_package",
                    this::mapRow
            );
        } catch (Exception e) {
            System.err.println("Error findAll package: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    // FIND BY ID
    public MembershipPackage findById(int id) {
        try {
            return jdbcTemplate.queryForObject(
                    "SELECT * FROM membership_package WHERE package_id=?",
                    this::mapRow,
                    id
            );
        } catch (Exception e) {
            System.err.println("Error findById package: " + e.getMessage());
            return null;
        }
    }

    // SEARCH
    public List<MembershipPackage> search(String keyword) {
        try {
            String sql = " SELECT * FROM membership_package WHERE package_name LIKE ? OR description LIKE ? ";

            String key = "%" + keyword + "%";

            return jdbcTemplate.query(sql, this::mapRow, key, key);

        } catch (Exception e) {
            System.err.println("Error search package: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
