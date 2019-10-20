package game;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Food implements Drawable {
    private Point point;
    private int   score;
    private int   snakeIncrement;
    private Color color;

    public Food(Point point, int score, int snakeIncrement, Color color) {
        this.point = point;
        this.score = score;
        this.snakeIncrement = snakeIncrement;
        this.color = color;
    }

    public Point getPoint() {
        return point;
    }

    public int getScore() {
        return score;
    }

    public int getSnakeIncrement() {
        return snakeIncrement;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.setFill(color);
        graphicsContext.fillRect(point.getPixelX(), point.getPixelY(), Point.SIZE, Point.SIZE);
    }
}
