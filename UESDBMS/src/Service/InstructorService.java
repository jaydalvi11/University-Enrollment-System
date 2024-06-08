package Service;

import DAO.Interfaces.InstructorDAO;
import Models.Instructor;

import java.sql.SQLException;
import java.util.List;

public class InstructorService {

    private InstructorDAO instructorDAO;

    public InstructorService(InstructorDAO instructorDAO) {
        this.instructorDAO = instructorDAO;
    }

    public void addInstructor(Instructor instructor) throws SQLException{
        instructorDAO.addInstructor(instructor);
    }

    public List<Instructor> getInstructorsByDepartment(String department) throws SQLException{
        return instructorDAO.getInstructorsByDepartment(department);
    }

    public void deleteInstructor(int instructorID) {
        instructorDAO.deleteInstructor(instructorID);
    }

}
