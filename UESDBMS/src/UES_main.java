import DAO.Implementations.*;
import DAO.Interfaces.*;
import Models.*;
import Service.*;
import Utility.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class UES_main {

    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            Scanner scanner = new Scanner(System.in);
            StudentDAO studentDAO = new StudentDAO_Impl(connection);
            CourseDAO courseDAO = new CourseDAO_Impl(connection);
            EnrollmentDAO enrollmentDAO = new EnrollmentDAO_Impl(connection);
            InstructorDAO instructorDAO = new InstructorDAO_Impl(connection);
            DepartmentDAO departmentDAO = new DepartmentDAO_Impl(connection);

            StudentService studentService = new StudentService(studentDAO);
            CourseService courseService = new CourseService(courseDAO);
            EnrollmentService enrollmentService = new EnrollmentService(enrollmentDAO);
            InstructorService instructorService = new InstructorService(instructorDAO);
            DepartmentService departmentService = new DepartmentService(departmentDAO);

            while (true) {
                System.out.println("University Enrollment System");
                System.out.println("1. Add Student");
                System.out.println("2. Add Course");
                System.out.println("3. Enroll Student in Course");
                System.out.println("4. View Courses for Student");
                System.out.println("5. View Students in Course");
                System.out.println("6. Add Instructor");
                System.out.println("7. View Instructors by Department");
                System.out.println("8. Add Department");
                System.out.println("9. View All Departments");
                System.out.println("10. Calculate Average Grade for a Course");
                System.out.println("11. Calculate Total Credits for a Student");
                System.out.println("12. Delete Instructor");
                System.out.println("13. Update Student");
                System.out.println("14. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                try {
                    switch (choice) {
                        case 1:
                            System.out.print("Enter student name: ");
                            String studentName = scanner.nextLine();
                            System.out.print("Enter student major: ");
                            String studentMajor = scanner.nextLine();
                            Student student = new Student(0, studentName, studentMajor);
                            studentService.addStudent(student);
                            break;
                        case 2:
                            System.out.print("Enter course name: ");
                            String courseName = scanner.nextLine();
                            System.out.print("Enter course credits: ");
                            int courseCredits = scanner.nextInt();
                            Course course = new Course(0, courseName, courseCredits);
                            courseService.addCourse(course);
                            break;
                        case 3:
                            System.out.print("Enter student ID: ");
                            int studentId = scanner.nextInt();
                            System.out.print("Enter course ID: ");
                            int courseId = scanner.nextInt();
                            System.out.print("Enter grade: ");
                            double grade = scanner.nextDouble();
                            Enrollment enrollment = new Enrollment(0, studentId, courseId, new java.sql.Date(System.currentTimeMillis()), grade);
                            enrollmentService.enrollStudentWithGrade(enrollment, grade);
                            break;
                        case 4:
                            System.out.print("Enter student ID: ");
                            int sid = scanner.nextInt();
                            List<Course> courses = studentService.viewCoursesForStudent(sid);
                            for (Course c : courses) {
                                System.out.println("Course Name: " + c.getCourseName() + ", Credits: " + c.getCredits());
                            }
                            break;
                        case 5:
                            System.out.print("Enter course ID: ");
                            int cid = scanner.nextInt();
                            List<Student> students = courseService.viewStudentsInCourse(cid);
                            for (Student s : students) {
                                System.out.println("Student Name: " + s.getName());
                            }
                            break;
                        case 6:
                            System.out.print("Enter instructor name: ");
                            String instructorName = scanner.nextLine();
                            System.out.print("Enter department: ");
                            String instructorDept = scanner.nextLine();
                            Instructor instructor = new Instructor(0, instructorName, instructorDept);
                            instructorService.addInstructor(instructor);
                            break;
                        case 7:
                            System.out.print("Enter department: ");
                            String dept = scanner.nextLine();
                            List<Instructor> instructors = instructorService.getInstructorsByDepartment(dept);
                            for (Instructor i : instructors) {
                                System.out.println("Instructor Name: " + i.getName());
                            }
                            break;
                        case 8:
                            System.out.print("Enter department name: ");
                            String departmentName = scanner.nextLine();
                            System.out.print("Enter location: ");
                            String departmentLocation = scanner.nextLine();
                            Department department = new Department(0, departmentName, departmentLocation);
                            departmentService.addDepartment(department);
                            break;
                        case 9:
                            List<Department> departments = departmentService.getAllDepartments();
                            for (Department d : departments) {
                                System.out.println("Department Name: " + d.getName() + ", Location: " + d.getLocation());
                            }
                            break;
                        case 10:
                            System.out.print("Enter course ID: ");
                            int courseIdForGrade = scanner.nextInt();
                            double avgGrade = enrollmentService.calculateAverageGrade(courseIdForGrade);
                            System.out.println("Average Grade for Course ID " + courseIdForGrade + ": " + avgGrade);
                            break;
                        case 11:
                            System.out.print("Enter student ID: ");
                            int studentIdForCredits = scanner.nextInt();
                            int totalCredits = enrollmentService.calculateTotalCredits(studentIdForCredits);
                            System.out.println("Total Credits for Student ID " + studentIdForCredits + ": " + totalCredits);
                            break;
                        case 12:
                            System.out.print("Enter instructor ID: ");
                            int instructorID = scanner.nextInt();
                            instructorService.deleteInstructor(instructorID);
                            System.out.println("Instructor deleted successfully");
                            break;
                        case 13:
                            System.out.print("Enter student ID: ");
                            int studentID = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Enter new student name: ");
                            String newName = scanner.nextLine();
                            System.out.print("Enter new student major: ");
                            String newMajor = scanner.nextLine();
                            Student studentToUpdate = new Student(studentID, newName, newMajor);
                            studentService.updateStudent(studentToUpdate);
                            System.out.println("Student updated successfully");
                            break;
                        case 14:
                            System.out.println("Exiting...");
                            return;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}