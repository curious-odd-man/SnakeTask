package game;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.function.Consumer;

public class Snake implements Drawable, Runnable {
    private ArrayList<Point> points;
    private Direction        direction;
    private Consumer<Point>  onMove;
    private int              snakeIncrement = 0;

    public Snake(Consumer<Point> onMove) {
        points = new ArrayList<>(3);
        Point head = Point.middle();
        points.add(head);
        for (int i = 1; i < 3; i++) {
            points.add(new Point(head.getX() + i, head.getY()));
        }

        direction = Direction.LEFT;
        this.onMove = onMove;
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.setFill(Color.BLACK);
        for (Point point : points) {
            graphicsContext.fillRect(point.getPixelX(), point.getPixelY(),
                                     Point.SIZE, Point.SIZE);
        }
    }

    public void turnLeft() {
        direction = direction.left();
    }

    public void turnRight() {
        direction = direction.right();
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                break;
            }

            Point head = points.get(0);

            Point newHead;

            if (snakeIncrement == 0) {
                newHead = points.remove(points.size() - 1);
                newHead.setX(head.getX() + direction.getX());
                newHead.setY(head.getY() + direction.getY());
            } else {
                --snakeIncrement;
                newHead = new Point(head.getX() + direction.getX(), head.getY() + direction.getY());
            }
            points.add(0, newHead);
            onMove.accept(newHead);
        }
    }

    public void grow(int snakeIncrement) {
        this.snakeIncrement += snakeIncrement;
    }
}
