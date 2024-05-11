package project.controllers;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.robot.Robot;
import javafx.stage.Stage;
import project.DataInstances.TransferObject;
import project.viewer.ViewManager;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

import project.models.Student;

public class ScreenShareController extends BaseController implements Initializable {

    public ScreenShareController(ViewManager viewManager, String fxmlName, Student student) {
        super(viewManager, "/views/ui/"+fxmlName);
        this.student = student;
    }
    private Student student;

    private int first = 1;
    @FXML private ImageView imageViewTry;
    @FXML
    void backDash(ActionEvent event) {

        //anim.stopNow();
        super.getViewManager().showGroupDashboard(student);
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        super.getViewManager().closeWindow(stage);

    }
    private Robot robot;
    private WritableImage image;
    private long prevt = 0;
    private int index = 0;
    private long thistime;
    private AnimationTimer anim;
    private TransferObject transferObject;

    public void initialize() throws FileNotFoundException {


    }
    private void addTimer(){
        anim = new Mytimer();
        anim.start();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("init");
        transferObject = new TransferObject();
        thistime = System.currentTimeMillis();
        robot = new Robot();
        addTimer();

    }

//    public void handleButtonAction2(ActionEvent event) throws IOException {
//        System.out.println("You clicked me!2");
//        anim.stop();
//        Stage stageTheEventSourceNodeBelongs = (Stage) ((Node)event.getSource()).getScene().getWindow();
//        Parent root = FXMLLoader.load(getClass().getResource("../ViewFXML/sample.fxml"));
//        stageTheEventSourceNodeBelongs.setScene(new Scene(root));
//    }

    private class Mytimer extends AnimationTimer{
        @Override
        public void handle(long l) {
            if( l - prevt>500000000 ){
                image = robot.getScreenCapture(image,0,0,1920,1080);
                imageViewTry.setImage(image);
                transferObject.setImage(image);
                if( first>0 ){
                    WritableImage image1 = (WritableImage) imageViewTry.getImage();
                    System.out.println("Prev size "+image.getWidth()+" "+image.getHeight());
                    System.out.println("Now size "+image1.getWidth()+" "+image1.getHeight());
                    first = 0;
                }
//                if(Server.getInstance().isConnected()){
//                    // System.out.println("in loop");
//                    Server.getInstance().send(transferObject);
//                }
                double w = 0;
                double h = 0;

                double ratioX = imageViewTry.getFitWidth() / image.getWidth();
                double ratioY = imageViewTry.getFitHeight() / image.getHeight();

                double reducCoeff = 0;
                if(ratioX >= ratioY) {
                    reducCoeff = ratioY;
                } else {
                    reducCoeff = ratioX;
                }

                w = image.getWidth() * reducCoeff;
                h = image.getHeight() * reducCoeff;

                imageViewTry.setX((imageViewTry.getFitWidth() - w) / 2);
                imageViewTry.setY((imageViewTry.getFitHeight() - h) / 2);



                index+=1;
                if(index>100){
                    long end = System.currentTimeMillis();
                    System.out.println((end-thistime));
                    thistime = end;
                    index = 0;
                }
                prevt = l;
            }
        }
        public void stopNow(){
            stop();
        }

    }


}

