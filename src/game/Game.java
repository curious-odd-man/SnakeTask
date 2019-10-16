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

    /**
     * This is called when Start button is pressed
     *
     * @param event
     */
    public void start(ActionEvent event) {
        animationTimer.start();
        Log.debug();
    }

    /**
     * This is called when pause buttons is called
     *
     * @param event
     */
    public void pause(ActionEvent event) {
        animationTimer.stop();
        Log.debug();
    }

    /**
     * This is called when mouse button is pressed on a Canvas
     *
     * @param mouseEvent
     */
    public void mousePressed(MouseEvent mouseEvent) {
        Log.debug("Pressed at " + mouseEvent.getX() + ':' + mouseEvent.getY());
    }

    /**
     * This is called when mouse button is released on a Canvas
     *
     * @param mouseEvent
     */
    public void mouseReleased(MouseEvent mouseEvent) {
        Log.debug("Released at " + mouseEvent.getX() + ':' + mouseEvent.getY());
    }

    /**
     * This is called every time images is renewed on the Canvas.
     *
     * @param graphicsContext - use this to draw something
     * @param now             - use this to measure how much time has passed from previous frame drawing (if needed)
     */
    public void onRedraw(GraphicsContext graphicsContext, Long now) {
        graphicsContext.setFill(Color.WHITE);
        graphicsContext.fillRect(0, 0, getWidth(), getHeight());
    }

    /**
     * Setter for animation timer
     *
     * @param animationTimer
     */
    public void setAnimationTimer(CanvasRedrawTask animationTimer) {
        this.animationTimer = animationTimer;
    }
}
