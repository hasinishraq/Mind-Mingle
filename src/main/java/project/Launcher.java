package project;

import javafx.application.Application;
import javafx.stage.Stage;
import project.viewer.ViewManager;



public class Launcher extends Application {

    @Override
    public void start(Stage stage) {
        ViewManager viewManager = new ViewManager();
        viewManager.showLoginView();
//        Image icon = new Image("views/pictures/mlogo.png"); // replace with the actual path to your icon
//        stage.getIcons().add(icon);
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
