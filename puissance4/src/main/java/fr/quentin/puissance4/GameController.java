package fr.quentin.puissance4;

import javafx.scene.control.Button;

import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.shape.Circle;
import javafx.scene.layout.GridPane;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;



public class GameController implements Initializable {
	@FXML
	private GridPane boardGrid;
	
	@FXML
	private Button btnPlay;
	
	@FXML
	private Button btnRestart;
	
	@FXML
	private Label lblHeader;
	@FXML
	private Label lblStatus;
	private Game game;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	btnPlay.setOpacity(0);
    	this.game = new Game();
    	game.start(GameSession.player1.getName(), GameSession.player1.getColor(), GameSession.player1.IsAi(), GameSession.player2.getName(), GameSession.player2.getColor(), GameSession.player2.IsAi());
    	lblHeader.setText(GameSession.player1.getName() + " vs " + GameSession.player2.getName());
    	lblStatus.setText(game.getCurrentPlayer().getName()+"'s turn");
    	

    	// arrows
    	for (int col = 0; col < 7; col++) {
    	    Button arrow = new Button("▼");
    	    arrow.getStyleClass().add("arrow-button");
    	    final int c = col;
    	    arrow.setOnAction(e -> {
				try {
					onColumnClick(c);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
    	    boardGrid.add(arrow, col, 0);
    	}

    	for (int row = 0; row < 6; row++) {
    	    for (int col = 0; col < 7; col++) {
    	        Circle circle = new Circle(40);
    	        circle.getStyleClass().add("token-empty");
    	        boardGrid.add(circle, col, row + 1);
    	    }
    	}
    	
    	btnPlay.setOnAction(e -> onPlayClick());
    	btnRestart.setOnAction(e -> onMenuClick());
    }

    @FXML
    public void onColumnClick(int col) throws InterruptedException {
    	int row = this.game.getBoard().getRowToPlace(col);
    	try {
			this.game.playMove(this.game.getCurrentPlayer(), col);
		} catch (InvalidMoveException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    	
    	// puts a circle in the right position
    	for (javafx.scene.Node node : boardGrid.getChildren()) {
    	    if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row+ 1) {
    	        node.getStyleClass().clear();
    	        if (this.game.getCurrentPlayer().getColor().equals("red")) {
    	        	node.getStyleClass().add("token-player1");
    	        }else {	
    	        	 node.getStyleClass().add("token-player2");
    	        }
    	       
    	        break;
    	    }
    	}
    	lblStatus.setText(game.getCurrentPlayer().getName()+"'s turn");
    	
    	
    	if(game.isOver()) {
    		lblHeader.setText(game.getCurrentPlayer().getName()+" WON !  With "+game.getCurrentPlayer().getNbPlay()+" plays" );
    		for (javafx.scene.Node node : boardGrid.getChildren()) {
    		    if (node instanceof Button) {
    		        node.setDisable(true);
    		    }
    		}
    	    blink.setCycleCount(Timeline.INDEFINITE);
    	    blink.play();
    	}
    	
    }
    public void onMenuClick() {
    	game.reset();
    	boardGrid.getChildren().clear();
		initialize(null, null);
		btnPlay.setOpacity(0);
		try {
			GameView.setRoot("gameset");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void onPlayClick() {
    	game.reset();
    	boardGrid.getChildren().clear();
		initialize(null, null);
		btnPlay.setOpacity(0);
    }
    
    Timeline blink = new Timeline(
    	    new KeyFrame(Duration.seconds(0), e -> btnPlay.setOpacity(1.0)),
    	    new KeyFrame(Duration.seconds(0.75), e -> btnPlay.setOpacity(0.2)),
    	    new KeyFrame(Duration.seconds(1.5), e -> btnPlay.setOpacity(1.0)));
    

}