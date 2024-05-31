package DAO.Interfaces;

import Models.Instructor;

import java.sql.SQLException;
import java.util.List;

public interface InstructorDAO {

    void addInstructor(Instructor instructor) throws SQLException;
    List<Instructor> getInstructorsByDepartment(String department) throws SQLException;

}
