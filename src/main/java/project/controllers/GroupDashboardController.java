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

public class GroupDashboardController extends BaseController implements Initializable {
    private Student student;

    public GroupDashboardController(ViewManager viewManager, String fxmlName, Student student) {
        super(viewManager, "/views/ui/"+fxmlName);
        this.student = student;
    }
    @FXML
    void backToDa(ActionEvent event) {
        super.getViewManager().showDashboard(student);

        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        super.getViewManager().closeWindow(stage);
    }

    @FXML
    void getContentt(ActionEvent event) {
        super.getViewManager().showContent(student);
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        super.getViewManager().closeWindow(stage);

    }
    @FXML
    void openWhite(ActionEvent event) {
        super.getViewManager().showWhiteBoard(student);
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        super.getViewManager().closeWindow(stage);

    }



    @FXML
    void screenSharee(ActionEvent event) {
        super.getViewManager().showScreenShare(student);
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        super.getViewManager().closeWindow(stage);
    }

    @FXML
    void openWB(ActionEvent event) {
        super.getViewManager().openWhiteBoardShare();
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        super.getViewManager().closeWindow(stage);

    }


    @FXML
    void getContent(ActionEvent event) {
        super.getViewManager().showContent(student);
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        super.getViewManager().closeWindow(stage);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    void pdfOpen(ActionEvent event) {
        //open pdf using windows pdf viewer
        
    }
}
