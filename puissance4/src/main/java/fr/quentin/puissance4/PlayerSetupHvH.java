package fr.quentin.puissance4;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class PlayerSetupHvH implements Initializable {

    @FXML
    private TextField p1Name;
    @FXML
    private TextField p2Name;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    public void onBack(ActionEvent event) throws IOException {
        GameView.setRoot("gameset");
    }

    @FXML
    public void onPlay(ActionEvent event) throws IOException {
    	if (!p1Name.getText().isEmpty() && !p2Name.getText().isEmpty()) {
    		GameSession.player1 = new Player(p1Name.getText(), "red", false);
    		GameSession.player2 = new Player(p2Name.getText(), "yellow", false);
        	GameView.setRoot("game");
    	}

    }

}