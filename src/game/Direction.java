package game;

import java.util.concurrent.ThreadLocalRandom;

public enum Direction {
    UP(0, -1),          // 0
    RIGHT(1, 0),        // 1
    DOWN(0, 1),         // 2
    LEFT(-1, 0),        // 3

    UP_LEFT(-1, -1),
    UP_RIGHT(1, -1),
    DOWN_LEFT(-1, 1),
    DOWN_RIGHT(1, 1);

    public static Direction random() {
        int directionIndex = ThreadLocalRandom.current()
                                              .nextInt(values().length);
        return values()[directionIndex];
    }

    public Direction left() {
        int idx = ordinal();
        int takeIndex = (4 + idx - 1) % 4;
        return values()[takeIndex];
    }

    public Direction right() {
        int idx = ordinal();
        return values()[(idx + 1) % 4];
    }

    private final int aX;
    private final int aY;

    Direction(int x, int y) {
        aX = x;
        aY = y;
    }

    public int getX() {
        return aX;
    }

    public int getY() {
        return aY;
    }
}
