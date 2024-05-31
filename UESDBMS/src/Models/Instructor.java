package Models;

public class Instructor {

    private int instructorID;
    private String name;
    private String department;

    public Instructor() {
    }

    public Instructor(int instructorID, String name, String department) {
        this.instructorID = instructorID;
        this.name = name;
        this.department = department;
    }

    public int getInstructorID() {
        return instructorID;
    }

    public void setInstructorID(int instructorID) {
        this.instructorID = instructorID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "instructorID=" + instructorID +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
