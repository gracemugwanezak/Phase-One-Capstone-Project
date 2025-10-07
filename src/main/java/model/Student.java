package model;

public abstract class Student {
    private int id;
    private String name;
    private String email;
    private int age;

    public Student(int id, String name, String email, int age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public int getId() { return id; }


        @Override
        public String toString() {
            return String.format("ID: %d | Name: %s | Email: %s | Age: %d", id, name, email, age);
        }



    // Abstract method for polymorphism
    public abstract double calculateGPA();

    // Add credits as abstract to be implemented by subclasses
    public abstract int getCredits();
}
