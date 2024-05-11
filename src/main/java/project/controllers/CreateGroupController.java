package project.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import project.controllers.BaseController;
import project.middlewares.CourseMiddleware;
import project.middlewares.GroupMiddleware;
import project.middlewares.MemberMiddleware;
import project.models.Course;
import project.viewer.ViewManager;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CreateGroupController extends BaseController implements Initializable {

    public CreateGroupController(ViewManager viewManager, String fxmlName) {
        super(viewManager, "/views/ui/"+fxmlName);
    }

    @FXML
    private ComboBox<Course> courseComboBox; // Changed to ComboBox<Course>

    @FXML
    private Button createGroupButton;

    @FXML
    private TextField groupNameField;

    @FXML
    private TextField member1Field;

    @FXML
    private TextField member2Field;

    @FXML
    private TextField member3Field;

    @FXML
    private TextField member4Field;

    @FXML
    private TextField member5Field;

    private CourseMiddleware courseMiddleware = new CourseMiddleware();
    private GroupMiddleware groupMiddleware = new GroupMiddleware();
    private MemberMiddleware memberMiddleware = new MemberMiddleware();

    @FXML
    void createGroup(ActionEvent event) {
        String groupName = groupNameField.getText();
        int member1 = Integer.parseInt(member1Field.getText());
        int member2 = Integer.parseInt(member2Field.getText());
        int member3 = Integer.parseInt(member3Field.getText());
        int member4 = Integer.parseInt(member4Field.getText());
        int member5 = Integer.parseInt(member5Field.getText());

        //create member
        int midd = memberMiddleware.createMember(member1, member2, member3, member4, member5, 1010);
        Course selectedCourse = courseComboBox.getSelectionModel().getSelectedItem();

        if (selectedCourse != null && !groupName.isEmpty()) {
            // Assuming GroupMiddleware has a method to create a group with members and course

            boolean isGroupCreated = groupMiddleware.createGroup(groupName, selectedCourse.getCourseId(), midd);
            if (isGroupCreated) {
                System.out.println("Group created successfully!");
            } else {
                System.out.println("Failed to create group.");
            }
        } else {
            System.out.println("Group name or course is not selected.");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Course> courses = courseMiddleware.getAllCourses();
        courseComboBox.getItems().addAll(courses);
        //it doesnot show the real course name only show its address(fixed)

        //set course name

    }
}
