package project.middlewares;

import project.models.Picture;
import project.database.DBHandler;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PictureMiddleware {

    private DBHandler dbHandler = new DBHandler();

    public Picture getPictureById(int picture_id) {
        Picture picture = null;
        String query = "SELECT * FROM pictures WHERE picture_id = ?";
        try (Connection connection = dbHandler.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {

            pst.setInt(1, picture_id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                picture = new Picture(
                        rs.getInt("picture_id"),
                        rs.getString("picture_path1"),
                        rs.getString("picture_path2"),
                        rs.getString("picture_path3")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return picture;
    }

    // Other CRUD operations
    // ...
}
