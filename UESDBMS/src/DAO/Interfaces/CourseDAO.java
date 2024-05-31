package DAO.Interfaces;

import Models.Course;
import Models.Student;

import java.sql.SQLException;
import java.util.List;

public interface CourseDAO {

    void addCourse(Course course) throws SQLException;
    List<Student> viewStudentsInCourse(int courseID) throws SQLException;

}
