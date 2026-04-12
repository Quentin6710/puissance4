package fr.quentin.puissance4;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class PlayerSetupHvAI implements Initializable {

    @FXML
    private TextField p1Name;
    @FXML
    private ComboBox<String> aiDifficulty;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        aiDifficulty.setItems(FXCollections.observableArrayList("Easy", "Hard"));
        aiDifficulty.getSelectionModel().selectFirst();
    }

    @FXML
    public void onBack(ActionEvent event) throws IOException {
        GameView.setRoot("gameset");
    }

    @FXML
    public void onPlay(ActionEvent event) throws IOException {
    	GameView.setRoot("game");
    }

}