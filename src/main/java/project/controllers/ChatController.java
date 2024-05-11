package project.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import project.viewer.ViewManager;
import project.models.Student;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ChatController extends BaseController implements Initializable {
    @FXML
    private TextArea chatArea;
    @FXML
    private TextField messageField;
    @FXML
    private Label sname;



    private Student student;

    public ChatController(ViewManager viewManager, String fxmlName, Student student) {
        super(viewManager, "/views/ui/"+fxmlName);
        this.student= student;
    }

    @FXML
    public void sendMessage() {
        String message = messageField.getText();
        getWriter().println(message);
        chatArea.appendText("You: " + message + "\n");
        messageField.clear();
    }



//    @FXML
//    void backButton(ActionEvent event) {
//        super.getViewFactory().showDashboard((Student) getStudent());
//        super.getViewFactory().closeWindow((javafx.stage.Stage) chatArea.getScene().getWindow());
//    }


    @Override
    public void run() {
        String message;
        try {
            while ((message = getReader().readLine()) != null) {
                final String messageText = message;
                javafx.application.Platform.runLater(() -> chatArea.appendText(messageText + "\n"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sname.setText(student.getName());
    }
}
