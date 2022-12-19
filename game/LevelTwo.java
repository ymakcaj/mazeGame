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

 }