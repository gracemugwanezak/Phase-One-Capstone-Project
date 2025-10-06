package model;
public class TestPolymorphism {
    public static void main(String[] args) {
        Student s1 = new UndergraduateStudent(1, "Grace", "grace@example.com", 30);
        Student s2 = new GraduateStudent(2, "Jean", "jean@example.com", 40);

        System.out.println(s1.getName() + " GPA: " + s1.calculateGPA());
        System.out.println(s2.getName() + " GPA: " + s2.calculateGPA());
    }
}
