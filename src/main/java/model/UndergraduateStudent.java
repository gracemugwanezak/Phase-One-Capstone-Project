package model;

public class UndergraduateStudent extends Student {
    private int credits;

    public UndergraduateStudent(int id, String name, String email, int age, int credits) {
        super(id, name, email, age);
        this.credits = credits;
    }

    @Override
    public double calculateGPA() {
        return Math.min(4.0, credits / 10.0);
    }

    @Override
    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    @Override
    public String toString() {
        return String.format("%s | Credits: %d | Type: Undergraduate",
                super.toString(), credits);
    }
}
