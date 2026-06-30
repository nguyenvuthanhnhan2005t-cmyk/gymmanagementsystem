/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uef.edu.vn.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import uef.edu.vn.model.AttendanceModel;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Admin
 */
@Repository
public class AttendanceRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private AttendanceModel mapRow(
            ResultSet rs,
            int rowNum) throws SQLException {

        AttendanceModel a = new AttendanceModel();

        a.setAttendanceID(
                rs.getInt("attendanceID"));

        a.setMemberID(
                rs.getInt("memberID"));

        a.setAttendanceDate(
                rs.getDate("attendanceDate")
                        .toLocalDate());

        Timestamp in
                = rs.getTimestamp("checkInTime");

        if (in != null) {
            a.setCheckInTime(
                    in.toLocalDateTime());
        }

        Timestamp out
                = rs.getTimestamp("checkOutTime");

        if (out != null) {
            a.setCheckOutTime(
                    out.toLocalDateTime());
        }

        a.setNote(
                rs.getString("note"));

        return a;
    }

    public List<AttendanceModel> findAll() {

        try {

            return jdbcTemplate.query(
                    "SELECT * FROM Attendance",
                    this::mapRow);

        } catch (Exception e) {

            e.printStackTrace();

            return new ArrayList<>();
        }
    }

    public AttendanceModel findById(int id) {

        try {

            return jdbcTemplate.queryForObject(
                    "SELECT * FROM Attendance WHERE attendanceID=?",
                    this::mapRow,
                    id);

        } catch (Exception e) {

            e.printStackTrace();

            return null;
        }
    }

    public void save(AttendanceModel a) {

        try {

            String sql
                    = "INSERT INTO Attendance(memberID,attendanceDate,checkInTime,checkOutTime,note) VALUES(?,?,?,?,?)";

            jdbcTemplate.update(
                    sql,
                    a.getMemberID(),
                    a.getAttendanceDate(),
                    a.getCheckInTime() == null
                    ? null
                    : Timestamp.valueOf(a.getCheckInTime()),
                    a.getCheckOutTime() == null
                    ? null
                    : Timestamp.valueOf(a.getCheckOutTime()),
                    a.getNote()
            );

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public void update(AttendanceModel a) {

        try {

            String sql
                    = "UPDATE Attendance SET memberID=?,attendanceDate=?,checkInTime=?,checkOutTime=?,note=? WHERE attendanceID=?";

            jdbcTemplate.update(
                    sql,
                    a.getMemberID(),
                    a.getAttendanceDate(),
                    a.getCheckInTime() == null
                    ? null
                    : Timestamp.valueOf(a.getCheckInTime()),
                    a.getCheckOutTime() == null
                    ? null
                    : Timestamp.valueOf(a.getCheckOutTime()),
                    a.getNote(),
                    a.getAttendanceID()
            );

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public void delete(int id) {

        try {

            jdbcTemplate.update(
                    "DELETE FROM Attendance WHERE attendanceID=?",
                    id);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public List<AttendanceModel> search(String keyword) {

        try {

            String sql = " SELECT * FROM Attendance WHERE CAST(memberID AS CHAR) LIKE ? OR CAST(attendanceDate AS CHAR) LIKE ? OR note LIKE ? ";

            String key = "%" + keyword + "%";

            return jdbcTemplate.query(
                    sql,
                    this::mapRow,
                    key,
                    key,
                    key
            );

        } catch (Exception e) {

            e.printStackTrace();

            return new ArrayList<>();
        }
    }
}
