package DAO.Interfaces;

import Models.Department;

import java.sql.SQLException;
import java.util.List;

public interface DepartmentDAO {

    void addDepartment(Department department) throws SQLException;
    List<Department> getAllDepartments() throws SQLException;

}
