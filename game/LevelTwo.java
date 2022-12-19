package main.game;

import main.GameObjects.Exit;
import main.GameObjects.Player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * A class encapsulating the game logic of level two.
 * <p>
 * Level details:
 * <ul>
 * <li>Mission: find the exit to win the game</li>
 * <li>Energy level of the player will decrease by 5 every second.
 * Game Over when the energy level of the player is less than or equals zero.''
 */

 public class LevelTwo implements KeyListener {

    private final GameMap gameMap;
    private final Player player;
    private final Display display;
    private ProgressListener progressListener;
    private Exit exit;
    private boolean hasFoundExit = false;

    /**
     * @param gameMap the {@link GameMap} object
     * @param player  the {@link Player} object
     * @param display the {@link Display} object
     */
    LevelTwo(GameMap gameMap, Player player, Display display) {
        this.gameMap = gameMap;
        this.player = player;
        this.display = display;
        init();
    }

    
    /**
     * Adds the progress listener.
     *
     * @param progressListener the progress listener
     */
    void setProgressListener(ProgressListener progressListener) {
        this.progressListener = progressListener;
    }


    /**
     * Initializes L2 by adding game objects to the game map.
     */
    private void init() {
        // init game objects
        gameMap.addToMap(player);

        exit = new Exit(Exit.generateExitPosition(gameMap, player));
        gameMap.addToMap(exit);

        display.update();
    }

    /**
     * Starts the game loop of level two.
     */
    void start() {
        while (true) {
            if (player.isAsleep()) {
                progressListener.levelFailed();
                break;
            }
            if (hasFoundExit) {
                progressListener.levelTwoCompleted();
                break;
            }
            player.reduceEnergyLevelBy(5);
            display.update();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Updates the game stats if player has reached the exit.
     */
    private void checkIfPlayerHasFoundExit() {
        if (player.getPosition().equals(exit.getPosition()))
            hasFoundExit = true;
    }


    /**
     * Invoked when a key has been pressed.
     * <p>
     * If the arrow keys are pressed, the movement is validated first.
     * If the direction of movement is valid (not blocked by any walls), the player icon at the
     * position before moving is first removed from the game map. The player icon is added back
     * to the game map at the new position after moving. The energy level of the player is reduced
     * by 5 every second.
     * <p>
     * The F6 key is used for debugging purposes to reveal the map even the map is previously covered.
     * This is the hidden easter egg
     *
     * @param e the KeyEvent
     */
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_RIGHT:
                final int DIRECTION = e.getKeyCode();
                if (gameMap.validateMovement(player, DIRECTION)) {

 }