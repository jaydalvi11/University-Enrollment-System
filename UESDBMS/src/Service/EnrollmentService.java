package Service;

import DAO.Interfaces.EnrollmentDAO;
import Models.Enrollment;

import java.sql.SQLException;

public class EnrollmentService {

    private EnrollmentDAO enrollmentDAO;

    public EnrollmentService(EnrollmentDAO enrollmentDAO) {
        this.enrollmentDAO = enrollmentDAO;
    }

    public void enrollStudent(Enrollment enrollment) throws SQLException{
        if (enrollment.getGrade() < 6) {
            throw new IllegalArgumentException("Grade must be 6 or higher to enroll.");
        }
        enrollmentDAO.enrollStudent(enrollment);
    }

    public void enrollStudentWithGrade(Enrollment enrollment, double grade) throws SQLException {
        if (grade < 6) {
            throw new IllegalArgumentException("Grade must be 6 or higher to enroll.");
        }
        enrollment.setGrade(grade);
        enrollmentDAO.enrollStudentWithGrade(enrollment, grade);
    }

    public double calculateAverageGrade(int courseId) throws SQLException {
        return enrollmentDAO.calculateAverageGrade(courseId);
    }

    public int calculateTotalCredits(int studentId) throws SQLException {
        return enrollmentDAO.calculateTotalCredits(studentId);
    }

}
