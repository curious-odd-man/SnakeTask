package game;

import javafx.scene.paint.Color;

public class Mouse extends Food implements Runnable {
    private static final int   CRAZY_SCORE_INCREMENT = 30;
    private static final int   CRAZY_SNAKE_INCREMENT = 3;
    private static final Color CRAZY_COLOR           = Color.BROWN;

    private static final int   MOUSE_SCORE_INCREMENT = 20;
    private static final int   MOUSE_SNAKE_INCREMENT = 2;
    private static final Color MOUSE_COLOR           = Color.GRAY;

    private final int stepsBeforeChangeDirection;
    private final int delay;

    private Direction direction;

    private Mouse(Point point, int stepsBeforeChangeDirection, int delay, int score, int snakeIncrement, Color color) {
        super(point, score, snakeIncrement, color);
        direction = Direction.random();
        this.stepsBeforeChangeDirection = stepsBeforeChangeDirection;
        this.delay = delay;
    }

    public Mouse(Point point) {
        this(point, 0, 500, MOUSE_SCORE_INCREMENT, MOUSE_SNAKE_INCREMENT, MOUSE_COLOR);
    }

    public Mouse(Point point, int stepsBeforeChangeDirection) {
        this(point, stepsBeforeChangeDirection, 400, CRAZY_SCORE_INCREMENT, CRAZY_SNAKE_INCREMENT, CRAZY_COLOR);
    }

    @Override
    public void run() {
        int i = 0;
        while (getPoint().getX() > 0
                && getPoint().getY() > 0
                && getPoint().getPixelX() < Game.getWidth() - Point.SIZE
                && getPoint().getPixelY() < Game.getHeight() - Point.SIZE) {

            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                break;
            }

            if (stepsBeforeChangeDirection != 0) {
                i = ++i % stepsBeforeChangeDirection;
                if (i == 0) {
                    direction = Direction.random();
                }
            }

            getPoint().setX(getPoint().getX() + direction.getX());
            getPoint().setY(getPoint().getY() + direction.getY());
        }
    }

    public void kill() {
        getPoint().setX(-1000);
    }
}
