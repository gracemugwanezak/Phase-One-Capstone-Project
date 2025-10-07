package org.example;

import DAO.*;
import model.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentDAO studentDAO = new StudentDAO();
        CourseDAO courseDAO = new CourseDAO();
        EnrollmentDAO enrollmentDAO = new EnrollmentDAO();

        while (true) {
            System.out.println("\n University Management System ");
            System.out.println("1. Add Student");
            System.out.println("2. List Students");
            System.out.println("3. Add Course");
            System.out.println("4. List Courses");
            System.out.println("5. Enroll Student");
            System.out.println("6. View Enrollments");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            try {
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter email: ");
                        String email = sc.nextLine();

                        System.out.print("Enter age: ");
                        int age = Integer.parseInt(sc.nextLine());

                        System.out.print("Enter type (undergraduate/graduate): ");
                        String type = sc.nextLine().trim().toLowerCase();

                        System.out.print("Enter credits: ");
                        int credits = Integer.parseInt(sc.nextLine());

                        Student student;
                        if (type.equals("undergraduate")) {
                            student = new UndergraduateStudent(0, name, email, age, credits);
                        } else if (type.equals("graduate")) {
                            student = new GraduateStudent(0, name, email, age, credits);
                        } else {
                            System.out.println(" Invalid type, defaulting to undergraduate.");
                            student = new UndergraduateStudent(0, name, email, age, credits);
                        }

                        studentDAO.addStudent(student);
                    }

                    case 2 -> studentDAO.getAllStudents().forEach(System.out::println);

                    case 3 -> {
                        System.out.print("Enter course title: ");
                        String title = sc.nextLine();

                        System.out.print("Enter credits: ");
                        int courseCredits = Integer.parseInt(sc.nextLine());

                        courseDAO.addCourse(title, courseCredits);
                    }

                    case 4 -> courseDAO.getAllCourses().forEach(System.out::println);

                    case 5 -> {
                        System.out.print("Enter student ID: ");
                        int sId = Integer.parseInt(sc.nextLine());

                        System.out.print("Enter course ID: ");
                        int cId = Integer.parseInt(sc.nextLine());

                        enrollmentDAO.enrollStudent(sId, cId);
                    }

                    case 6 -> enrollmentDAO.viewEnrollments();

                    case 7 -> {
                        System.out.println("Goodbye!");
                        sc.close();
                        return;
                    }

                    default -> System.out.println(" Invalid option, try again.");
                }
            } catch (Exception e) {
                System.out.println(" Invalid input: " + e.getMessage());
            }
        }
    }
}
