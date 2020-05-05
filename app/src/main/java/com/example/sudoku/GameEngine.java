package com.example.sudoku;

import android.content.Context;

public class GameEngine {
    private static GameEngine engine;
    private Grid grid = null;
    private int currentxPos = -1;
    private int currentyPos = -1;

    private GameEngine() {
    }

    public static GameEngine getInstance() {
        if (engine == null) {
            engine = new GameEngine();
        }
        return engine;
    }

    public void createGrid(Context context) {
        int[][] Sudoku = GameGenerator.getExample().generateGrid();
        Sudoku = GameGenerator.getExample().removeElements(Sudoku);
        grid = new Grid(context);
        grid.setGrid(Sudoku);
    }

    public Grid getGrid() {
        return grid;
    }

    public void setSelectedPosition(int x, int y) {
        currentxPos = x;
        currentyPos = y;
    }

    public void setNumber(int number) {
        if (currentxPos != -1 && currentyPos != -1) {
            grid.setItem(currentxPos, currentyPos, number);
        }
        grid.checkGame();
    }
}
