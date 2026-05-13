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


public class RegisterForEventController implements Initializable
{
    @FXML
    private Button ConfirmRegistrationbutton;
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
    @FXML
    private ImageView eventImageView;
    
    
    public void initialize(URL url, ResourceBundle rb) 
    {
        Label1.setText(Database.currentEvent.getEventName());
        Label2.setText(String.valueOf(Database.currentEvent.getRoom().getRoomNo()));
        Label3.setText(Database.currentEvent.getCategory());
        Label7.setText(String.valueOf(Database.currentEvent.getPrice()));
        Label6.setText(Database.currentEvent. getOrganizer().getUsername());
        Label5.setText(String.valueOf(Database.currentEvent.getEndingHour()));
        Label4.setText(String.valueOf(Database.currentEvent.getStartingHour()));
        
        if (EventData.selectedImagePath != null) 
        {
            File file = new File(EventData.selectedImagePath);
            if (file.exists()) 
            {
                Image image = new Image(file.toURI().toString());
                eventImageView.setImage(image);
                eventImageView.setFitWidth(200);
                eventImageView.setPreserveRatio(true);
            }
        }
    }

    @FXML
    public void ConfirmRegistrationButtonHandler(ActionEvent event) throws Exception
    {

        Attendee attendee =  Database.currentAttendee;
        for(int i= 0 ; i< attendee.getRegisteredEvents().size(); i++)
        {
            if (Database.currentEvent == attendee.getRegisteredEvents().get(i))
            {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Registration Error");
                alert.setHeaderText("Event already registered");
                alert.setContentText("");
                alert.show();

                Utility.changeToScene(getClass(), event, "AttendeeDashboard.fxml");
            }
        }
        try
        {
            Validation.balanceValidation(attendee, Database.currentEvent.getPrice());//3ayez a throw exception law kan el balance mesh kefaya
            Wallet.moneyTransaction(attendee , Database.currentEvent.getOrganizer() , Database.currentEvent.getPrice());
            attendee.getRegisteredEvents().add(Database.currentEvent);
            Database.currentEvent.attendesOfEvent.add(attendee);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText("Event Confirmation");
            alert.setContentText("Registered For Event " + Database.currentEvent.getEventName());
            alert.show();
            Utility.changeToScene(getClass(), event, "AttendeeDashboard.fxml");

        }
        catch (Exception e)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Money Transaction Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }
    @FXML
    public void Returnhandler(ActionEvent event) throws Exception
    {
        Utility.changeToScene(getClass(), event, "AttendeeDashboard.fxml");
    }
}