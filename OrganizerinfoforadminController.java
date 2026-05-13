package project;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.fxml.FXML;

public class OrganizerinfoforadminController implements Initializable
{
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy"); // 3alashan a display el date bel format di
    @FXML
    public ComboBox <Event>combobox;
    @FXML
    public Button returnbutton;
    @FXML
    public Label label2;
    @FXML
    public Label label1;
    @FXML
    public Label label3;
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        combobox.getItems().addAll((Database.currentOrganizer).getOrganizerEvents());
        label1.setText(Database.currentOrganizer.getUsername());
        label2.setText(Database.currentOrganizer.getDateOfBirth().format(formatter));
        label3.setText(Database.currentOrganizer.getUsername());

    }
    
    @FXML
    public void comboboxhandler(ActionEvent e) throws Exception{
        Database.currentEvent = combobox.getSelectionModel().getSelectedItem();
        Utility.changeToScene(getClass(), e, "EventInfoOrganizerForAdmin.fxml");
    }
    
@FXML
    public void returnhandler(ActionEvent e) throws Exception
    {
        Utility.changeToScene(getClass(), e, "AdminDashboard.fxml");
    }
}