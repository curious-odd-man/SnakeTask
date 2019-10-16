package game;

import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;

public class Game {
    public Game() {
        Log.On();
    }

    public long getWidth() {
        return 500;
    }

    public long getHeight() {
        return 300;
    }

    public void start(ActionEvent event) {
        Log.debug();
    }

    public void pause(ActionEvent event) {
        Log.debug();
    }

    public void mousePressed(MouseEvent mouseEvent) {
        Log.debug("Pressed at " + mouseEvent.getX() + ':' + mouseEvent.getY());
    }

    public void mouseReleased(MouseEvent mouseEvent) {
        Log.debug("Released at " + mouseEvent.getX() + ':' + mouseEvent.getY());
    }
}
