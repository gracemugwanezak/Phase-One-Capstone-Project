package model;

public class GraduateStudent extends Student {

    public GraduateStudent(int id, String name, String email, int credits) {
        super(id, name, email, credits);
    }

    @Override
    public double calculateGPA() {
        return getCredits() * 0.15; // Different GPA calculation
    }

    @Override
    public String toString() {
        return "Graduate " + super.toString();
    }
}
