package DAO.Interfaces;

import Models.Enrollment;

import java.sql.SQLException;

public interface EnrollmentDAO {

    void enrollStudent(Enrollment enrollment) throws SQLException;
    void enrollStudentWithGrade(Enrollment enrollment, double grade) throws SQLException;
    double calculateAverageGrade(int courseID) throws SQLException;
    int calculateTotalCredits(int studentID) throws SQLException;

}
