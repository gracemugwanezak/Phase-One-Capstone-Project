package model;

import java.util.HashSet;
import java.util.Set;

public class Instructor {
    private int id;
    private String name;
    private String department;
    private Set<Course> assignedCourses;

    public Instructor(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.assignedCourses = new HashSet<>();
    }

    // Getters and Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setDepartment(String department) { this.department = department; }

    public void assignCourse(Course course) {
        assignedCourses.add(course);
    }

    public Set<Course> getAssignedCourses() {
        return assignedCourses;
    }

    @Override
    public String toString() {
        return "Instructor{id=" + id + ", name='" + name + "', department='" + department + "', courses=" + assignedCourses.size() + "}";
    }
}
