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

    /**
     * Returns <code>true</code> if this Player object's {@link #energyLevel} is less than or equals to zero.
     *
     * @return <code>true</code> if {@link #energyLevel} is less than or equals to zero, <code>false</code> otherwise
     */
    public boolean isAsleep() {
        return energyLevel <= 0;
    }

    /**
     * Returns <code>true</code> if the player has reached a torch yet
     *
     * @return <code>true</code> if the player has torch, <code>false</code> otherwise
     */
    public boolean hasTorch() {
        return hasTorch;
    }

    /**
     * Sets {@link #hasTorch} to <code>true</code> and increase this Player's' {@link #visibility}.
     */
    public void foundTorch() {
        hasTorch = true;
        visibility += Torch.VISIBILITY_BOOST;
    }

    /**
     * Changes this Player object's Position based on the specified direction
     *
     * @param direction the direction to move in integer
     */
    @Override
    public void move(int direction) {
        switch (direction) {
            case DIRECTION_UP:
                this.setY(this.getY() - 2);
                break;
            case DIRECTION_DOWN:
                this.setY(this.getY() + 2);
                break;
            case DIRECTION_LEFT:
                this.setX(this.getX() - 4);
                break;
            case DIRECTION_RIGHT:
                this.setX(this.getX() + 4);
                break;
            default:
                break;
        }
    }


}
