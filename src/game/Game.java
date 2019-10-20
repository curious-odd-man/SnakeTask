package game;

import javafx.event.ActionEvent;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.util.function.Consumer;

public class Game {
    private final Consumer<Long> aSetScore;

    private Food apple;
    private Mouse mouse;
    private Thread mouseThread;
    private Mouse crazyMouse;
    private Thread crazyMouseThread;

    public Game(Consumer<Long> setScore) {
        Log.On();
        aSetScore = setScore;
    }

    /**
     * Update score on the screen
     *
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
    public static int getWidth() {
        return 1000;
    }

    /**
     * Height of the field
     *
     * @return height in pixels
     */
    public static int getHeight() {
        return 500;
    }

    /**
     * This is called when Start button is pressed
     *
     * @param event
     */
    public void start(ActionEvent event) {
        Log.debug();
        Point p = Point.random(getWidth(), getHeight());
        apple = new Apple(p);
        Point p1 = Point.random(getWidth(), getHeight());
        mouse = new Mouse(p1);
        mouseThread = new Thread(mouse);
        mouseThread.start();
        Point p3 = Point.random(getWidth(), getHeight());
        crazyMouse = new Mouse(p3, 5);
        crazyMouseThread = new Thread(crazyMouse);
        crazyMouseThread.start();
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

        if (apple != null) {
            apple.draw(graphicsContext);
        }

        if (mouse != null) {
            mouse.draw(graphicsContext);
        }

        if (crazyMouse != null) {
            crazyMouse.draw(graphicsContext);
        }
    }
}
