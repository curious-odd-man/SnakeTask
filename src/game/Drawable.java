package game;

import javafx.scene.canvas.GraphicsContext;

/**
 * Something that can be drawn on a Canvas
 */
public interface Drawable {

    void draw(GraphicsContext graphicsContext);
}
