package project.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import project.DataInstances.TransferObject;
import project.models.Student;
import project.viewer.ViewManager;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class WhiteboardViewController extends BaseController {
    @FXML
    private Canvas whiteboardCanvas;

    private GraphicsContext gc;
    private ObjectInputStream objectInputStream;

    public WhiteboardViewController(ViewManager viewManager, String fxmlName) {
        super(viewManager, "/views/ui/"+fxmlName);

    }



    public void initialize() {
//        gc = whiteboardCanvas.getGraphicsContext2D();
//        setupNetworking();
        try {
            gc = whiteboardCanvas.getGraphicsContext2D();
            setupNetworking();
        } catch (Exception e) {
            e.printStackTrace(); // Log the stack trace
            System.out.println("Error during initialization: " + e.getMessage());
        }
    }

    private void setupNetworking() {
        try {
            Socket socket = getSocket();
            objectInputStream = new ObjectInputStream(socket.getInputStream());

            // Start a new thread to listen for objects from the server
            new Thread(() -> {
                try {
                    while (true) {
                        Object obj = objectInputStream.readObject();
                        if (obj instanceof TransferObject) {
                            TransferObject transferObject = (TransferObject) obj;
                            Image image = transferObject.getImage();
                            updateWhiteboard(image);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateWhiteboard(Image image) {
        // Run in the JavaFX thread
        javafx.application.Platform.runLater(() -> {
            gc.drawImage(image, 0, 0);
        });
    }





}
