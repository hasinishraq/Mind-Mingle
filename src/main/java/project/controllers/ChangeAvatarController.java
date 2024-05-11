package project.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import project.viewer.ViewManager;
import project.models.Student;

import java.net.URL;
import java.util.ResourceBundle;

public class ChangeAvatarController extends BaseController implements Initializable {

    @FXML
    private Label myname;
    private Student student;

    public ChangeAvatarController(ViewManager viewManager, String fxmlName, Student student) {
        super(viewManager, "/views/ui/"+fxmlName);
        this.student= student;
    }

    @FXML
    void backToProfile(ActionEvent event) {
        super.getViewManager().showProfile(student);
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        super.getViewManager().closeWindow(stage);

    }

    @FXML
    void updateAvater(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        myname.setText(student.getName());

    }
}
