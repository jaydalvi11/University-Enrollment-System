package Models;

import java.sql.Date;

public class Enrollment {

    private int enrollmentId;
    private int studentID;
    private int courseID;
    private Date enrollmentDate;
    private double grade;

    public Enrollment(int enrollmentId, int studentID, int courseID, Date enrollmentDate, double grade) {
        this.enrollmentId = enrollmentId;
        this.studentID = studentID;
        this.courseID = courseID;
        this.enrollmentDate = enrollmentDate;
        this.grade = grade;
    }

    public Enrollment() {
    }

    public int getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(int enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public Date getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Enrollment{" +
                "enrollmentId=" + enrollmentId +
                ", studentID=" + studentID +
                ", courseID=" + courseID +
                ", enrollmentDate=" + enrollmentDate +
                ", grade=" + grade +
                '}';
    }
}
