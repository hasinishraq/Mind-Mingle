package project.models;

public class Lecture {
    private int lecture_id;
    private String lecture_path1;
    private String lecture_path2;
    private String lecture_path3;

    // Constructors
    public Lecture() {}

    public Lecture(int lecture_id, String lecture_path1, String lecture_path2, String lecture_path3) {
        this.lecture_id = lecture_id;
        this.lecture_path1 = lecture_path1;
        this.lecture_path2 = lecture_path2;
        this.lecture_path3 = lecture_path3;
    }

    // Getters and setters for all fields
    public int getLectureId() {
        return lecture_id;
    }

    public void setLectureId(int lecture_id) {
        this.lecture_id = lecture_id;
    }

    public String getLecturePath1() {
        return lecture_path1;
    }

    public void setLecturePath1(String lecture_path1) {
        this.lecture_path1 = lecture_path1;
    }

    public String getLecturePath2() {
        return lecture_path2;
    }

    public void setLecturePath2(String lecture_path2) {
        this.lecture_path2 = lecture_path2;
    }

    public String getLecturePath3() {
        return lecture_path3;
    }

    public void setLecturePath3(String lecture_path3) {
        this.lecture_path3 = lecture_path3;
    }
}
