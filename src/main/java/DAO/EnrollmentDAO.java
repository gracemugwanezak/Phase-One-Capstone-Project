package DAO;

import DB.DatabaseConnection;
import java.sql.*;

public class EnrollmentDAO {
    private Connection conn;

    public EnrollmentDAO() {
        conn = DatabaseConnection.getInstance().getConnection();
    }

    public void enrollStudent(int studentId, int courseId) {
        String sql = "INSERT INTO enrollments (student_id, course_id) VALUES (?, ?) ON CONFLICT DO NOTHING";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, studentId);
            pstmt.setInt(2, courseId);
            pstmt.executeUpdate();
            System.out.println(" Student enrolled successfully!");
        } catch (SQLException e) {
            System.out.println(" Error enrolling student: " + e.getMessage());
        }
    }

    public void viewEnrollments() {
        String sql = """
            SELECT s.name AS student, c.title AS course
            FROM enrollments e
            JOIN students s ON e.student_id = s.id
            JOIN courses c ON e.course_id = c.id
            """;
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("\n Enrollments:");
            while (rs.next()) {
                System.out.println(" - " + rs.getString("student") + " → " + rs.getString("course"));
            }
        } catch (SQLException e) {
            System.out.println(" Error fetching enrollments: " + e.getMessage());
        }
    }
}
