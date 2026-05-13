
package project;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

public class OrganizerDashboard01Controller implements Initializable
{
    @FXML
    private Button LogoutButton;
    @FXML
    private Button createEventButton;
    @FXML
    private Button cancelEventButton;
    @FXML
    private Button updateEventButton;
    @FXML
    private Button checkWalletButton;
    @FXML
    private Button viewMyEventsButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void createEventButtonHandler(ActionEvent event) throws Exception
    {
        Utility.changeToScene(getClass(), event, "CreateEvent.fxml");
    }

    @FXML
    private void cancelEventButtonHandler(ActionEvent event) throws Exception
    {
        Utility.changeToScene(getClass(), event, "CancelEvent.fxml");
    }

    @FXML
    private void updateEventButtonHandler(ActionEvent event) throws Exception 
    {
        Utility.changeToScene(getClass(), event, "UpdateEvent.fxml");
    }
    @FXML
    private void LogoutButtonHandler(ActionEvent event) throws Exception
    {
        Utility.changeToScene(getClass(), event, "MainDashboard.fxml");
    }

    @FXML
    private void checkWalletButtonHandler(ActionEvent event)
    {
        double balance = Database.currentOrganizer.getOrganizerWallet().getBalance();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Wallet Balance");
        alert.setContentText("Current Balance: $" + balance);
        alert.showAndWait();
    }

    @FXML
    private void viewMyEventsButtonHandler(ActionEvent event) 
    {
        StringBuilder sb = new StringBuilder("Events created:\n");
        for (int i = 0; i < Database.currentOrganizer.getOrganizerEvents().size(); i++)
        {
            sb.append(Database.currentOrganizer.getOrganizerEvents().get(i).getEventName()).append("\n");
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("My Events");
        alert.setContentText(sb.toString());
        alert.showAndWait();
    }
}
