package DAO.Implementations;

import DAO.Interfaces.StudentDAO;
import Models.Course;
import Models.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO_Impl implements StudentDAO {

    private Connection connection;

    public StudentDAO_Impl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addStudent(Student student) throws SQLException {
        String query = "INSERT INTO students (name, major) VALUES (?, ?)";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setString(1, student.getName());
            ps.setString(2,student.getMajor());
            ps.executeUpdate();
            System.out.println("Student added successfully.");
        }
    }

    @Override
    public List<Course> viewCoursesForStudent(int studentID) throws SQLException {
        List<Course> courseList = new ArrayList<>();
        String query = "SELECT c.course_name, c.credits " +
                "FROM courses c " +
                "JOIN enrollments e " +
                "ON c.course_id = e.course_id " +
                "WHERE e.student_id = ?";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1,studentID);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Course course = new Course();
                course.setCourseName(rs.getString("course_name"));
                course.setCredits(rs.getInt("credits"));
                courseList.add(course);
            }
        }
            return courseList;
    }
}
