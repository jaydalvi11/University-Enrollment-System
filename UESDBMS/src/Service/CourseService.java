package Service;

import DAO.Interfaces.CourseDAO;
import Models.Course;
import Models.Student;

import java.sql.SQLException;
import java.util.List;

public class CourseService {

    private CourseDAO courseDAO;

    public CourseService(CourseDAO courseDAO) {
        this.courseDAO = courseDAO;
    }

    public void addCourse(Course course) throws SQLException{
        courseDAO.addCourse(course);
    }

    public List<Student> viewStudentsInCourse(int courseID) throws SQLException{
        return courseDAO.viewStudentsInCourse(courseID);
    }

}
