package project.models;

public class Group {
    private int group_id;
    private String groupname;
    private int course;
    private int member;

    // Constructors
    public Group() {}

    public Group(int group_id, String groupname, int course, int member) {
        this.group_id = group_id;
        this.groupname = groupname;
        this.course = course;
        this.member = member;
    }

    // Getters and setters for all fields
    public int getGroupId() {
        return group_id;
    }

    public void setGroupId(int group_id) {
        this.group_id = group_id;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public int getMember() {
        return member;
    }

    public void setMember(int member) {
        this.member = member;
    }
}
