package main.java.com.edp;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class connectionFailedController {

    @FXML
    private AnchorPane myAnchorPane;

    public void checkConnection() throws IOException {
        try {
            URL url = new URL("https://www.google.com/");
            URLConnection connection = url.openConnection();
            connection.connect();
            Parent mainWindowParent = FXMLLoader.load(getClass().getResource("mainWindow.fxml"));
            Scene mainWindowScene = new Scene(mainWindowParent);
            Stage window = (Stage) myAnchorPane.getScene().getWindow();
            window.close();
            Stage mainWindow = new Stage();
            mainWindow.setScene(mainWindowScene);
            mainWindow.show();
        } catch (Exception e) {
            
        }
    }

    public void exit(){
        Platform.exit();
        System.exit(0);
    }
}
