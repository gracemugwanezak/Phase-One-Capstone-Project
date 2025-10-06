package org.example;

import model.*;
import DAO.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();
        CourseDAO courseDAO = new CourseDAO();
        EnrollmentDAO enrollmentDAO = new EnrollmentDAO();

        // Create records
        studentDAO.addStudent("Grace", "grace@example.com", 30);
        studentDAO.addStudent("John", "john@example.com", 40);

        courseDAO.addCourse("Java Programming", 3);
        courseDAO.addCourse("Database Systems", 4);

        // Display data
        System.out.println("\n Students ");
        studentDAO.getAllStudents().forEach(System.out::println);

        System.out.println("\nCourses");
        courseDAO.getAllCourses().forEach(System.out::println);

        // Enroll students
        enrollmentDAO.enrollStudentInCourse(5, 3);
        enrollmentDAO.enrollStudentInCourse(1, 2);

        // Update student credits
        studentDAO.updateStudentCredits(1, 45);

        // Delete a student
        studentDAO.deleteStudent(2);
    }
}
