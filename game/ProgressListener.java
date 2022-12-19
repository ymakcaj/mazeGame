package main.game;

/*
 * This interface is for receving progress feedback - the class 
 * processing a player's progress must implement this class. 
 * 
 * Progress feedback is generated when a player completes or fails a level. 
 */

 public interface ProgressListener {

    /**
     * Invoked when level one is finished.
     * See the class description of {@link LevelOne} for the level completion details.
     */
    void levelOneCompleted();

    /**
     * Invoked when level two is finished.
     * See the class description of {@link LevelTwo} for the level completion details.
     */
    void levelTwoCompleted();

    /**
     * Invoked when the Player is asleep to end the game.
     */
    void levelFailed();
}
