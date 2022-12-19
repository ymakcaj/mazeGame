package main.GameObjects;

import java.awt.event.KeyEvent;

/**
 * This interface is implemented by any {@link GameObject}
 * A Movable is a GameObject that can change its {@link Position}
 * The move method is invoked to change the {@link Position} of the Movable.
 */
public interface Movable {
    int DIRECTION_UP = KeyEvent.VK_UP;
    int DIRECTION_DOWN = KeyEvent.VK_DOWN;
    int DIRECTION_LEFT = KeyEvent.VK_LEFT;
    int DIRECTION_RIGHT = KeyEvent.VK_RIGHT;

    /**
     * Invoked when the Position of the GameObject has to be changed.
     *
     * @param direction the direction to move in integer
     */
    void move(int direction);
}
