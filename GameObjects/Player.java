package main.GameObjects;

/**
 * A class representing the player
 *
 */
public class Player extends GameObject implements Movable {

    public static final int INITIAL_ENERGY_LEVEL = 250;
    private static final char DEFAULT_ICON = 'P';
    private static final int INITIAL_VISIBILITY = 2;
    private int visibility;
    private int energyLevel;
    private boolean hasTorch;

        /**
     * @param position the {@link Position} of this game object
     */
    public Player(Position position) {
        super(DEFAULT_ICON, position);
        this.visibility = INITIAL_VISIBILITY;
        this.energyLevel = INITIAL_ENERGY_LEVEL;
        this.hasTorch = false;
    }

    /**
     * Returns the {@link #visibility} of the Player
     *
     * @return the {@link #visibility} of this Player 
     */
    public int getVisibility() {
        return visibility;
    }

    /**
     * Returns the {@link #energyLevel} of this Player object.
     *
     * @return the {@link #energyLevel} of this Player object
     */
    public int getEnergyLevel() {
        return energyLevel;
    }

    /**
     * Reduces the {@link #energyLevel} of this Player object.
     *
     * @param value the value to be reduced
     */
    public void reduceEnergyLevelBy(int value) {
        energyLevel -= value;
    }
}
