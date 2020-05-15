package main.java.com.edp;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import javafx.scene.control.SelectionMode;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class mainWindowController {

    @FXML
    private ListView <diseaseItem> diseaseListView;

    @FXML
    private WebView diseaseWebView;

    @FXML
    MenuBar myMenuBar;

    public void initialize()
    {
        List<diseaseItem> diseaseItems = new ArrayList<diseaseItem>();
        Document doc = null;
        try {
            doc = Jsoup.connect("https://www.who.int/emergencies/diseases/en/").get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Element div : doc.select("div.module"))
            if (div.select("h2").text().equals("Pandemic, epidemic diseases"))
                for (Element a : div.select("a")) {
                    String DiseaseName = a.text();
                    String DiseaseURL = a.attr("abs:href");
                    diseaseItem item = new diseaseItem(DiseaseName, DiseaseURL);
                    diseaseItems.add(item);
                }
        diseaseListView.getItems().setAll(diseaseItems);
        diseaseListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }

    @FXML
    public void handleClickListView() {
        diseaseItem item = diseaseListView.getSelectionModel().getSelectedItem();
        WebEngine engine;
        engine = diseaseWebView.getEngine();
        engine.load(item.getDiseaseURL());
    }

    public void menuOpenWHO() throws IOException {
        Parent openWHOParent = FXMLLoader.load(getClass().getResource("WHOWindow.fxml"));
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
