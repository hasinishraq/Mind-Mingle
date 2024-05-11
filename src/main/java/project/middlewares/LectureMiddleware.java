package project.middlewares;

import project.models.Lecture;
import project.database.DBHandler;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LectureMiddleware {

    private DBHandler dbHandler = new DBHandler();

    public Lecture getLectureById(int lecture_id) {
        Lecture lecture = null;
        String query = "SELECT * FROM lectures WHERE lecture_id = ?";
        try (Connection connection = dbHandler.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {

            pst.setInt(1, lecture_id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                lecture = new Lecture(
                        rs.getInt("lecture_id"),
                        rs.getString("lecture_path1"),
                        rs.getString("lecture_path2"),
                        rs.getString("lecture_path3")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lecture;
    }

    // Other CRUD operations
    // ...
}
