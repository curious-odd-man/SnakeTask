package game;

import javafx.event.ActionEvent;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.util.function.Consumer;

public class Game {
    private final Consumer<Long> aSetScore;

    public Game(Consumer<Long> setScore) {
        Log.On();
        aSetScore = setScore;
    }

    /**
     * Update score on the screen
     * @param score new score
     */
    public void setScore(long score) {
        aSetScore.accept(score);
    }

    /**
     * Width of the field
     *
     * @return width in pixels
     */
    public static long getWidth() {
        return 500;
    }

    /**
     * Height of the field
     *
     * @return height in pixels
     */
    public static long getHeight() {
        return 300;
    }

    /**
     * This is called when Start button is pressed
     *
     * @param event
     */
    public void start(ActionEvent event) {
        Log.debug();
    }

    /**
     * This is called when pause buttons is pressed
     *
     * @param event
     */
    public void pause(ActionEvent event) {
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
}
