package project.middlewares;

import project.models.Course;
import project.database.DBHandler;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseMiddleware {

    private DBHandler dbHandler = new DBHandler();

    public Course getCourseById(int course_id) {
        Course course = null;
        String query = "SELECT * FROM courses WHERE course_id = ?";
        try (Connection connection = dbHandler.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {

            pst.setInt(1, course_id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                course = new Course(
                        rs.getInt("course_id"),
                        rs.getString("course_name"),
                        rs.getInt("level1"),
                        rs.getInt("level2"),
                        rs.getInt("level3"),
                        rs.getInt("level4"),
                        rs.getInt("level5")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return course;
    }

    public List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<>();
        String query = "SELECT * FROM courses";
        try (Connection connection = dbHandler.getConnection();
             Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            while (rs.next()) {
                Course course = new Course(
                        rs.getInt("course_id"),
                        rs.getString("course_name"),
                        rs.getInt("level1"),
                        rs.getInt("level2"),
                        rs.getInt("level3"),
                        rs.getInt("level4"),
                        rs.getInt("level5")
                );
                courses.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Other CRUD operations
        // ...
        return courses;
    }
}

