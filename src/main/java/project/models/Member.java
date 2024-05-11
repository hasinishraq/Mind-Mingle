package project.models;

public class Member {
    private int mid;
    private int member1_id;
    private int member2_id;
    private int member3_id;
    private int member4_id;
    private int member5_id;
    private int member6_id;

    // Constructors
    public Member() {}

    public Member(int mid, int member1_id, int member2_id, int member3_id, int member4_id, int member5_id, int member6_id) {
        this.mid = mid;
        this.member1_id = member1_id;
        this.member2_id = member2_id;
        this.member3_id = member3_id;
        this.member4_id = member4_id;
        this.member5_id = member5_id;
        this.member6_id = member6_id;
    }




    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public int getMember1_id() {
        return member1_id;
    }

    public void setMember1_id(int member1_id) {
        this.member1_id = member1_id;
    }

    public int getMember2_id() {
        return member2_id;
    }

    public void setMember2_id(int member2_id) {
        this.member2_id = member2_id;
    }

    public int getMember3_id() {
        return member3_id;
    }

    public void setMember3_id(int member3_id) {
        this.member3_id = member3_id;
    }

    public int getMember4_id() {
        return member4_id;
    }

    public void setMember4_id(int member4_id) {
        this.member4_id = member4_id;
    }

    public int getMember5_id() {
        return member5_id;
    }

    public void setMember5_id(int member5_id) {
        this.member5_id = member5_id;
    }

    public int getMember6_id() {
        return member6_id;
    }

    public void setMember6_id(int member6_id) {
        this.member6_id = member6_id;
    }
}
