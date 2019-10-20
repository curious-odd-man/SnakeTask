package game;

import javafx.scene.paint.Color;

public class Apple extends Food {
    private static final int   SCORE_INCREMENT = 10;
    private static final int   SNAKE_INCREMENT = 1;
    private static final Color COLOR           = Color.RED;

    public Apple(Point point) {
        super(point, SCORE_INCREMENT, SNAKE_INCREMENT, COLOR);
    }
}
