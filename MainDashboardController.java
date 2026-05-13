/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nana
 */
public class MainDashboardController implements Initializable {

    @FXML
    private Button registerNewAccountButton;
    @FXML
    private Button loginInButton;
    @FXML
    private Button exitButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void registerNewAccountButtonHandler(ActionEvent event) throws Exception
    {
        Utility.changeToScene(getClass(), event, "Register.fxml");
    }

    @FXML
    private void loginInButtonHandler(ActionEvent event) throws Exception
    {
        Utility.changeToScene(getClass(), event, "Login.fxml");
    }

    @FXML
    private void exitButtonHandler(ActionEvent event) throws IOException
    {
         
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

}
