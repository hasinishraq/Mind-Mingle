package project.middlewares;

import project.models.Member;
import project.database.DBHandler;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberMiddleware {

    private DBHandler dbHandler = new DBHandler();

    public Member getMemberById(int mid) {
        Member member = null;
        String query = "SELECT * FROM members WHERE mid = ?";
        try (Connection connection = dbHandler.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {

            pst.setInt(1, mid);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                member = new Member(
                        rs.getInt("mid"),
                        rs.getInt("member1_id"),
                        rs.getInt("member2_id"),
                        rs.getInt("member3_id"),
                        rs.getInt("member4_id"),
                        rs.getInt("member5_id"),
                        rs.getInt("member6_id")

                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return member;
    }

//    public int createMember(int member1_id, int member2_id, int member3_id, int member4_id, int member5_id, int member6_id) {
//        String insertQuery = "INSERT INTO members (member1_id, member2_id, member3_id, member4_id, member5_id, member6_id) VALUES (?, ?, ?, ?, ?, ?)";
//        try (Connection connection = dbHandler.getConnection();
//             PreparedStatement pst = connection.prepareStatement(insertQuery)) {
//
//            pst.setInt(1, member1_id);
//            pst.setInt(2, member2_id);
//            pst.setInt(3, member3_id);
//            pst.setInt(4, member4_id);
//            pst.setInt(5, member5_id);
//            pst.setInt(6, member6_id);
//
//            int affectedRows = pst.executeUpdate();
//
//            return mid;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return false;
//        }
//    }

    //create member and return the mid
    public int createMember(int member1_id, int member2_id, int member3_id, int member4_id, int member5_id, int member6_id) {
        String insertQuery = "INSERT INTO members (member1_id, member2_id, member3_id, member4_id, member5_id, member6_id) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = dbHandler.getConnection();
             PreparedStatement pst = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {

            pst.setInt(1, member1_id);
            pst.setInt(2, member2_id);
            pst.setInt(3, member3_id);
            pst.setInt(4, member4_id);
            pst.setInt(5, member5_id);
            pst.setInt(6, member6_id);

            int affectedRows = pst.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating member failed, no rows affected.");
            }

            try (ResultSet generatedKeys = pst.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creating member failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }


}
