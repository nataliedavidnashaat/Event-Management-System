package project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.ResourceBundle;
import static project.Database.*;


public class AttendeeInfoController  implements Initializable
{
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy"); // 3alashan a display el date bel format di
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

    @Override

    public void initialize(URL url, ResourceBundle rb) 
    {
        Attendee attendee =  Database.currentAttendee;
        Label1.setText(attendee.getUsername());
        Label2.setText(attendee.getUsername());
        Label3.setText(attendee.getDateOfBirth().format(formatter));
        Label4.setText(attendee.getSex());
        Label5.setText(String.valueOf(attendee.getAttendeeWallet().getBalance()));// esta5demt valueOf 3alashan a7awel el double le String
    }

    @FXML
    private void returnToMainMenuHandler(ActionEvent event) throws Exception
    {
        Utility.changeToScene(getClass(), event, "AttendeeDashboard.fxml");
    }
}