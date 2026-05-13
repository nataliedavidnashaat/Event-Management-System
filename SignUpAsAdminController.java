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

public class SignUpAsAdminController implements Initializable 
{

    @FXML
    private Button signUpAsAdminButton;
    @FXML
    private Button returnToMainMenuButton;
    @FXML
    private PasswordField passwordTextFiled;
    @FXML
    private TextField usernameTextFiled;
    @FXML
    private DatePicker dateOfBirthDatePicker;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }    

    @FXML
    private void signUpAsAdminButtonHandler(ActionEvent event) throws Exception
    {
          try
          {
            Admin ad= new Admin(usernameTextFiled.getText(),passwordTextFiled.getText(),dateOfBirthDatePicker.getValue());
            Database.admins.add(ad);
            Database.currentAdmin= ad;
            Utility.changeToScene(getClass(), event, "AdminDashboard.fxml");
          }
        catch(IllegalArgumentException e)
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