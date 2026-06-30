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
import uef.edu.vn.model.Membership;

/**
 *
 * @author ADMIN
 */
@Repository
public class MembershipRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private Membership mapRow(ResultSet rs, int rowNum)
            throws SQLException {

        Membership m = new Membership();

        m.setMembershipID(rs.getInt("membershipID"));
        m.setMemberID(rs.getInt("memberID"));
        m.setPackageName(rs.getString("packageName"));
        m.setStartDate(rs.getDate("startDate").toLocalDate());
        m.setEndDate(rs.getDate("endDate").toLocalDate());
        m.setPrice(rs.getDouble("price"));
        m.setStatus(rs.getString("status"));

        return m;
    }

    public List<Membership> findAll() {

        try {

            return jdbcTemplate.query(
                    "SELECT * FROM Membership",
                    this::mapRow
            );

        } catch (Exception e) {

            System.err.println(
                    "Error loading membership list: "
                    + e.getMessage());

            e.printStackTrace();

            return new ArrayList<>();
        }
    }

    public Membership findById(int id) {

        try {

            return jdbcTemplate.queryForObject(
                    "SELECT * FROM Membership WHERE membershipID=?",
                    this::mapRow,
                    id
            );

        } catch (Exception e) {

            System.err.println(
                    "Error finding membership: "
                    + e.getMessage());

            e.printStackTrace();

            return null;
        }
    }

    public void save(Membership m) {

        try {

            String sql
                    = "INSERT INTO Membership(memberID,packageName,startDate,endDate,price,status) VALUES(?,?,?,?,?,?)";

            jdbcTemplate.update(
                    sql,
                    m.getMemberID(),
                    m.getPackageName(),
                    m.getStartDate(),
                    m.getEndDate(),
                    m.getPrice(),
                    m.getStatus()
            );

        } catch (Exception e) {

            System.err.println(
                    "Error saving membership: "
                    + e.getMessage());

            e.printStackTrace();
        }
    }

    public void update(Membership m) {

        try {

            String sql
                    = "UPDATE Membership SET memberID=?, packageName=?, startDate=?, endDate=?, price=?, status=? WHERE membershipID=?";

            jdbcTemplate.update(
                    sql,
                    m.getMemberID(),
                    m.getPackageName(),
                    m.getStartDate(),
                    m.getEndDate(),
                    m.getPrice(),
                    m.getStatus(),
                    m.getMembershipID()
            );

        } catch (Exception e) {

            System.err.println(
                    "Error updating membership: "
                    + e.getMessage());

            e.printStackTrace();
        }
    }

    public void delete(int id) {

        try {

            jdbcTemplate.update(
                    "DELETE FROM Membership WHERE membershipID=?",
                    id
            );

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

            String sql = " SELECT * FROM Membership WHERE CAST(memberID AS CHAR) LIKE ? OR packageName LIKE ? OR status LIKE ? ";

            String key = "%" + keyword + "%";

            return jdbcTemplate.query(
                    sql,
                    this::mapRow,
                    key,
                    key,
                    key
            );

        } catch (Exception e) {

            System.err.println(
                    "Error searching membership: "
                    + e.getMessage());

            e.printStackTrace();

            return new ArrayList<>();
        }
    }
}
