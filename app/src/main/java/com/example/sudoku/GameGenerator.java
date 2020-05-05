package com.example.sudoku;

import java.util.ArrayList;
import java.util.Random;

public class GameGenerator {
    private static GameGenerator example;
    //List of Available points on the board(grid)
    private ArrayList<ArrayList<Integer>> available = new ArrayList<ArrayList<Integer>>();
    private Random r = new Random();
    private GameGenerator() { }
    public static GameGenerator getExample() {
        if (example == null) {
            return new GameGenerator();
        }
        return example;
    }
    public int[][] generateGrid() {
        int[][] game = new int[9][9];
        int currentPosition = 0;
        //clearGrid(game);
        while (currentPosition < 81) {
            if (currentPosition == 0) {
                clearGrid(game);
            }
            if (available.get(currentPosition).size() != 0) {
                int i = r.nextInt(available.get(currentPosition).size());
                int number = available.get(currentPosition).get(i);

                if (!checkConflict(game, currentPosition, number)) {
                    //No conflict, good to go
                    int xPos = currentPosition % 9;
                    int yPos = currentPosition / 9;
                    game[xPos][yPos] = number;
                    available.get(currentPosition).remove(i);
                    currentPosition++;
                } else {
                    available.get(currentPosition).remove(i);
                }
            }
            else {
                for (int i = 1; i <= 9; i++) {
                    available.get(currentPosition).add(i);
                }
                currentPosition--;
            }
        }
        return game;
    }
    public int[][] removeElements(int[][] grid) {
        int k = 0;
        //difficulty control
        while(k < 30) {
            int x = r.nextInt(9);
            int y = r.nextInt(9);
            if (grid[x][y] != 0) {
                //set the number to be 0
                grid[x][y] = 0;
                k++;
            }
        }
        return grid;
    }


    private void clearGrid (int[][] currentGame) {
        available.clear();
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                currentGame[x][y] = -1;
            }
        }
        //Add all the available numbers
        for (int pos = 0; pos < 81; pos++) {
            available.add(new ArrayList<Integer>());
            for (int j = 1; j <= 9; j++) {
                available.get(pos).add(j);
            }
        }
    }

    //Some checkers to make sure there are no conflict in rendering the numbers
    //return true if there is a conflict when assigning numbers
    private boolean checkConflict(int [][] grid, int currentPos, final int number) {
        int xPos = currentPos % 9;
        int yPos = currentPos / 9;

        if (checkHorizontalConflict(grid, xPos, yPos, number) || checkVerticalConflict(grid, xPos, yPos, number)
        || checkRegionalConflict(grid, xPos, yPos, number)) {
            return true;
        }
        return false;
    }
    private boolean checkHorizontalConflict(final int[][] game, final int xPos, final int yPos, final int number) {
        for (int x = xPos - 1; x >= 0; x--) {
            if (number == game[x][yPos]) {
                return true;
            }
        }
        return false;
    }
    private boolean checkVerticalConflict(final int[][] game, final int xPos, final int yPos, final int number) {
        for (int y = yPos - 1; y >= 0; y--) {
            if (number == game[xPos][y]) {
                return true;
            }
        }
        return false;
    }
    private boolean checkRegionalConflict(final int[][] game, final int xPos, final int yPos, final int number) {
        int xRegion = xPos / 3;
        int yRegion = yPos / 3;
        for (int x = xRegion * 3; x < xRegion * 3 + 3; x++) {
            for (int y = yRegion * 3; y < yRegion * 3 + 3; y++) {
                if ((x != xPos || y != yPos) && number == game[x][y]) {
                    return true;
                }
            }
        }
        return false;
    }
}
