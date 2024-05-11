package project.controllers;

import com.jfoenix.controls.JFXSlider;
import com.jfoenix.controls.JFXToggleButton;
import javafx.animation.AnimationTimer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import project.DataInstances.Screenshare;
import project.DataInstances.TransferObject;
import project.viewer.ViewManager;
import project.models.Student;

import java.io.IOException;


public class WhiteBoardController extends BaseController implements ChangeListener {

    private Student student;

    public WhiteBoardController(ViewManager viewManager, String fxmlName, Student student) {
        super(viewManager, "/views/ui/"+fxmlName);
        this.student= student;
    }

    private double brushSize;
    private Color brushColor;
    private GraphicsContext graphicsContext;
    private long prevt = 0;
    private Mytimer mytimer;
    private WritableImage image;
    private TransferObject transferObject;
    private WritableImage imageThat;
    private boolean annote = true;
    private boolean hasText = false;
    private String textToAdd;
    @FXML
    private TextField addTextLabel;

    @FXML
    private ImageView canvasThat;

    @FXML
    private Canvas canvasThis;

    @FXML
    private ColorPicker colorPicker;

    @FXML
    private JFXSlider slider;

    @FXML
    private JFXSlider textSize;

    @FXML
    private JFXToggleButton toggleAnnote;


    public void initialize(){
        graphicsContext = canvasThis.getGraphicsContext2D();
        initDraw(graphicsContext);
        addlisteners();
        brushSize = slider.getValue();
        colorPicker.setValue(Color.BLACK);
        brushColor = colorPicker.getValue();
        transferObject = new TransferObject();
        System.out.println(colorPicker.getValue());
        System.out.println(brushSize);
        slider.valueProperty().addListener(this);
        colorPicker.valueProperty().addListener(this);
        mytimer = new Mytimer();
        mytimer.start();
    }

    public void changeColor(){
        brushColor = colorPicker.getValue();
        graphicsContext.setStroke(brushColor);
    }
    @Override
    public void changed(ObservableValue observableValue, Object o, Object t1) {
        brushSize = slider.getValue();
        graphicsContext.setLineWidth(brushSize/10.0);
        //System.out.println(brushSize);
        // System.out.println(brushColor);
    }

    public void backtoHome(ActionEvent event) throws IOException {
        mytimer.stopNow();
        super.getViewManager().showGroupDashboard(student);
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        super.getViewManager().closeWindow(stage);


    }

    public void clearScreen(){
        graphicsContext.clearRect(5,5,graphicsContext.getCanvas().getWidth()-10,graphicsContext.getCanvas().getHeight()-10);
    }

    public void switchAnnote(){
        if( toggleAnnote.isSelected() ){
            annote = true;
        } else{
            annote = false;
        }
    }
    public void addText(){
        textToAdd = addTextLabel.getText().toString().trim();
        addTextLabel.setText("");
        hasText = true;
    }

    private void addlisteners(){
        canvasThis.addEventHandler(MouseEvent.MOUSE_PRESSED,
                new EventHandler<MouseEvent>(){
                    @Override
                    public void handle(MouseEvent event) {
                        if( hasText ){
                            graphicsContext.setFont(new Font(textSize.getValue()));
                            graphicsContext.setFill(Color.BLACK);
                            graphicsContext.fillText(textToAdd,event.getX(),event.getY());
                            graphicsContext.setStroke(brushColor);
                            hasText = false;
                            textToAdd = "";
                        }else if(annote){
                            //graphicsContext.strokeOval(event.getX()-brushSize/10.0, event.getY()-brushSize/10.0, brushSize/5.0, brushSize/5.0);
                            graphicsContext.beginPath();
                            graphicsContext.moveTo(event.getX(), event.getY());
                            graphicsContext.stroke();
                        }
                    }
                });

        canvasThis.addEventHandler(MouseEvent.MOUSE_DRAGGED,
                new EventHandler<MouseEvent>(){

                    @Override
                    public void handle(MouseEvent event) {
                        if(annote){
                            graphicsContext.lineTo(event.getX(), event.getY());
                            graphicsContext.stroke();
                        }
                    }
                });

        canvasThis.addEventHandler(MouseEvent.MOUSE_RELEASED,
                new EventHandler<MouseEvent>(){

                    @Override
                    public void handle(MouseEvent event) {

                    }
                });


    }

    private void initDraw(GraphicsContext gc){
        double canvasWidth = gc.getCanvas().getWidth();
        double canvasHeight = gc.getCanvas().getHeight();

        gc.setFill(Color.TRANSPARENT);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(10);

        gc.fill();
        gc.strokeRect(
                0,              //x of the upper left corner
                0,              //y of the upper left corner
                canvasWidth,    //width of the rectangle
                canvasHeight);  //height of the rectangle

        gc.setFill(Color.RED);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(5);

    }

    private class Mytimer extends AnimationTimer{

        @Override
        public void handle(long l) {
            if( l - prevt>100000000 ){
                imageThat = Screenshare.getInstance().getImage();
                canvasThat.setImage(imageThat);
                image = canvasThis.snapshot(null, null);
                transferObject.setImage(image);
//                if( Server.getInstance().isConnected() ){
//                    Server.getInstance().send(transferObject);
//                }
                prevt = l;
            }
        }
        public void stopNow(){
            stop();
        }
    }
}
