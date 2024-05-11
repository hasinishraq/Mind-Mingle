package project.models;

public class Student {

    private String name;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String profile_picture;

    public Student() {}

    public Student(String name, String username, String password,  String email, String phone) {

        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;

    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

}
