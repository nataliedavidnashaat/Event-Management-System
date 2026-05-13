
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

/**
 * FXML Controller class
 *
 * @author Nana
 */
public class LoginController implements Initializable {
    @FXML
    private Button ReturnToMainMenuButton;
    @FXML
    private PasswordField passwordTextFiled;
    @FXML
    private TextField usernameTextFiled;
    @FXML
    private Button loginButton;
    @FXML
    private Button registerNewAccountButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loginButtonHandler(ActionEvent event) throws Exception
    {
        boolean accountFound = false;
        for (int i = 0; i < Database.attendees.size(); i++) 
        {
        if (Database.attendees.get(i).getUsername().equals(usernameTextFiled.getText()) &&
            Database.attendees.get(i).getPassword().equals(passwordTextFiled.getText())) 
        {
            accountFound = true;
            Utility.changeToScene(getClass(), event, "AttendeeDashboard.fxml");
            break;
        }
        }
        
        if (!accountFound)
        {
            for (int i = 0; i < Database.organizers.size(); i++)
            {
                if (Database.organizers.get(i).getUsername().equals(usernameTextFiled.getText()) &&
                Database.organizers.get(i).getPassword().equals(passwordTextFiled.getText()))
                {
                accountFound = true;
                Database.currentOrganizer=Database.organizers.get(i);
                Utility.changeToScene(getClass(), event, "OrganizerDashboard01.fxml");
                break;
                }
            }
        }
        if (!accountFound)
        {
            for (int i = 0; i < Database.admins.size(); i++)
            {
                if (Database.admins.get(i).getUsername().equals(usernameTextFiled.getText().trim()) &&
                Database.admins.get(i).getPassword().equals(passwordTextFiled.getText()))
                {
                accountFound = true;
                Utility.changeToScene(getClass(), event, "AdminDashboard.fxml");
                break;
                }
            }
        }
        
        if (!accountFound) 
        {
            if (!accountFound)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Login Failed");
                alert.setHeaderText(null);
                alert.setContentText("Invalid username or password.");
                alert.showAndWait();
            }
        }
}

        
    

    @FXML
    private void registerNewAccountButtonHandler(ActionEvent event) throws Exception
    {
        Utility.changeToScene(getClass(), event, "Register.fxml");
    }
    @FXML
    private void ReturnToMainMenuButtonHandler (ActionEvent event) throws Exception
    {
        Utility.changeToScene(getClass(), event, "MainDashboard.fxml");
    }
    
}
