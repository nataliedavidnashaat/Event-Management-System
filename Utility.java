package project;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Utility 
{
    // Change scene while preserving window size and position
    public static void changeToScene(Class<?> aClass, Event aEvent, String sceneFileStr) throws Exception
    {
        // Get current stage
        Stage stage = (Stage)((Node) aEvent.getSource()).getScene().getWindow();

        // Save current size and position
        double width = stage.getWidth();
        double height = stage.getHeight();
        double x = stage.getX();
        double y = stage.getY();

        // Load new scene
        Parent root = FXMLLoader.load(aClass.getResource(sceneFileStr));
        Scene scene = new Scene(root);

        // Set the new scene
        stage.setScene(scene);

        // Restore size and position
        stage.setWidth(width);
        stage.setHeight(height);
        stage.setX(x);
        stage.setY(y);

        stage.show();  
    }
}

