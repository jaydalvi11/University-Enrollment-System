package DAO.Implementations;

import DAO.Interfaces.CourseDAO;
import Models.Course;
import Models.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO_Impl implements CourseDAO {

    private Connection connection;

    public CourseDAO_Impl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addCourse(Course course) throws SQLException {
        String sql = "INSERT INTO courses (course_name, credits) VALUES (?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, course.getCourseName());
            ps.setInt(2, course.getCredits());
            ps.executeUpdate();
            System.out.println("Course added successfully.");
        }
    }

    @Override
    public List<Student> viewStudentsInCourse(int courseId) throws SQLException {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT s.name FROM students s JOIN enrollments e ON s.student_id = e.student_id WHERE e.course_id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, courseId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setName(rs.getString("name"));
                students.add(student);
            }
        }
        return students;
    }

}
