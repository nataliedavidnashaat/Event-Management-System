package project;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

import static project.Database.*;

public class AdminDashboard implements Initializable
  {
      @FXML
      private ComboBox DisplayOrganizersComboBox;
      @FXML
      private ComboBox DisplayAttendeesComboBox;
      @FXML
      private ComboBox DisplayEventsComboBox;
      @FXML
      private Button LogoutButton;

      @Override
      public void initialize(URL url, ResourceBundle rb) 
      {
          DisplayEventsComboBox.getItems().addAll(eventList);
          DisplayAttendeesComboBox.getItems().addAll(attendees);
          DisplayOrganizersComboBox.getItems().addAll(organizers);
      }
      
    @FXML
    private void DisplayEventsHandler(ActionEvent event) throws Exception
    {
          for(int i = 0 ; i < eventList.size(); i++)
          {
              if(Database.eventList.get(i).equals(DisplayEventsComboBox.getSelectionModel().getSelectedItem()))
              {
                  Database.currentEvent = eventList.get(i);
                  Utility.changeToScene(getClass(), event, "EventInfoForAdmin.fxml");

              }
          }
    }
    
    @FXML
    private void DisplayOrganizersHandler(ActionEvent event) throws Exception 
    {
            for(int i = 0 ; i < organizers.size() ; i++)
            {
                if(Database.organizers.get(i).equals(DisplayOrganizersComboBox.getSelectionModel().getSelectedItem()))
                {
                    Database.currentOrganizer = organizers.get(i);
                    Utility.changeToScene(getClass(), event, "Organizerinfoforadmin.fxml");
                }
            }
    }
    
    @FXML
    private void DisplayAttendeesHandler(ActionEvent event) throws Exception 
    {
            for(int i = 0 ; i < Database.attendees.size(); i++) 
            {
                if (Database.attendees.get(i).equals(DisplayAttendeesComboBox.getSelectionModel().getSelectedItem()))
                {
                    Database.currentAttendee = attendees.get(i);
                    Utility.changeToScene(getClass(), event, "Attendeeinfoforadmin.fxml");
                }
            }
    }
 
    
    @FXML
    private void LogoutButtonHandler(ActionEvent event) throws Exception
    {
        Utility.changeToScene(getClass(), event, "MainDashboard.fxml");
    }


//    public String Display(){
//        return DisplayAttendeesChoiceBox.getValue();
//    }
}