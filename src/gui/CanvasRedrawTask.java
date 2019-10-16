package gui;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;

import java.util.function.BiConsumer;

public class CanvasRedrawTask extends AnimationTimer {
    private final GraphicsContext                   graphicsContext;
    private final BiConsumer<GraphicsContext, Long> onRedraw;

    public CanvasRedrawTask(GraphicsContext graphicsContext, BiConsumer<GraphicsContext, Long> onRedraw) {
        this.graphicsContext = graphicsContext;
        this.onRedraw = onRedraw;
    }

    @Override
    public void handle(long now) {
        onRedraw.accept(graphicsContext, now);
    }
}
