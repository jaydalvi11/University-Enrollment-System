package Models;

public class Department {

    private int departmentID;
    private String name;
    private String location;

    public Department() {
    }

    public Department(int departmentID, String name, String location) {
        this.departmentID = departmentID;
        this.name = name;
        this.location = location;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentID=" + departmentID +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
