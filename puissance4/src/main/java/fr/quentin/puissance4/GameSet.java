package fr.quentin.puissance4;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

public class GameSet implements Initializable {

    @FXML
    private ToggleButton btnHumanVsHuman;
    @FXML
    private ToggleButton btnHumanVsAI;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ToggleGroup group = new ToggleGroup();
        btnHumanVsHuman.setToggleGroup(group);
        btnHumanVsAI.setToggleGroup(group);
    }

    @FXML
    public void onModeSelected(ActionEvent event) {
        // pour l'instant laisse vide
    }

    @FXML
    public void onConfirm(ActionEvent event) throws IOException {
        if (btnHumanVsHuman.isSelected()) {
            GameView.setRoot("playersetup_hvh");
        } else if (btnHumanVsAI.isSelected()) {
            GameView.setRoot("playersetup_hvai");
        }
    }

}