package fr.quentin.puissance4;

import javafx.scene.control.Button;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.shape.Circle;
import javafx.scene.layout.GridPane;



public class GameController implements Initializable {
	@FXML
	private GridPane boardGrid;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	
    	// arrows
    	for (int col = 0; col < 7; col++) {
    	    Button arrow = new Button("▼");
    	    arrow.getStyleClass().add("arrow-button");
    	    final int c = col;
    	    arrow.setOnAction(e -> onColumnClick(c));
    	    boardGrid.add(arrow, col, 0);
    	}

    	for (int row = 0; row < 6; row++) {
    	    for (int col = 0; col < 7; col++) {
    	        Circle circle = new Circle(40);
    	        circle.getStyleClass().add("token-empty");
    	        boardGrid.add(circle, col, row + 1);
    	    }
    	}
    }

    @FXML
    public void onColumnClick(int col) {

    }
}