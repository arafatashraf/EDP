package main.java.com.edp;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.IOException;

public class openWHOWindowController {

    @FXML
    WebView webView;

    @FXML
    MenuBar myMenuBar;

    @FXML
    public void initialize(){
        WebEngine engine;
        engine = webView.getEngine();
        String html = "https://www.who.int/";
        engine.load(html);
    }

    public void menuOpenMainWindow() throws IOException {
        Parent openWHOParent = FXMLLoader.load(getClass().getResource("mainWindow.fxml"));
        Scene openWHOScene = new Scene(openWHOParent);
        Stage window = (Stage) myMenuBar.getScene().getWindow();
        window.setScene(openWHOScene);
        window.show();
    }


    public void menuExit() {
        Platform.exit();
        System.exit(0);
    }

}