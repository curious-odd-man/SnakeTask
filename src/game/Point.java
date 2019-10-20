package game;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class Point {
    public static int SIZE = 10;

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Point random(int pxWidth, int pxHeight) {
        int maxX = pxWidth / SIZE;
        int maxY = pxHeight / SIZE;
        int x = ThreadLocalRandom.current()
                                 .nextInt(maxX);
        int y = ThreadLocalRandom.current()
                                 .nextInt(maxY);
        return new Point(x, y);
    }

    public static Point middle() {
        return new Point(Game.getWidth() / SIZE / 2,
                         Game.getHeight() / SIZE / 2);
    }

    public int getPixelX() {
        return x * SIZE;
    }

    public int getPixelY() {
        return y * SIZE;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
