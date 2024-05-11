package project.models;

public class Picture {
    private int picture_id;
    private String picture_path1;
    private String picture_path2;
    private String picture_path3;

    // Constructors
    public Picture() {}

    public Picture(int picture_id, String picture_path1, String picture_path2, String picture_path3) {
        this.picture_id = picture_id;
        this.picture_path1 = picture_path1;
        this.picture_path2 = picture_path2;
        this.picture_path3 = picture_path3;
    }

    // Getters and setters for all fields
    public int getPictureId() {
        return picture_id;
    }

    public void setPictureId(int picture_id) {
        this.picture_id = picture_id;
    }

    public String getPicturePath1() {
        return picture_path1;
    }

    public void setPicturePath1(String picture_path1) {
        this.picture_path1 = picture_path1;
    }

    public String getPicturePath2() {
        return picture_path2;
    }

    public void setPicturePath2(String picture_path2) {
        this.picture_path2 = picture_path2;
    }

    public String getPicturePath3() {
        return picture_path3;
    }

    public void setPicturePath3(String picture_path3) {
        this.picture_path3 = picture_path3;
    }
}
