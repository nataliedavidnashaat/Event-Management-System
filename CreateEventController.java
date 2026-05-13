package project;
import java.io.File;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class CreateEventController implements Initializable
{
    @FXML
    private Button uploadImageButton;


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
    private Button createEventTextFiled;
    @FXML
    private Button clearAllTextFiled;
    @FXML
    private Button returnToMainMenuTextFiled;
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
    }    

    @FXML
    private void createEventTextFiledHandler(ActionEvent event) throws Exception
    {
        try
        {
            String name = eventNameTextFiled.getText();
            String category = eventCatogoryTextFiled.getText();
            int startHour = Integer.parseInt(eventStartTimeTextFiled.getText().trim());
            int endHour = Integer.parseInt(eventEndTimeTextFiled.getText().trim());
            LocalDate date = eventDateTextFiled.getValue();
            double price = Double.parseDouble(priceOfEventTextFiled.getText().trim());
            int roomNumber = Integer.parseInt(eventRoomTextFiled.getText().trim()); 

            Event e = new Event(name, startHour, endHour, date, category, price, roomNumber);
            e.setOrganizer(Database.currentOrganizer);
            Database.eventList.add(e);
            Database.currentOrganizer.addOrganizerEvents(e);        
//            Database.currentEvent=e;        

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText("Event Confirmation");
            alert.setContentText("Event Created successfully.\n Event ID is "+e.getEventID());
            alert.show();                                
        
            Utility.changeToScene(getClass(), event, "OrganizerDashboard01.fxml");        

            }catch (IllegalArgumentException ex)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Invalid input");
                alert.setContentText(ex.getMessage());
                alert.showAndWait();               
            }   
    }


    @FXML
    private void clearAllTextFiledHandler(ActionEvent event)
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
    private void handleUploadImage(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();  //Creates a file chooser dialog so the organizer can pick a file.
        fileChooser.setTitle("Choose Event Image"); //Sets the title of the file dialog window.

        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", ".png", ".jpg", "*.jpeg")
        ); //limits the files shown in the FileChooser to image files only


        File file = fileChooser.showOpenDialog(uploadImageButton.getScene().getWindow()); //Opens the dialog and lets the organizer pick an image file.

        // it returns a File object for the chosen file.
        if (file != null) {
            Image image = new Image(file.toURI().toString());
            //change the file into a URI string (file path)
            //and passes it to Image cons. so it can load the image
            EventData.selectedImagePath = file.getAbsolutePath();  //saving its path here
            System.out.println("Image path saved: " + EventData.selectedImagePath);

        }
    }

    @FXML
    private void returnToMainMenuTextFiledHandler(ActionEvent event) throws Exception
    {
        Utility.changeToScene(getClass(), event, "OrganizerDashboard01.fxml");
    }
    
}