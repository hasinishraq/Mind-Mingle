package project.middlewares;

import project.models.Book;
import project.database.DBHandler;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookMiddleware {

    private DBHandler dbHandler = new DBHandler();

    public Book getBookById(int books_id) {
        Book book = null;
        String query = "SELECT * FROM books WHERE books_id = ?";
        try (Connection connection = dbHandler.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {

            pst.setInt(1, books_id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                book = new Book(
                        rs.getInt("books_id"),
                        rs.getString("book_path1"),
                        rs.getString("book_path2"),
                        rs.getString("book_path3")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }

    // Other CRUD operations
    // ...
}
