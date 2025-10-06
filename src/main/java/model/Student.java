package model;

public abstract class Student {
    private int id;
    private String name;
    private String email;
    private int credits;

    public Student(int id, String name, String email, int credits) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.credits = credits;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public int getCredits() { return credits; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setCredits(int credits) { this.credits = credits; }

    // Abstract method for polymorphism
    public abstract double calculateGPA();

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', email='" + email + "', credits=" + credits + "}";
    }
}
