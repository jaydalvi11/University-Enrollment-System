package DAO.Implementations;

import DAO.Interfaces.InstructorDAO;
import Models.Instructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InstructorDAO_Impl implements InstructorDAO {

    private Connection connection;

    public InstructorDAO_Impl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addInstructor(Instructor instructor) throws SQLException {
        String sql = "INSERT INTO instructors (name, department) VALUES (?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, instructor.getName());
            ps.setString(2, instructor.getDepartment());
            ps.executeUpdate();
            System.out.println("Instructor added successfully.");
        }
    }

    @Override
    public List<Instructor> getInstructorsByDepartment(String department) throws SQLException {
        List<Instructor> instructors = new ArrayList<>();
        String sql = "SELECT * FROM instructors WHERE department = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, department);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Instructor instructor = new Instructor();
                instructor.setInstructorID(rs.getInt("instructor_id"));
                instructor.setName(rs.getString("name"));
                instructor.setDepartment(rs.getString("department"));
                instructors.add(instructor);
            }
        }
        return instructors;
    }

}
