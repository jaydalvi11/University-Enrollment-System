package Models;

public class Student {

    private int studentID;
    private String name;
    private String major;

    public Student() {
    }

    public Student(int studentID, String name, String major) {
        this.studentID = studentID;
        this.name = name;
        this.major = major;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentID=" + studentID +
                ", name='" + name + '\'' +
                ", major='" + major + '\'' +
                '}';
    }
}
