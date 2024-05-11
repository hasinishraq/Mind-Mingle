package project.middlewares;

import project.models.Level;
import project.database.DBHandler;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LevelMiddleware {

    private DBHandler dbHandler = new DBHandler();

    public Level getLevelById(int level_id) {
        Level level = null;
        String query = "SELECT * FROM levels WHERE level_id = ?";
        try (Connection connection = dbHandler.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {

            pst.setInt(1, level_id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                level = new Level(
                        rs.getInt("level_id"),
                        rs.getInt("Book"),
                        rs.getInt("Lectures"),
                        rs.getInt("Pictures")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return level;
    }

    // Other CRUD operations
    // ...
}
