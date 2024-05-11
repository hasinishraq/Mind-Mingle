package project.middlewares;

import project.models.Group;
import project.database.DBHandler;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GroupMiddleware {

    private DBHandler dbHandler = new DBHandler();

    public Group getGroupById(int group_id) {
        Group group = null;
        String query = "SELECT * FROM `groups` WHERE group_id = ?";
        try (Connection connection = dbHandler.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {

            pst.setInt(1, group_id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                group = new Group(
                        rs.getInt("group_id"),
                        rs.getString("groupname"),
                        rs.getInt("course"),
                        rs.getInt("member")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return group;
    }


    public boolean createGroup(String groupname, int course, int member) {

        String insertQuery = "INSERT INTO `groups` (groupname, course, member) VALUES (?, ?, ?)";
        try (Connection connection = dbHandler.getConnection();
             PreparedStatement pst = connection.prepareStatement(insertQuery)) {

            pst.setString(1, groupname);
            pst.setInt(2, course);
            pst.setInt(3, member);

            int affectedRows = pst.executeUpdate();

            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

//    public boolean createGroup(String groupName, int courseId, int member1, int member2, int member3, int member4, int member5) {
//        String insertQuery = "INSERT INTO `groups` (groupname, course, member) VALUES (?, ?, ?)";
//        try (Connection connection = dbHandler.getConnection();
//             PreparedStatement pst = connection.prepareStatement(insertQuery)) {
//
//            pst.setString(1, groupName);
//            pst.setInt(2, courseId);
//            pst.setInt(3, member1);
//            pst.setInt(4, member2);
//            pst.setInt(5, member3);
//            pst.setInt(6, member4);
//            pst.setInt(7, member5);
//
//            int affectedRows = pst.executeUpdate();
//
//            return affectedRows > 0;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }

//    public void createGroup(String groupname, int course, int member) {
//        String insertQuery = "INSERT INTO `groups` (groupname, course, member) VALUES (?, ?, ?)";
//        try (Connection connection = dbHandler.getConnection();
//             PreparedStatement pst = connection.prepareStatement(insertQuery)) {
//
//            pst.setString(1, groupname);
//            pst.setInt(2, course);
//            pst.setInt(3, member);
//
//            pst.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }



    // Other CRUD operations
    // ...
}
