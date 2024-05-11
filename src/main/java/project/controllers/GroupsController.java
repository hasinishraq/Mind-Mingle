package project.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import project.viewer.ViewManager;

import java.net.URL;
import java.util.ResourceBundle;

public class GroupsController extends BaseController implements Initializable {

    public GroupsController(ViewManager viewManager, String fxmlName) {
        super(viewManager, "/views/ui/"+fxmlName);
    }

    @FXML
    private ComboBox<?> deleteGroupComboBox;

    @FXML
    private ComboBox<?> enrollGroupComboBox;

    @FXML
    private ListView<?> existingGroupsListView;

    @FXML
    private TextField groupNameTextField;

    @FXML
    void createGroup(ActionEvent event) {

    }

    @FXML
    void deleteGroup(ActionEvent event) {

    }

    @FXML
    void enrollInGroup(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
