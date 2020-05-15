package main.java.com.edp;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class welcomeController {
    @FXML
    private AnchorPane myAnchorPane;

    @FXML
    public void initialize() throws IOException {
        try {
            URL url = new URL("https://www.google.com/");
            URLConnection connection = url.openConnection();
            connection.connect();
            Platform.runLater(()->{
                Parent mainWindowParent = null;
                try {
                    mainWindowParent = FXMLLoader.load(getClass().getResource("mainWindow.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Scene mainWindowScene = new Scene(mainWindowParent);
            Stage window = (Stage) myAnchorPane.getScene().getWindow();
            window.close();
            Stage mainWindow = new Stage();
            mainWindow.setScene(mainWindowScene);
            mainWindow.show();});
        } catch (Exception e) {
            Platform.runLater(()->{
                Parent connectionFailedParent = null;
                try {
                    connectionFailedParent = FXMLLoader.load(getClass().getResource("connectionFailed.fxml"));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                Scene connectionFailedScene = new Scene(connectionFailedParent);
                Stage window = (Stage) myAnchorPane.getScene().getWindow();
                window.close();
                Stage retry=new Stage();
                retry.setResizable(false);
                retry.setScene(connectionFailedScene);
                retry.show();});
        }
    }

    public void exit(){
        Platform.exit();
        System.exit(0);
    }

}
