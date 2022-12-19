package main.GameObjects;

/**
 * A class representing the 'torch' game object.
 */
public class Torch extends GameObject {

    static final int VISIBILITY_BOOST = 2;
    private static final char DEFAULT_ICON = '%';

    /**
     * @param position the {@link Position} of this game object
     */
    public Torch(Position position) {
        super(DEFAULT_ICON, position);
    }

}