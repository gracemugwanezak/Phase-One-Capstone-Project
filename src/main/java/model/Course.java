package model;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private int id;
    private String title;
    private int credits;
    private List<Student> enrolledStudents;

    public Course(int id, String title, int credits) {
        this.id = id;
        this.title = title;
        this.credits = credits;
        this.enrolledStudents = new ArrayList<>();
    }

    // Getters and Setters
    public int getId() { return id; }
    public String getTitle() { return title; }
    public int getCredits() { return credits; }

    public void setId(int id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setCredits(int credits) { this.credits = credits; }

    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    @Override
    public String toString() {
        return "Course{id=" + id + ", title='" + title + "', credits=" + credits + ", enrolled=" + enrolledStudents.size() + "}";
    }
}
