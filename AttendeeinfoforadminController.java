package project;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.fxml.FXML;

import static project.Database.currentAttendee;

public class AttendeeinfoforadminController implements Initializable 
{
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy"); // 3alashan a display el date bel format di

    @FXML
    public Label label1;
    @FXML
    public Label label2;
    @FXML
    public Label label3;
    @FXML
    public Label label4;
    @FXML
    public Button returnlabel;
    @FXML
    private Label label5;

    public void initialize(URL url, ResourceBundle rb)
    {
        label1.setText( currentAttendee.getUsername());
        label2.setText(currentAttendee.getDateOfBirth().format(formatter));
        label3.setText(currentAttendee.getSex());
        label4.setText(currentAttendee.getAddress());
        label5.setText( currentAttendee.getUsername());
    }

    @FXML
    public void returnhandler(ActionEvent e) throws Exception
    {
        Utility.changeToScene(getClass(), e, "AdminDashboard.fxml");
    }
}
