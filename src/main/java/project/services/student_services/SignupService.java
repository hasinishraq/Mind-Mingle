package project.services.student_services;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import project.enums.SignUpResult;
import project.middlewares.StudentMiddleware;

public class SignupService extends Service<SignUpResult> {


    private String name;
    private String username;
    private String password;
    private String confirmPassword;
    private String email;
    private String phone;

    public SignupService() {}

    public SignupService(String name, String username, String password, String confirmPassword, String email, String phone) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.email = email;
        this.phone = phone;
    }


    @Override
    protected Task<SignUpResult> createTask() {
        return new Task<SignUpResult>() {
            @Override
            protected SignUpResult call() throws Exception {
                return signup();
            }
        };
    }

    private SignUpResult signup() {
        return StudentMiddleware.signup(this.name, this.username, this.password, this.confirmPassword,this.email, this.phone);
    }
}
