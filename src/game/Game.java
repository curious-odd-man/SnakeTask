package game;

import gui.CanvasRedrawTask;
import javafx.event.ActionEvent;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class Game {
    private CanvasRedrawTask animationTimer;

    public Game() {
        Log.On();
    }

    public static long getWidth() {
        return 500;
    }

    public static long getHeight() {
        return 300;
    }

    public void start(ActionEvent event) {
        animationTimer.start();
        Log.debug();
    }

    public void pause(ActionEvent event) {
        animationTimer.stop();
        Log.debug();
    }

    public void mousePressed(MouseEvent mouseEvent) {
        Log.debug("Pressed at " + mouseEvent.getX() + ':' + mouseEvent.getY());
    }

    public void mouseReleased(MouseEvent mouseEvent) {
        Log.debug("Released at " + mouseEvent.getX() + ':' + mouseEvent.getY());
    }

    public void onRedraw(GraphicsContext graphicsContext, Long now) {
        graphicsContext.setFill(Color.WHITE);
        graphicsContext.fillRect(0, 0, getWidth(), getHeight());
    }

    public void setAnimationTimer(CanvasRedrawTask animationTimer) {
        this.animationTimer = animationTimer;
    }
}
