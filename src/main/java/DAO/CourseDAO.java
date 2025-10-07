package DAO;

import DB.DatabaseConnection;
import model.Course;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO {
    private Connection conn;

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
            System.out.println(" Error adding course: " + e.getMessage());
        }
    }

    public List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<>();
        String sql = "SELECT * FROM courses";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                courses.add(new Course(rs.getInt("id"), rs.getString("title"), rs.getInt("credits")));
            }
        } catch (SQLException e) {
            System.out.println(" Error fetching courses: " + e.getMessage());
        }
        return courses;
    }
}
