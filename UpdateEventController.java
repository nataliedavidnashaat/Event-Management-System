package project;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class UpdateEventController implements Initializable {

    @FXML
    private TextField eventNameTextFiled;
    @FXML
    private TextField eventCatogoryTextFiled;
    @FXML
    private TextField eventRoomTextFiled;
    @FXML
    private TextField eventStartTimeTextFiled;
    @FXML
    private TextField eventEndTimeTextFiled;
    @FXML
    private DatePicker eventDateTextFiled;
    @FXML
    private TextField priceOfEventTextFiled;
    @FXML
    private TextField eventIDTextFileld;
    @FXML
    private Button updateEventButton;
    @FXML
    private Button clearAllButton;
    @FXML
    private Button returnToMainMenuButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
    }    
    
    @FXML
    private void updateEventButtonHandler(ActionEvent event) throws Exception
    {
    try {
        int id = Integer.parseInt(eventIDTextFileld.getText().trim());
        Event oldEvent=null;
        Event eventToUpdate = null;
        for (int i = 0; i < Database.eventList.size(); i++)
        {
            if (Database.eventList.get(i).getEventID() == id) 
            {
                eventToUpdate = Database.eventList.get(i);
                oldEvent=Database.eventList.get(i);
                break;
            }
        }

        if (eventToUpdate == null)
        {
            throw new IllegalArgumentException("Event with the provided ID does not exist.");
        }

        if (!eventNameTextFiled.getText().trim().isEmpty()) 
        {
                eventToUpdate.setEventName(eventNameTextFiled.getText());
        }

        // Category
        String category = eventCatogoryTextFiled.getText().trim();
        if (!category.isEmpty())
        {
            eventToUpdate.setCategory(category);
        }
        

        if (!eventRoomTextFiled.getText().trim().isEmpty()) 
        {
            int roomNum = Integer.parseInt(eventRoomTextFiled.getText().trim());
            Room room=new   Room(roomNum);
            int startHour = Integer.parseInt(eventStartTimeTextFiled.getText().trim());
            int endHour = Integer.parseInt(eventEndTimeTextFiled.getText().trim());
            if (roomNum < 1 || roomNum > Room.getRooms().length) 
            {
                throw new IllegalArgumentException("Selected room number doesn't exist.");
            }
            if (!Validation.availableRoomValidation(startHour, endHour,room))
            {
                throw new IllegalArgumentException("Selected room is not available at the current event time.");
            }
            eventToUpdate.setRoomNumber(roomNum);
        }

        // Start Time
        if (!eventStartTimeTextFiled.getText().trim().isEmpty()&&!eventEndTimeTextFiled.getText().trim().isEmpty()) 
        {
            int startHour = Integer.parseInt(eventStartTimeTextFiled.getText().trim());
            int endHour = Integer.parseInt(eventEndTimeTextFiled.getText().trim());
            if (!Validation.hoursValidation(startHour, endHour))
            {
                throw new IllegalArgumentException("Invalid start hour and end hour.");
            }
            eventToUpdate.setStartingHour(startHour);
        }

        // Date
        LocalDate newDate = eventDateTextFiled.getValue();
        if (newDate != null)
        {
            if(newDate.isBefore(LocalDate.now()))
            {
                throw new IllegalArgumentException("Date of event cannot be in the past.");
            }
            eventToUpdate.setDateOfEvent(newDate);
        }

        // Price
        if (!priceOfEventTextFiled.getText().trim().isEmpty())
        {
            double price = Double.parseDouble(priceOfEventTextFiled.getText().trim());
            if (price < 0)
            {
                throw new IllegalArgumentException("Price must be greater than zero.");
            }
            eventToUpdate.setPrice(price);
        }
        
        Database.eventList.remove(eventToUpdate);
        Database.eventList.add(eventToUpdate);
        Database.currentOrganizer.updateEvent(eventToUpdate, oldEvent);
        
        Alert success = new Alert(Alert.AlertType.INFORMATION);
        success.setHeaderText("Success");
        success.setContentText("Event updated successfully!");
        success.show();
        Utility.changeToScene(getClass(), event, "OrganizerDashboard01.fxml");

    } catch (IllegalArgumentException e) 
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Error");
        alert.setContentText(e.getMessage());
        alert.showAndWait();
    }
}

    @FXML
    private void clearAllButtonHandler(ActionEvent event) 
    {
        eventNameTextFiled.setText(" ");
        eventCatogoryTextFiled.setText(" ");
        eventRoomTextFiled.setText(" ");
        eventStartTimeTextFiled.setText(" ");
        eventEndTimeTextFiled.setText(" ");
        eventDateTextFiled.setValue(null);
        priceOfEventTextFiled.setText(" ");
    }

    @FXML
    private void returnToMainMenuButtonHandler(ActionEvent event) throws Exception
    {
        Utility.changeToScene(getClass(), event, "OrganizerDashboard01.fxml");
    }
    
}
