package Service;

import DAO.Interfaces.StudentDAO;
import Models.Course;
import Models.Student;

import java.sql.SQLException;
import java.util.List;

public class StudentService {

    private StudentDAO studentDAO;

    public StudentService(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public void addStudent(Student student) throws SQLException{
        studentDAO.addStudent(student);
    }

    public List<Course> viewCoursesForStudent(int studentID) throws SQLException{
        return studentDAO.viewCoursesForStudent(studentID);
    }

    public void updateStudent(Student student) {
        studentDAO.updateStudent(student);
    }

}
