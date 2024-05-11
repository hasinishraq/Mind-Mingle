package project.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import project.enums.SignUpResult;
import project.services.student_services.SignupService;
import project.viewer.ViewManager;

import java.net.URL;
import java.util.ResourceBundle;

public class SignupController extends BaseController implements Initializable {

    public SignupController(ViewManager viewManager, String fxmlName) {
        super(viewManager, "/views/ui/"+fxmlName);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    @FXML
    private TextField fullnameField;

    @FXML
    private TextField usernameField;


    @FXML
    private TextField phoneField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private Label errorLabel;

    @FXML
    void onLoginActionSwitch(ActionEvent event) {
        super.getViewManager().showLoginView();
        super.getViewManager().closeWindow((Stage) confirmPasswordField.getScene().getWindow());
    }

    @FXML
    void onSignupAction(ActionEvent event) {
        SignupService studentSignupService = new SignupService(

                fullnameField.getText(),
                usernameField.getText(),
                passwordField.getText(),
                confirmPasswordField.getText(),
                phoneField.getText(),
                emailField.getText()
        );
        studentSignupService.start();
        studentSignupService.setOnSucceeded(e -> {
            SignUpResult signUpResult = studentSignupService.getValue();
            switch (signUpResult) {
                case SUCCESS -> {
                    errorLabel.setText("Account created successfully!");

                    //super.getViewFactory().showLoginView();
                    //super.getViewFactory().closeWindow((Stage) confirmPasswordField.getScene().getWindow());
                   // super.getViewFactory().showStudentDashboard(StudentMiddleware.getDataByNameAndPassword(usernameField.getText(), passwordField.getText()));
                   // super.getViewFactory().closeWindow((Stage) uiuIDField.getScene().getWindow());
                }
                case PASSWORDS_NO_MATCH -> {
                    errorLabel.setText("Passwords do not match!");
                }
                case ALREADY_IN_DB -> {
                    errorLabel.setText("Email already in use");
                } case FAILED_BY_UNEXPECTED_ERROR -> {
                    errorLabel.setText("Unexpected error");
                }
            }
        });

    }

}
