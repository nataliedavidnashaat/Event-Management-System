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

public class RegisterController implements Initializable
{

    @FXML
    private Button signUpAsAttendeeButton;
    @FXML
    private Button signUpAsOrganizerButton;
    @FXML
    private Button signUpAsAdminButton;
    @FXML
    private Button signUpAsOrganizerButton1;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }

    @FXML
    private void signUpAsAttendeeButtonHandler(ActionEvent event) throws Exception
    {
        Utility.changeToScene(getClass(), event, "SignUpAsAttendee.fxml");
    }

    @FXML
    private void signUpAsOrganizerButtonHandler(ActionEvent event) throws Exception
    {
        Utility.changeToScene(getClass(), event, "SignUpAsOrganizer.fxml");
    }

    @FXML
    private void signUpAsAdminButtonHandler(ActionEvent event) throws Exception
    {
        Utility.changeToScene(getClass(), event, "SignUpAsAdmin.fxml");
    }
    
    @FXML
    private void ReturnToMainMenuTextFiledHandler(ActionEvent event) throws Exception
    {
        Utility.changeToScene(getClass(), event, "MainDashboard.fxml");
    }
}