
package project;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class SignUpAsOrganizerController implements Initializable {

    @FXML
    private PasswordField PasswordTextField;
    @FXML
    private TextField usernameTextField;
    @FXML
    private DatePicker dateOfBirthDatePicker;
    @FXML
    private Button signUpButton;
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
    private void signUpButtonHandler(ActionEvent event) throws Exception 
    {
          try{
            Organizer o= new Organizer(usernameTextField.getText(),PasswordTextField.getText(),dateOfBirthDatePicker.getValue());
            Database.organizers.add(o);
            Database.currentOrganizer=o;

            Utility.changeToScene(getClass(), event, "OrganizerDashboard01.fxml");

        }catch (IllegalArgumentException e)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Registration Error");
            alert.setHeaderText("Invalid input");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }

    }

    @FXML
    private void returnToMainMenuButtonHandler(ActionEvent event) throws Exception 
    {
        Utility.changeToScene(getClass(), event, "MainDashboard.fxml");
    }
    
}
