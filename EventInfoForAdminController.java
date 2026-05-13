
package project;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;


public class EventInfoForAdminController implements Initializable {

    @FXML
    private Label Label5;
    @FXML
    private Label Label4;
    @FXML
    private Label label7;
    @FXML
    private Label Label3;
    @FXML
    private Label Label1;
    @FXML
    private Label Label2;
    @FXML
    private Label label6;

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        Label1.setText(Database.currentEvent.getEventName());
        Label2.setText(Database.currentEvent.getCategory());
        Label3.setText(String.valueOf(Database.currentEvent.getStartingHour()));
        Label4.setText(String.valueOf(Database.currentEvent.getEndingHour()));
        Label5.setText(String.valueOf(Database.currentEvent.getRoom().getRoomNo()));
        label6.setText(String.valueOf(Database.currentEvent.getPrice()));
        label7.setText(Database.currentEvent. getOrganizer().getUsername());     
    }    

    @FXML
    private void ReturnButtonHandler(ActionEvent event) throws Exception 
    {
        Utility.changeToScene(getClass(), event, "AdminDashboard.fxml");

    }

    @FXML
    private void CancelEventButtonHandler(ActionEvent event) throws Exception 
    {
        Utility.changeToScene(getClass(), event, "CancelEventForAdmin.fxml");
    }

    @FXML
    private void UpdateEventButtonHandler(ActionEvent event) throws Exception 
    {
        Utility.changeToScene(getClass(), event, "UpdateEventForAdmin.fxml");
    }
    
}
