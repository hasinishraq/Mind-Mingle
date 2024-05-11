package project.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import project.enums.LoginResult;
import project.middlewares.StudentMiddleware;
import project.services.student_services.LoginService;
import project.viewer.ViewManager;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginController extends BaseController implements Initializable {

    private LoginService studentAuthenticationServices = new LoginService();

    public LoginController(ViewManager viewManager, String fxmlName) {
        super(viewManager, "/views/ui/"+fxmlName);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private TextField name;

    @FXML
    private PasswordField password;

    @FXML
    private Label errorLabel;

    @FXML
    void onAdminLoginSwitch(ActionEvent event) {
        super.getViewManager().showAdminLogin();
        super.getViewManager().closeWindow((Stage) name.getScene().getWindow());

    }

    @FXML
    void onSubmit(ActionEvent event) throws SQLException {


        studentAuthenticationServices = new LoginService(name.getText(), password.getText());
        studentAuthenticationServices.start();
        studentAuthenticationServices.setOnSucceeded(e -> {
            LoginResult loginResult = studentAuthenticationServices.getValue();

            if (loginResult != null) {
                switch (loginResult) {
                    case SUCCESS -> {
                        System.out.println("Login Success");
                        // Open the whiteboard
                        //super.getViewFactory().showTest();
                        super.getViewManager().showDashboard(StudentMiddleware.getDataByNameAndPassword(name.getText(), password.getText()));
                        errorLabel.setText("");
                        Stage stage = (Stage) errorLabel.getScene().getWindow();
                        super.getViewManager().closeWindow(stage);
                    }
                    case FAILED_BY_UNEXPECTED_ERROR -> {
                        errorLabel.setText("Unexpected error");
                    }
                    case FAILED_BY_NETWORK -> {
                        errorLabel.setText("Failed to get to network");
                    }
                    case FAILED_BY_CREDENTIALS -> {
                        errorLabel.setText("Invalid Credentials");
                    }
                }
            } else {
                errorLabel.setText("An error occurred during login. Please try again.");


            }
        });
    }

//    @FXML
//    void onSubmit(ActionEvent event) throws SQLException {
//
//        studentAuthenticationServices = new LoginService(name.getText(), password.getText());
//        studentAuthenticationServices.start();
//        studentAuthenticationServices.setOnSucceeded(e -> {
//            LoginResult loginResult = studentAuthenticationServices.getValue();
//
//            switch (loginResult) {
//                case SUCCESS -> {
//                    System.out.println("Login Success");
//                    //super.getViewFactory().showStudentDashboard(StudentMiddleware.getDataByNameAndPassword(name.getText(), password.getText()));
//                    //open the whiteboard
//                    super.getViewFactory().showCanvas();
//
//
//                    errorLabel.setText("");
//                    Stage stage = (Stage) errorLabel.getScene().getWindow();
//                    super.getViewFactory().closeWindow(stage);
//                }
//                case FAILED_BY_UNEXPECTED_ERROR -> {
//                    errorLabel.setText("Unexpected error");
//                }
//                case FAILED_BY_NETWORK -> {
//                    errorLabel.setText("Failed to get to network");
//                }
//                case FAILED_BY_CREDENTIALS -> {
//                    errorLabel.setText("Invalid Credentials");
//                }
//            }
//        });
//
//    }


    @FXML
    void onSignupActionSwitch(ActionEvent event) {
        super.getViewManager().showSignupWindow();
        super.getViewManager().closeWindow((Stage) name.getScene().getWindow());
    }


}
