package main.game;

import main.GameObjects.Key;
import main.GameObjects.Player;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static main.MazeGenerator.*;

/**
 * as per kphilemon's (https://github.com/kphilemon/maze-runner.git)
 * app, this is a class encapsulating all the methods required for 
 * printing in the console.
 */

class Display {

    private static final char FOG = '#';
    private final char[][] map;
    private final Player player;
    private final int height;
    private final int width;

    /*
     * @param map - 2d char array making up the maze
     * @param player - the Player object
     */

    Display(char[][] map, Player player) {
        this.map = map;
        this.height = map.length;
        this.width = map[0].length;
        this.player = player;
    }
    
}
