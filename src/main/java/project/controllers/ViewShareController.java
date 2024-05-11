package project.controllers;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.robot.Robot;
import project.DataInstances.Screenshare;
import project.DataInstances.TransferObject;
import project.viewer.ViewManager;

public class ViewShareController extends BaseController  {
    private int first = 1;

    @FXML
    private ImageView imageViewTry;

    private Robot robot;
    private WritableImage image;
    private long prevt = 0;
    private int index = 0;
    private long thistime;
    private AnimationTimer anim;
    private TransferObject transferObject;
    //private Image defaultImage;// = "../Images/bank.png";

    public ViewShareController(ViewManager viewManager, String fxmlName) {
        super(viewManager, "/views/ui/"+fxmlName);
    }

    private void addTimer(){
        anim = new Mytimer();
        anim.start();
    }

    
    public void initialize() {
        System.out.println("init");
        //defaultImage = new Image("../Images/bank.png");
        //transferObject = new TransferObject();
        thistime = System.currentTimeMillis();
        // robot = new Robot();
        addTimer();
    }


    private class Mytimer extends AnimationTimer{
        @Override
        public void handle(long l) {
            if( l - prevt>500000000 ){
                image = Screenshare.getInstance().getImage();
                if( image!=null ){
                    if( first>0 ){
                        System.out.println("image loaded");
                        first = 0;
                    }
                    imageViewTry.setImage(image);
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

                }



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
