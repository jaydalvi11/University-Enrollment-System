package DAO.Implementations;

import DAO.Interfaces.EnrollmentDAO;
import Models.Enrollment;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EnrollmentDAO_Impl implements EnrollmentDAO {

    private Connection connection;

    public EnrollmentDAO_Impl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void enrollStudent(Enrollment enrollment) throws SQLException {
        String sql = "INSERT INTO enrollments (student_id, course_id, enrollment_date) VALUES (?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, enrollment.getStudentID());
            ps.setInt(2, enrollment.getCourseID());
            ps.setDate(3, enrollment.getEnrollmentDate());
            ps.executeUpdate();
            System.out.println("Student enrolled successfully.");
        }
    }

    public void enrollStudentWithGrade(Enrollment enrollment, double grade) throws SQLException {
        String sql = "INSERT INTO enrollments (student_id, course_id, enrollment_date, grade) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, enrollment.getStudentID());
            ps.setInt(2, enrollment.getCourseID());
            ps.setDate(3, new java.sql.Date(System.currentTimeMillis()));
            ps.setBigDecimal(4, BigDecimal.valueOf(grade));
            ps.executeUpdate();
            System.out.println("Student enrolled with grade successfully.");
        }
    }

    public double calculateAverageGrade(int courseId) throws SQLException {
        String sql = "SELECT AVG(grade) AS average_grade FROM enrollments WHERE course_id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, courseId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getDouble("average_grade");
            }
        }
        return 0.0;
    }

    public int calculateTotalCredits(int studentId) throws SQLException {
        String sql = "SELECT SUM(c.credits) AS total_credits FROM courses c JOIN enrollments e ON c.course_id = e.course_id WHERE e.student_id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, studentId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("total_credits");
            }
        }
        return 0;
    }

}
