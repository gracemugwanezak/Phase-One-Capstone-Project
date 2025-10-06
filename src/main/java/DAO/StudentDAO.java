package DAO;

import DB.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    private final Connection conn;

    public StudentDAO() {
        conn = DatabaseConnection.getInstance().getConnection();
    }

    // CREATE
    public void addStudent(String name, String email, int credits) {
        String sql = "INSERT INTO students (name, email, credits) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setInt(3, credits);
            pstmt.executeUpdate();
            System.out.println(" Student added successfully!");
        } catch (SQLException e) {
            System.out.println("student failed to be added!");
        }
    }

    // READ
    public List<String> getAllStudents() {
        List<String> students = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                students.add(rs.getInt("id") + " | " + rs.getString("name") + " | " + rs.getString("email"));
            }
        } catch (SQLException e) {
            System.out.println("failed to load all students!");
        }
        return students;
    }

    // UPDATE
    public void updateStudentCredits(int id, int credits) {
        String sql = "UPDATE students SET credits = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, credits);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            System.out.println(" Student credits updated!");
        } catch (SQLException e) {
            System.out.println("failed to update student credits!");
        }
    }

    // DELETE
    public void deleteStudent(int id) {
        String sql = "DELETE FROM students WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println(" Student deleted!");
        } catch (SQLException e) {
            System.out.println("failed to delete student id!");
        }
    }
}
