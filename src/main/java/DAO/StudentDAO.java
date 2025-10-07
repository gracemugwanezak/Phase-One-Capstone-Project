package DAO;

import DB.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.GraduateStudent;
import model.Student;
import model.UndergraduateStudent;

public class StudentDAO {
    private Connection conn;

    public StudentDAO() {
        conn = DatabaseConnection.getInstance().getConnection();
    }

    public void addStudent(Student student) {
        String sql = "INSERT INTO students (name, email, age, credits, type) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getEmail());
            pstmt.setInt(3, student.getAge());
            pstmt.setInt(4, student.getCredits());

            if (student instanceof UndergraduateStudent) {
                pstmt.setString(5, "undergraduate");
            } else if (student instanceof GraduateStudent) {
                pstmt.setString(5, "graduate");
            }

            pstmt.executeUpdate();
            System.out.println("Student added successfully!");
        } catch (SQLException e) {
            System.out.println("Error adding student: " + e.getMessage());
        }
    }



    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) { // <-- loop through all rows
                String type = rs.getString("type");

                if ("undergraduate".equalsIgnoreCase(type)) {
                    students.add(new UndergraduateStudent(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("email"),
                            rs.getInt("age") ,
                            rs.getInt("credits")
                    ));
                } else if ("graduate".equalsIgnoreCase(type)) {
                    students.add(new GraduateStudent(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("email"),
                            rs.getInt("age"),
                            rs.getInt("credits")
                    ));

                }
            }

        } catch (SQLException e) {
            System.out.println("Error fetching students: " + e.getMessage());
        }

        return students;
    }


    public void updateStudentEmail(int id, String email) {
        String sql = "UPDATE students SET email = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, email);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            System.out.println(" Student updated!");
        } catch (SQLException e) {
            System.out.println(" Error updating student: " + e.getMessage());
        }
    }

    public void deleteStudent(int id) {
        String sql = "DELETE FROM students WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println(" Student deleted!");
        } catch (SQLException e) {
            System.out.println(" Error deleting student: " + e.getMessage());
        }
    }
}
