package model;

import model.*;
import java.util.*;

public class UniversitySystem {
    public static void main(String[] args) {
        // Create students
        Student u1 = new UndergraduateStudent(1, "Grace", "grace@example.com", 30);
        Student g1 = new GraduateStudent(2, "Eric", "eric@example.com", 40);

        // Create courses
        Course java = new Course(101, "Java Programming", 3);
        Course db = new Course(102, "Database Systems", 4);

        // Enroll students
        java.enrollStudent(u1);
        java.enrollStudent(g1);
        db.enrollStudent(g1);

        // Create instructor
        Instructor instructor = new Instructor(201, "Dr. Alice", "Computer Science");
        instructor.assignCourse(java);
        instructor.assignCourse(db);

        // Use Map to link course → instructor
        Map<Course, Instructor> courseInstructorMap = new HashMap<>();
        courseInstructorMap.put(java, instructor);
        courseInstructorMap.put(db, instructor);

        // Display info
        System.out.println("University System Data git add src/main/java/model/Course.java");
        System.out.println(instructor);
        for (Course c : instructor.getAssignedCourses()) {
            System.out.println("→ " + c);
            for (Student s : c.getEnrolledStudents()) {
                System.out.println("   " + s + " | GPA: " + s.calculateGPA());
            }
        }
    }
}
