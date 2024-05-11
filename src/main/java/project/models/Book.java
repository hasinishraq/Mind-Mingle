package project.models;

public class Book {
    private int books_id;
    private String book_path1;
    private String book_path2;
    private String book_path3;

    // Constructors
    public Book() {}

    public Book(int books_id, String book_path1, String book_path2, String book_path3) {
        this.books_id = books_id;
        this.book_path1 = book_path1;
        this.book_path2 = book_path2;
        this.book_path3 = book_path3;
    }

    // Getters and setters for all fields
    public int getBooksId() {
        return books_id;
    }

    public void setBooksId(int books_id) {
        this.books_id = books_id;
    }

    public String getBookPath1() {
        return book_path1;
    }

    public void setBookPath1(String book_path1) {
        this.book_path1 = book_path1;
    }

    public String getBookPath2() {
        return book_path2;
    }

    public void setBookPath2(String book_path2) {
        this.book_path2 = book_path2;
    }

    public String getBookPath3() {
        return book_path3;
    }

    public void setBookPath3(String book_path3) {
        this.book_path3 = book_path3;
    }
}
