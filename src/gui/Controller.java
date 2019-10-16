package gui;

import game.Game;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

public class Controller {

    private Game game = new Game();

    @FXML
    Button startButton;

    @FXML
    Button pauseButton;

    @FXML
    Canvas canvas;

    public void initialize() {
        startButton.setOnAction(game::start);
        pauseButton.setOnAction(game::pause);
        canvas.setWidth(game.getWidth());
        canvas.setHeight(game.getHeight());
        canvas.setOnMousePressed(game::mousePressed);
        canvas.setOnMouseReleased(game::mouseReleased);

        GraphicsContext graphicsContext2D = canvas.getGraphicsContext2D();
        graphicsContext2D.setFill(Color.WHITE);
        graphicsContext2D.setStroke(Color.GREEN);
        graphicsContext2D.fillRect(0, 0, game.getWidth(), game.getHeight());
    }
}
