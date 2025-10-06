package DAO;



import DB.DatabaseConnection;
import java.sql.*;

public class EnrollmentDAO {
    private final Connection conn;

    public EnrollmentDAO() {
        conn = DatabaseConnection.getInstance().getConnection();
    }

    public void enrollStudentInCourse(int studentId, int courseId) {
        String sql = "INSERT INTO enrollments (student_id, course_id) VALUES (?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, studentId);
            pstmt.setInt(2, courseId);
            pstmt.executeUpdate();
            System.out.println("Student enrolled successfully!");
        } catch (SQLException e) {
            System.out.println("failed to insert student into enrollments!");
        }
    }
}

