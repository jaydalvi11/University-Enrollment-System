package DAO.Interfaces;

import Models.Course;
import Models.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentDAO {

    void addStudent(Student student) throws SQLException;
    List<Course> viewCoursesForStudent(int studentID) throws SQLException;

}
