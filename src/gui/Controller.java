package gui;

import game.Game;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class Controller {

    private Game             game;
    private CanvasRedrawTask animationTimer;

    @FXML
    Button startButton;

    @FXML
    Button pauseButton;

    @FXML
    Canvas canvas;

    @FXML
    Label scoreLabel;

    @FXML
    public void initialize() {
        canvas.setWidth(Game.getWidth());
        canvas.setHeight(Game.getHeight());
        GraphicsContext graphicsContext2D = canvas.getGraphicsContext2D();
        game = new Game(this::setScore);
        animationTimer = new CanvasRedrawTask(graphicsContext2D, game::onRedraw);
        graphicsContext2D.setFill(Color.WHITE);
        graphicsContext2D.setStroke(Color.GREEN);
        graphicsContext2D.fillRect(0, 0, Game.getWidth(), Game.getHeight());

        startButton.setOnAction(v -> {
            game.start(v);
            animationTimer.start();
        });
        pauseButton.setOnAction(v -> {
            animationTimer.stop();
            game.pause(v);
        });
        canvas.setOnMousePressed(game::mousePressed);
        canvas.setOnMouseReleased(game::mouseReleased);
    }

    private void setScore(long score) {
        Platform.runLater(() -> scoreLabel.setText(String.valueOf(score)));
    }
}
