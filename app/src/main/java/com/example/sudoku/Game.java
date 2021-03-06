package com.example.sudoku;

import java.io.Serializable;
import java.util.Random;

public class Game implements Serializable {

    private final double gameId = Math.random();

    /** The difficulty of the game. */
    public int difficulty;

    /** The life number a player has. */
    public int life = Constant.LIFE_NUM;

    /** This is the answer to the puzzle. */
    public GameGrid answerGrid;

    /** The initial state of the game, will change as the user plays. */
    public GameGrid puzzleGrid;

    /** The initial state of the game, will remain unchanged. */
    public GameGrid initialGrid;

    /** pointer that stored [int row, int col] pair. */
    public int[] pointer = new int[2];

    /**
     * A class to represent timer.
     * Functions that a timer should have:
     * 1. Start/Continue
     * 2. Stop/End
     * 3. Reset
     */
    public class Timer implements Serializable{

        /** Amount of time in ms recorded by Timer. */
        private long time;

        /** Start time of the timer. */
        private long start;

        /** End time of the timer. */
        private long end;

        /** Whether the timer is running. */
        public boolean isRunning;

        /** Start a timer. */
        public void start() {
            this.start = System.currentTimeMillis();
            isRunning = true;
        }

        /** Pause a timer. */
        public void pause() {
            this.end = System.currentTimeMillis();
            this.time += end - start;
            isRunning = false;
        }

        /** Reset a timer. */
        public void reset() {
            this.time = 0;
        }

        /**
         * Fetch timer's time.
         * @return time recorded
         */
        public long getTime() {
            return isRunning? time + (System.currentTimeMillis() - start) : time;
        }

    }

    /** Timer for the game. */
    public Timer timer;

    /**
     * Constructing a game object with the given difficulty.
     * @param difficulty difficulty of the game
     */
    public Game(int difficulty) {
        try {
            // Store the generated Sudoku grid as a 2-D array of char
            char[][] charGrid = new RandomGen(4, Constant.TOKENS).getPaper();
            // Turn that 2-D char array into a new grid
            this.answerGrid = new GameGrid(charGridToIntGrid(charGrid));
            // Initialize the puzzle grid
            this.puzzleGrid = this.answerGrid.clone();
            // @DEBUG
            this.difficulty = difficulty;
            long start = System.currentTimeMillis();
            while (this.puzzleGrid.getNumberOfEmptyCells() < this.difficulty) {
                takeARandomCellOut();
            }
            long end = System.currentTimeMillis();
            System.out.println("Puzzle generation used " + (end - start) + "ms.");
            // @DEBUG END
            // Store puzzle grid to initial grid as reset preparation
            this.initialGrid = this.puzzleGrid.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.timer = new Timer();
        this.timer.start();
    }

    /**
     * Compare two games
     * @param obj gameObject
     * @return if two gameObject are equal
     */
    public boolean equals(Game obj) {
        return obj.getId() == gameId;
    }

    /**
     * Reset game to initial state.
     */
    public void reset() {
        life = Constant.LIFE_NUM;
        puzzleGrid = initialGrid.clone();
        pointer = new int[] { 0, 0 };
        timer.reset();
    }

    /**
     * get id of the game.
     * @return double game id
     */
    public double getId() {
        return gameId;
    }

    /**
     * Auxiliary function that convert a 2-D char array into a 2-D int array.
     * @param charGrid 2-D char array representing the grid
     * @return 2-D int array representing the grid
     */
    private int[][] charGridToIntGrid(char[][] charGrid) {
        int[][] intGrid = new int[16][16];
        for (int i = 0; i < charGrid.length; i++) {
            for (int j = 0; j < charGrid[i].length; j++) {
                intGrid[i][j] = Integer.parseInt(charGrid[i][j] + "", 16);
            }
        }
        return intGrid;
    }

    /**
     * Auxiliary function that generates a puzzle grid from an answer grid by taking random cells
     * out one at a time.
     */
    private void takeARandomCellOut() {
        Random random = new Random();
        // Keep removing blocks
        while (true) {
            int row = random.nextInt(GameGrid.DIMENSION);
            int column = random.nextInt(GameGrid.DIMENSION);
            // If this is not an empty cell
            if (this.puzzleGrid.cells[row][column].value != -1) {
                // Store the value in case things don't work out well.
                int savedValue = this.puzzleGrid.cells[row][column].value;
                // Remove it, copy the change to puzzleGrid, and flip the flag
                this.puzzleGrid.cells[row][column].value = -1;
                this.puzzleGrid.cells[row][column].confirmed = false;
                if (Solver.solve(puzzleGrid)) {
                    // If it can be solved, done
                    return;
                } else {
                    // Else revert back
                    this.puzzleGrid.cells[row][column].value = savedValue;
                    this.puzzleGrid.cells[row][column].confirmed = true;
                }
            }
        }
    }

    /** Function that reduces the life of the game by 1. */
    public void reduceLife() {
        if (this.life > 0) {
            this.life -= 1;
        }
    }

    /**
     * Main function to test the game object internally.
     * @param args useless
     */
    public static void main(String[] args) {
        Game newGame = new Game(Constant.DIFFICULTY_EASY);
        newGame.puzzleGrid.printGrid();
        System.out.println("Final Puzzle!");
        Solver.solve(newGame.puzzleGrid);
    }
}
