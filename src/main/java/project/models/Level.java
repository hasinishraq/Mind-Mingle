package project.models;

public class Level {
    private int level_id;
    private int book;
    private int lectures;
    private int pictures;

    // Constructors
    public Level() {}

    public Level(int level_id, int book, int lectures, int pictures) {
        this.level_id = level_id;
        this.book = book;
        this.lectures = lectures;
        this.pictures = pictures;
    }

    // Getters and setters for all fields
    public int getLevelId() {
        return level_id;
    }

    public void setLevelId(int level_id) {
        this.level_id = level_id;
    }

    public int getBook() {
        return book;
    }

    public void setBook(int book) {
        this.book = book;
    }

    public int getLectures() {
        return lectures;
    }

    public void setLectures(int lectures) {
        this.lectures = lectures;
    }

    public int getPictures() {
        return pictures;
    }

    public void setPictures(int pictures) {
        this.pictures = pictures;
    }
}
