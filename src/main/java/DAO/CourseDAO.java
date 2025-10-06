package DAO;



import DB.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO {
    private final Connection conn;

    public CourseDAO() {
        conn = DatabaseConnection.getInstance().getConnection();
    }

    public void addCourse(String title, int credits) {
        String sql = "INSERT INTO courses (title, credits) VALUES (?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, title);
            pstmt.setInt(2, credits);
            pstmt.executeUpdate();
            System.out.println(" Course added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String> getAllCourses() {
        List<String> courses = new ArrayList<>();
        String sql = "SELECT * FROM courses";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                courses.add(rs.getInt("id") + " | " + rs.getString("title") + " | " + rs.getInt("credits") + " credits");
            }
        } catch (SQLException e) {
            System.out.println("Failed to add course");
        }
        return courses;
    }
}

