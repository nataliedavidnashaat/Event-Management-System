package project;
import java.io.File;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class AttendeeRegisterdEventController implements Initializable
{
    @FXML
    private Button Returnbutton;
    @FXML
    private Label Label7;
    @FXML
    private Label Label6;
    @FXML
    private Label Label5;
    @FXML
    private Label Label4;
    @FXML
    private Label Label3;
    @FXML
    private Label Label2;
    @FXML
    private Label Label1;

    
    public void initialize(URL url, ResourceBundle rb) 
    {
        Label1.setText(Database.currentEvent.getEventName());
        Label2.setText(String.valueOf(Database.currentEvent.getRoom().getRoomNo()));
        Label3.setText(Database.currentEvent.getCategory());
        Label7.setText(String.valueOf(Database.currentEvent.getPrice()));
        Label6.setText(Database.currentEvent. getOrganizer().getUsername());
        Label5.setText(String.valueOf(Database.currentEvent.getEndingHour()));
        Label4.setText(String.valueOf(Database.currentEvent.getStartingHour()));
    }

    @FXML
    public void Returnhandler(ActionEvent event) throws Exception
    {
        Utility.changeToScene(getClass(), event, "AttendeeDashboard.fxml");
    }
}
