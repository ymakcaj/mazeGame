package main.game;

import main.GameObjects.Player;

import javax.swing.*;
import java.util.Scanner;

/*
 * A class to encapsulate the logic for all game states
 * 
 * The game starts from L1.
 * If the player completes L1, they move to L2. 
 * If the player fails at any point, the game ends. 
 * The player wins by completing both levels.
 */

 public class Game implements ProgressListener {

    static boolean isVisibilityMode = true;
    private JFrame jFrame;
    private GameMap gameMap;
    private Player player;
    private Display display;
    private LevelOne levelOne;
    private LevelTwo levelTwo;

    public Game() {
        init();
        setupWindowforKeyListener();
        startLevelOne();
    }

    /*
     * Starts the game by asking the player for the height and width of the maze.
     * The larger the maze, the more difficult.
     * <p>
     * The height and width must be at least 5 for the 5 game objects in L1.
     * Game objects will be scattered randomly, with no game objects in the same 
     * row/column - therefore 5/5 is the minimum size 
     */
    private void init() {
        Scanner s = new Scanner(System.in);
        int mazeHeight, mazeWidth;
        String newGame;
        do {
            System.out.println("Have you played this game before? Answer y for yes, and n for no.");
            while (!s.hasNext()) {
                System.out.println("That's not right! Try again: ");
                s.next();
            }
            newGame = s.next();
            break;
        } while ((!s.next().equals("y")) && (!s.next().equals("n")));


        do {
            System.out.println("Enter maze height (min 5): ");
            while (!s.hasNextInt()) {
                System.out.println("That's not a number! Enter again: ");
                s.next();
            }
            mazeHeight = s.nextInt();
        } while (mazeHeight < 5);
            do {
                System.out.println("Enter maze width (min 5): ");
                while (!s.hasNextInt()) {
                    System.out.println("That's not a number! Enter again: ");
                    s.next();
            }
            mazeWidth = s.nextInt();
        } while (mazeWidth < 5);

        gameMap = new GameMap(mazeHeight, mazeWidth);
        player = new Player(gameMap.getRandomPosition());
        display = new Display(gameMap.getMap(), player);

        
        if (newGame.equals("n")) {
            display.gameIntroMessage();
        } else {
            display.gameIntroMessageRepeat();
        }
        
    }

    /*
     * We create a window at the top left of the screen.
     * <p>
     * KeyEvents need JNI or GUI to be detected.
     * By setting up a small window and using the KeyListener in the window,
     * the player can control the movement by using the arrow keys.
     */
    private void setupWindowforKeyListener() {
        jFrame = new JFrame();
        jFrame.setVisible(true);
        jFrame.setSize(100,100);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /*
     * Initialises L1, setting up ProgressListener and KeyListener before starting
     */
    private void startLevelOne() {
        levelOne = new LevelOne(gameMap, player, display);
        levelOne.addProgressListener(this);
        jFrame.addKeyListener(levelOne);
        levelOne.start();
        }
    /**
     * Initialises L2, setting up ProgressListener and KeyListener before starting
     */
    private void startLevelTwo() {
        levelTwo = new LevelTwo(gameMap, player, display);
        levelTwo.setProgressListener(this);
        jFrame.addKeyListener(levelTwo);
        levelTwo.start();
    }

    @Override
    public void levelOneCompleted() {
        jFrame.removeKeyListener(levelOne);
        display.nextLevelMessage();
        startLevelTwo();
    }

    @Override
    public void levelTwoCompleted() {
        jFrame.removeKeyListener(levelTwo);
        display.winMessage();
        System.exit(0);
    }

    @Override
    public void levelFailed() {
        display.loseMessage();
        System.exit(0);
    }
}