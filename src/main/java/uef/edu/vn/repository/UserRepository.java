/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uef.edu.vn.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uef.edu.vn.model.User;

/**
 *
 * @author ADMIN
 */
@Repository
public class UserRepository {
    
     @Autowired
    private JdbcTemplate jdbcTemplate;
     
     private User mapRow(ResultSet rs, int rowNum) throws SQLException {

        User u = new User();

        u.setUserId(rs.getInt("userId"));
        u.setUsername(rs.getString("username"));
        u.setPassword(rs.getString("password"));
        u.setFullName(rs.getString("fullName"));
        u.setEmail(rs.getString("email"));
        u.setRole(rs.getString("role"));
        u.setStatus(rs.getString("status"));

        return u;
    }

    // Login
    public User login(String username, String password) {

        try {

            String sql = " SELECT * FROM Users WHERE username=? AND password=? AND status='ACTIVE' ";

            return jdbcTemplate.queryForObject(
                    sql,
                    this::mapRow,
                    username,
                    password);

        } catch (Exception e) {

            return null;

        }

    }

    // Tìm theo username
    public User findByUsername(String username) {

        try {

            return jdbcTemplate.queryForObject(
                    "SELECT * FROM Users WHERE username=?",
                    this::mapRow,
                    username);

        } catch (Exception e) {

            return null;

        }

    }
    
    public User findById(int userId) {

    try {

        return jdbcTemplate.queryForObject(
                "SELECT * FROM Users WHERE userId=?",
                this::mapRow,
                userId);

    } catch (Exception e) {

        return null;

    }

}

    // Đổi mật khẩu
    public void changePassword(int userId, String newPassword) {

        try {

            jdbcTemplate.update(
                    "UPDATE Users SET password=? WHERE userId=?",
                    newPassword,
                    userId);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }
    
}
