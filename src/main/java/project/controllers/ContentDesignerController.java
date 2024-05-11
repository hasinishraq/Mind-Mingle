package project.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.stage.Stage;
import project.viewer.ViewManager;
import project.models.Student;

import java.net.URL;
import java.util.ResourceBundle;

public class ContentDesignerController extends BaseController implements Initializable {

    private Student student;

    public ContentDesignerController(ViewManager viewManager, String fxmlName, Student student) {
        super(viewManager, "/views/ui/"+fxmlName);
        this.student= student;
    }

    @FXML
    void openCourseDesigner(ActionEvent event) {
        super.getViewManager().showCourseDesigner(student);
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        super.getViewManager().closeWindow(stage);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
