package project.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import project.viewer.ViewManager;
import project.models.Student;

import java.net.URL;
import java.util.ResourceBundle;


public class DashboardController extends BaseController implements Initializable {

    private Student student;



    public DashboardController(ViewManager viewManager, String fxmlName, Student student) {
        super(viewManager, "/views/ui/"+fxmlName);
        this.student= student;
    }

    @FXML
    void sShare(ActionEvent event) {
        super.getViewManager().showScreenShare(student);
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        super.getViewManager().closeWindow(stage);

    }

    @FXML
    void openAnimat(ActionEvent event) {
        super.getViewManager().showAnimation(student);
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        super.getViewManager().closeWindow(stage);

    }

    @FXML
    void openProfile(ActionEvent event) {
        super.getViewManager().showProfile(student);
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        super.getViewManager().closeWindow(stage);

    }

   @FXML
   void openGroup(ActionEvent event){
       super.getViewManager().showGroupDashboard(student);
         Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        super.getViewManager().closeWindow(stage);
   }

    @FXML
    void viewScreen(ActionEvent event) {
        super.getViewManager().viewShare();
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        super.getViewManager().closeWindow(stage);
    }

    @FXML
    void onLogOut(ActionEvent event) {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        super.getViewManager().closeWindow(stage);
    }

    @FXML
    void openCourse(ActionEvent event) {

        super.getViewManager().showCourses(student);
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        super.getViewManager().closeWindow(stage);


    }

    @FXML
    void openChatting(ActionEvent event) {
        super.getViewManager().showChat();
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        super.getViewManager().closeWindow(stage);


    }

    @FXML
    void createGroupp(ActionEvent event) {
        super.getViewManager().showCreateGroup();
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        super.getViewManager().closeWindow(stage);


    }



    @FXML
    private Label myname;

    @FXML
    private ImageView profilepic;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        myname.setText(student.getName());
//        String imagePath = "/views/profile.png";
//        Image image = new Image(imagePath);
//        profilepic.setImage(image);

    }
}