package main.GameObjects;

import main.game.GameMap;

public class Exit extends GameObject{

    private static final char DEFAULT_ICON = 'E';

    /**
     * @param position the {@link Position} of the game object
     */
    public Exit(Position position) {
        super(DEFAULT_ICON, position);
    }

    /**
     * Returns a {@link Position} object which is in a quadrant that is opposite to the
     * specified Player's quadrant in the maze.
     *
     * @param gameMap the {@link GameMap} of this game
     * @param player  the {@link Player} of this game
     * @return a {@link Position} in an opposite quadrant
     */
}
