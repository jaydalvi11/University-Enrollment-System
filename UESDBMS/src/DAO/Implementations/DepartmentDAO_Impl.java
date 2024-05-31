package DAO.Implementations;

import DAO.Interfaces.DepartmentDAO;
import Models.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO_Impl implements DepartmentDAO {

    private Connection connection;

    public DepartmentDAO_Impl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addDepartment(Department department) throws SQLException {
        String sql = "INSERT INTO departments (name, location) VALUES (?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, department.getName());
            ps.setString(2, department.getLocation());
            ps.executeUpdate();
            System.out.println("Department added successfully.");
        }
    }

    @Override
    public List<Department> getAllDepartments() throws SQLException {
        List<Department> departments = new ArrayList<>();
        String sql = "SELECT * FROM departments";
        try (Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Department department = new Department();
                department.setDepartmentID(rs.getInt("department_id"));
                department.setName(rs.getString("name"));
                department.setLocation(rs.getString("location"));
                departments.add(department);
            }
        }
        return departments;
    }

}
