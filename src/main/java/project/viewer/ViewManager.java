package project.viewer;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import project.controllers.*;
import project.controllers.SignupController;
import project.models.Student;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class ViewManager implements Initializable {

    private static Map<Class<?>, Stage> windows = new HashMap<>();

    public ViewManager() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }



    public void showLoginView() {
        if(!checkIfWindowWasPrevOpened(LoginController.class)) {
            BaseController controller = new LoginController(this, "login.fxml");
            init_window(controller, "Login");
        }
    }

    public void showSignupWindow() {
        BaseController controller = new SignupController(this, "signup.fxml");
        init_window(controller, "Sign Up");
    }

    public void showAnimation(Student student) {
        BaseController controller = new AnimationController(this, "animation.fxml",student);
        init_window(controller, "Animation");
    }



    public void showDashboard(Student student) {
        BaseController controller = new DashboardController(this, "dashboard.fxml",student);
        init_window(controller, "Dashboard");
    }

    public void showScreenShare(Student student) {
        BaseController controller = new ScreenShareController(this, "screenshare.fxml",student);
        init_window(controller, "Screen Share");
    }

    public void showGroups() {
        BaseController controller = new GroupsController(this, "groupscene.fxml");
        init_window(controller, "Groups");
    }

    public void viewShare(){
        BaseController controller = new ViewShareController(this, "viewshare.fxml");
        init_window(controller, "ViewShare");
    }

 // admin

    public void showAdminLogin(){
        BaseController controller = new AdminLoginController(this, "adminlogin.fxml");
        init_window(controller, "Admin Login");
    }

//    public void showAdminDashboard(Admin admin) {
//        BaseController controller = new AdminDashboardController(this, "admindashboard.fxml",admin);
//        init_window(controller, "Admin Dashboard");
//    }

    public void showProfile(Student student) {
        BaseController controller = new ProfileController(this, "profile.fxml",student);
        init_window(controller, "Profile");
    }

    public void showChangeAvatar(Student student) {
        BaseController controller = new ChangeAvatarController(this, "changeavatar.fxml",student);
        init_window(controller, "Change Avatar");
    }

    public void showGroupDashboard(Student student) {
        BaseController controller = new GroupDashboardController(this, "groupdashboard.fxml",student);
        init_window(controller, "Group Dashboard");
    }

    public void showContent(Student student) {
        BaseController controller = new ContentController(this, "content.fxml",student);
        init_window(controller, "Content");

    }


   public void showCourses(Student student) {
        BaseController controller = new CoursesController(this, "courses.fxml",student);
        init_window(controller, "Courses");
    }

    public void showCourseDesigner(Student student) {
        BaseController controller = new CourseDesignerController(this, "coursedesigner.fxml",student);
        init_window(controller, "Course Designer");
    }

    public void showContentDesigner(Student student) {
        BaseController controller = new ContentDesignerController(this, "contentdesigner.fxml",student);
        init_window(controller, "Content Designer");
    }

    public void showWhiteBoard(Student student) {
        BaseController controller = new WhiteBoardController(this, "whiteboard.fxml",student);
        init_window(controller, "Whiteboard");
    }
    public void showChat(){
        BaseController controller = new ChatController(this, "chat.fxml",new Student());
        init_window(controller, "Chat");
    }

    public void showCreateGroup(){
        BaseController controller = new CreateGroupController(this, "creategroup.fxml");
        init_window(controller, "Create Group");

    }

    public void openWhiteBoardShare() {
        BaseController controller = new WhiteboardViewController(this, "whiteboardviewer.fxml");
        init_window(controller, "Whiteboard Share");
    }


//    public void showPdf(Student student) {
//        BaseController controller = new PdfController(this, "pdf.fxml",student);
//        init_window(controller, "Pdf");
//    }


    private void init_window(BaseController controller, String title) {
      FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(controller.getFxmlName()));
         // FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/ui/" + controller.getFxmlName()));
        fxmlLoader.setController(controller);

        Parent parent;
        try{
            parent = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle(title);
        stage.setResizable(false);
        stage.show();
        windows.put(controller.getClass(), stage);
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                Platform.exit();
                windows.clear();
                System.exit(0);
            }
        });
    }

    private void init_window_UnclosableWindow(BaseController controller, String title) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(controller.getFxmlName()));
        //FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/ui/" + controller.getFxmlName()));

        fxmlLoader.setController(controller);

        Parent parent;
        try{
            parent = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle(title);
        stage.setResizable(false);
        stage.show();
        windows.put(controller.getClass(), stage);
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                windows.remove(controller.getClass());
            }
        });
    }

    private boolean checkIfWindowWasPrevOpened(Class<?> controllerClass) {
        if(windows.containsKey(controllerClass)) {
            windows.get(controllerClass).show();
            return true;
        }

        return false;
    }

    public void closeWindow(Stage stage) {
        stage.close();
    }



}
