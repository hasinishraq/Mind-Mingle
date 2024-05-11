package project.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import project.enums.LoginResult;
import project.models.Admin;
import project.services.admin_services.AdminLoginServices;
import project.viewer.ViewManager;


import java.sql.SQLException;

public class AdminLoginController extends BaseController {

    private Admin admin;
    public AdminLoginController(ViewManager viewManager, String fxmlName) {
        super(viewManager, "/views/ui/"+fxmlName);
    }

    @FXML
    private TextField adminName;

    @FXML
    private PasswordField adminPassword;

    @FXML
    private Label errorLabel;

    @FXML
    void onLoginAction(ActionEvent event) throws SQLException {
        AdminLoginServices adminLoginServices = new AdminLoginServices(adminName.getText(), adminPassword.getText());
        adminLoginServices.start();
        adminLoginServices.setOnSucceeded(e -> {
            LoginResult loginResult = adminLoginServices.getValue();

            switch (loginResult) {
                case SUCCESS -> {
                    errorLabel.setText("");
                    System.out.println("Login Successful");
                  //super.getViewFactory().showAdminDashboard(admin);
                  //super.getViewFactory().closeWindow((Stage).getScene().getWindow());
                  //super.getViewFactory().closeWindow((Stage) adminName.getScene().getWindow());

                }
                case FAILED_BY_CREDENTIALS -> {
                    errorLabel.setText("Invalid Credentials");
                }
                case FAILED_BY_UNEXPECTED_ERROR -> {
                    errorLabel.setText("Failed by Unexpected Error");
                }
                case FAILED_BY_NETWORK -> {
                    errorLabel.setText("Failed to get to network");
                }
            }
        });
    }

//    @FXML
//    void onCFLoginSwitch(ActionEvent event) {
//        super.getViewFactory().showCFLogin();
//        super.getViewFactory().closeWindow((Stage) adminName.getScene().getWindow());
//    }


    @FXML
    void onStudentLoginSwitch(ActionEvent event) {
        super.getViewManager().showLoginView();
        super.getViewManager().closeWindow((Stage) adminName.getScene().getWindow());
    }


}

