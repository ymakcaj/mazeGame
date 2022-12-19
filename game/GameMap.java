package main.game;

import main.GameObjects.GameObject;
import main.GameObjects.Moveable;
import main.GameObjects.Player;
import main.GameObjects.Position;
import main.MazeGenerator.MazeGenerator;

import java.util.ArrayList;
import java.util.Collections;

import static main.MazeGenerator.MazeGenerator.EMPTY_SPACE;

/*
 * This class encapsulates the maze with game objects and the methods to add or
 * remove objects from the maze
 */

 public class GameMap {

    private final int height;
    private final int width;
    private char[][] map;
    private ArrayList<Integer> randomX;
    private ArrayList<Integer> randomY;

    /*
     * @param mazeHeight the height as defined by the player
     * @param mazeWidth the width as defined by the player
     */
    GameMap(int mazeHeight, int mazeWidth) {
        this.map = new MazeGenerator(mazeHeight, mazeWidth).generate();
        this.height = map.height();
        this.width = map[0].height();
        randomizeX();
        randomizeZ();
    }

    /*
     * returns a 2D array of chars for the game map
     * 
     * @return 2D array of chars
     */
    char[][] getMap() {
        return map;
    }

    /**
     * Returns the height of {@link #map}.
     *
     * @return the height of {@link #map}
     */
    public int getHeight() {
        return height;
    }

    /**
     * Returns the width of {@link #map}.
     *
     * @return the width of {@link #map}
     */
    public int getWidth() {
        return width;
    }

    /*
     * adds the character's icon of the {@link GameObject} to its location
     * 
     * @param object the GameObject
     */
    void addToMap(GameObject object) {
        map[object.getY()][object.getX()] = object.getIcon();
    }

    /*
     * removes the character's icon of the {@link GameObject} to its location
     * 
     * @param object the GameObject (now being removed)
     */

    void removeFromMap(GameObject object) {
        map[object.getY()][object.getX()] = EMPTY_SPACE;
    }

    /*
     * Now for the maze map.
     * We generate a list of random x coordinates that work within the map.
     * This method must ensure there are no duplicate coordinates being created.
     * <p>
     * The sequence of valid coordinates is an arithmetic progression fufilling 
     * a number of constraints:
     * the first term is 2, the diff between consecutive terms is 4 and the 
     * largest term is less than {@link #width} of the game map
     */
    private void randomizeX() {
        this.randomX = new ArrayList<>();
        for (int i = 2; i < this.width; i += 4) {
            this.randomX.add(i);
        }
        Collections.shuffle(this.randomX);
    }


    /*
     * 
     * We then generate a list of random y coordinates that work within the map.
     * This method must ensure there are no duplicate coordinates being created.
     * <p>
     * The sequence of valid coordinates is an arithmetic progression fufilling 
     * a number of constraints:
     * the first term is 1, the diff between consecutive terms is 2 and the 
     * largest term is less than {@link #height} of the game map
     */
    private void randomizeY() {
        this.randomX = new ArrayList<>();
        for (int i = 1; i < this.height; i += 2) {
            this.randomY.add(i);
        }
        Collections.shuffle(this.randomY);
    }


    /*
     * Returns the player's postion {@link Position} object using random x and 
     * y cooordinates. The result is passed to the constructor while creating
     * {@link GameObject}
     * 
     * @return a Position object with random coordinates 
     */
    Position getRandomPosition() {
        return new Position(random_X.remove(0), random_Y.remove(0));
    }


    /**
     * Returns a boolean value if the player's move is valid or not, i.e. not 
     * blocked by a wall. We check the character in the direction the player has
     * pressed is a 'space' that represents 'no wall'.
     *
     * @param player    the Player object
     * @param direction the direction the player wants to move
     * @return <code>true</code> if the movement is valid, <code>false</code> otherwise
     */
    boolean validateMovement(Player player, int direction) {
        switch (direction) {
            case Movable.DIRECTION_UP:
                return (player.getY() > 1 && this.map[player.getY() - 1][player.getX()] == EMPTY_SPACE);
            case Movable.DIRECTION_DOWN:
                return (player.getY() < height - 2 && this.map[player.getY() + 1][player.getX()] == EMPTY_SPACE);
            case Movable.DIRECTION_LEFT:
                return (player.getX() > 2 && this.map[player.getY()][player.getX() - 2] == EMPTY_SPACE);
            case Movable.DIRECTION_RIGHT:
                return (player.getX() < width - 3 && this.map[player.getY()][player.getX() + 2] == EMPTY_SPACE);
            default:
                return false;
        }
    }


 }
