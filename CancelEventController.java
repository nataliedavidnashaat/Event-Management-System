
package project;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class CancelEventController implements Initializable {

    @FXML
    private TextField eventNameTextField;
    @FXML
    private TextField eventIDTextField;
    @FXML
    private Button cancelEventButton;
    @FXML
    private Button clearAllButton;
    @FXML
    private Button returnToMainMenuButton;
    
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void cancelEventButtonHandler(ActionEvent event) throws Exception
    {
          int eventID = Integer.parseInt(eventIDTextField.getText().trim());
        if (eventNameTextField.getText() == null || eventNameTextField.getText().isBlank())
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Missing Input");
            alert.setContentText("Please enter the name of the event to cancel.");
            alert.showAndWait();
            return;
        }
         if (eventID == 0 || eventIDTextField.getText().isBlank())
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Missing Input");
            alert.setContentText("Please enter the event ID of the event to cancel.");
            alert.showAndWait();
            return;
        }
        for (int i = 0; i < Database.eventList.size(); i++) 
        {
            if(Database.eventList.get(i).getEventID()==eventID)
            {
                Database.currentEvent=Database.eventList.get(i);
                
                for (int j = 0; j < Database.currentEvent.attendesOfEvent.size(); j++) {
                                    
                    Wallet.moneyRefund(Database.currentEvent.attendesOfEvent.get(j),Database.currentEvent.getOrganizer(),
                            Database.currentEvent.getPrice());
                    
                }
                Database.eventList.remove(i);
                Database.currentOrganizer.cancelEvent(eventNameTextField.getText());
                 Alert alert = new Alert(Alert.AlertType.INFORMATION);
                 alert.setTitle("Event Canceled");
                 alert.setHeaderText("Success");
                 alert.setContentText("Event '" + eventNameTextField.getText() + "' has been canceled.");
                 alert.show();
                 Utility.changeToScene(getClass(), event, "OrganizerDashboard01.fxml");
                 break;
            }else 
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Invalid Input");
                alert.setContentText("Event ID doesn't exist.");
                alert.showAndWait();
            }
        }
    }

    @FXML
    private void clearAllButtonHandler(ActionEvent event)
    {
        eventNameTextField.setText(" ");
        eventIDTextField.setText(" "); 
    }

    @FXML
    private void returnToMainMenuButtonHandler(ActionEvent event) throws Exception 
    {
        Utility.changeToScene(getClass(), event, "OrganizerDashboard01.fxml");
    }
    
}
