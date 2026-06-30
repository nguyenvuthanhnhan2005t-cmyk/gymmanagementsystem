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
import uef.edu.vn.model.Member;

/**
 *
 * @author ADMIN
 */
@Repository
public class MemberRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private Member mapRow(ResultSet rs, int rowNum) throws SQLException {

        Member m = new Member();

        m.setMemberID(rs.getInt("memberID"));
        m.setFullName(rs.getString("fullName"));
        m.setPhone(rs.getString("phone"));
        m.setEmail(rs.getString("email"));
        m.setGender(rs.getString("gender"));
        m.setBirthDate(rs.getDate("birthDate").toLocalDate());
        m.setMembershipType(rs.getString("membershipType"));
        m.setStatus(rs.getString("status"));

        return m;
    }

    public List<Member> findAll() {

        try {

            return jdbcTemplate.query(
                    "SELECT * FROM Member",
                    this::mapRow);

        } catch (Exception e) {

            System.out.println("Error findAll(): " + e.getMessage());
            e.printStackTrace();

            return new ArrayList<>();
        }
    }

    public Member findById(int id) {

        try {

            return jdbcTemplate.queryForObject(
                    "SELECT * FROM Member WHERE memberID=?",
                    this::mapRow,
                    id);

        } catch (Exception e) {

            System.out.println("Error findById(): " + e.getMessage());
            e.printStackTrace();

            return null;
        }
    }

    public void save(Member m) {

        try {

            String sql = "INSERT INTO Member(fullName,phone,email,gender,birthDate,membershipType,status) VALUES(?,?,?,?,?,?,?)";

            jdbcTemplate.update(
                    sql,
                    m.getFullName(),
                    m.getPhone(),
                    m.getEmail(),
                    m.getGender(),
                    m.getBirthDate(),
                    m.getMembershipType(),
                    m.getStatus());

        } catch (Exception e) {

            System.out.println("Error save(): " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void update(Member m) {

        try {

            String sql = "UPDATE Member SET fullName=?,phone=?,email=?,gender=?,birthDate=?,membershipType=?,status=? WHERE memberID=?";

            jdbcTemplate.update(
                    sql,
                    m.getFullName(),
                    m.getPhone(),
                    m.getEmail(),
                    m.getGender(),
                    m.getBirthDate(),
                    m.getMembershipType(),
                    m.getStatus(),
                    m.getMemberID());

        } catch (Exception e) {

            System.out.println("Error update(): " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void delete(int id) {

        try {

            jdbcTemplate.update(
                    "DELETE FROM Member WHERE memberID=?",
                    id);

        } catch (Exception e) {

            System.out.println("Error delete(): " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Tìm kiếm Member theo tên, email hoặc số điện thoại
    public List<Member> search(String keyword) {

        try {

            String sql = " SELECT * FROM Member WHERE fullName LIKE ? OR email LIKE ? OR phone LIKE ? ";

            String key = "%" + keyword + "%";

            return jdbcTemplate.query(
                    sql,
                    this::mapRow,
                    key,
                    key,
                    key
            );

        } catch (Exception e) {

            System.out.println("Error search(): " + e.getMessage());
            e.printStackTrace();

            return new ArrayList<>();
        }
    }
}
