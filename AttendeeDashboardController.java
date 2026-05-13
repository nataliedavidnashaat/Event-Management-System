package project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.ResourceBundle;


public class AttendeeDashboardController  implements Initializable 
{

    @FXML
    private Button LogOutButton;
    @FXML
    private ComboBox <Event>combobox;
    @FXML
    private Button AttendeeAccount;
    @FXML
    private ComboBox<Event> RegisterForEventcombobox;

   
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        combobox.getItems().addAll((Database.currentAttendee).getRegisteredEvents());
        RegisterForEventcombobox.getItems().addAll(Database.eventList);
    }

    @FXML
    private void AttendeeAccountHandler(ActionEvent e) throws Exception
    {
       Utility.changeToScene(getClass(), e, "AttendeeInfo.fxml");
    }

   @FXML
   private void RegisterForEventHandler(ActionEvent e) throws Exception 
   {
       Event selectedEvent = RegisterForEventcombobox.getSelectionModel().getSelectedItem();
       if (selectedEvent != null)
       {
           for (int i = 0; i < Database.eventList.size(); i++) 
           {
            if (Database.eventList.get(i).equals(selectedEvent))
            {
                Database.currentEvent = Database.eventList.get(i);
                Utility.changeToScene(getClass(), e, "RegisterForEvent.fxml");
                break;
            }
           }
       }
   }

    
    @FXML
    private void comboboxhandler(ActionEvent e)throws Exception
    {
        Database.currentEvent = combobox.getSelectionModel().getSelectedItem();
        Utility.changeToScene(getClass(), e, "AttendeeRegisterdEvent.fxml");
    }
    
     @FXML
    private void LogOutHandler(ActionEvent e) throws Exception
    {
        Utility.changeToScene(getClass(), e, "MainDashboard.fxml");
    }

}