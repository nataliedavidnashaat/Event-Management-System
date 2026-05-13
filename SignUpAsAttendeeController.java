package project;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import project.Gender;

public class SignUpAsAttendeeController 
{
    @FXML
    private TextField walletbalance;
    @FXML
    private Button signUpButton;
    @FXML
    private Button returnToMainMenuButton;
    @FXML
    private PasswordField passwordTextField;
    @FXML
    private TextField usernameTextField;
    @FXML
    private DatePicker dateOfBirthDatePicker;
    @FXML
    private RadioButton maleradiobutton1;
    @FXML
    private ToggleGroup Gender1;
    @FXML
    private RadioButton Femaleradiobutton1;
    @FXML
    private TextField addressTextField;

    /**
     * Initializes the controller class.
     */
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void signUpButtonHandler(ActionEvent event) throws Exception
    {
        try
        {

            // the getText method get the string entered int the text field
            // the getValue method gets the value picked in the date picker
            // esta5demt el Double.parseDouble() 3alashan a7awel el text el gaya men walletbalance le data double
            // 3amalt if condition 3ala asas el attendee haye5tar fel radio button male walla female w ab3at 3ala asas da el gender

            if(maleradiobutton1.isSelected()) {

                Attendee a = new Attendee(usernameTextField.getText(), passwordTextField.getText(), dateOfBirthDatePicker.getValue(), Double.parseDouble(walletbalance.getText()),addressTextField.getText(),project.Gender.MALE);
                Database.attendees.add(a);
                Database.currentAttendee = a;
                Utility.changeToScene(getClass(), event, "AttendeeDashboard.fxml");
            }
            else if(Femaleradiobutton1.isSelected()) {


                Attendee a = new Attendee(usernameTextField.getText(), passwordTextField.getText(), dateOfBirthDatePicker.getValue(), Double.parseDouble(walletbalance.getText()),addressTextField.getText(),project.Gender.FEMALE);
                Database.attendees.add(a);
                Database.currentAttendee = a;
                Utility.changeToScene(getClass(), event, "AttendeeDashboard.fxml");
            }
        }
        catch (IllegalArgumentException e)
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