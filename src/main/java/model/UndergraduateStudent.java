package model;

public class UndergraduateStudent extends Student {

    public UndergraduateStudent(int id, String name, String email, int credits) {
        super(id, name, email, credits);
    }

    @Override
    public double calculateGPA() {
        return getCredits() * 0.1; // Example formula
    }

    @Override
    public String toString() {
        return "Undergraduate " + super.toString();
    }
}
