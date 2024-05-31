package Service;

import DAO.Interfaces.DepartmentDAO;
import Models.Department;

import java.sql.SQLException;
import java.util.List;

public class DepartmentService {

    private DepartmentDAO departmentDAO;

    public DepartmentService(DepartmentDAO departmentDAO) {
        this.departmentDAO = departmentDAO;
    }

    public void addDepartment(Department department) throws SQLException{
        departmentDAO.addDepartment(department);
    }

    public List<Department> getAllDepartments() throws SQLException{
        return departmentDAO.getAllDepartments();
    }

}
