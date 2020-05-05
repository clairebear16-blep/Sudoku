package com.example.sudoku;

import android.content.Context;

public class GamePlay {
    private static GamePlay instance;
    private GameGrid grid = null;
    private GamePlay() {}
    public static GamePlay getInstance() {
        if (instance == null) {
            instance = new GamePlay();
        }
        return instance;
    }

    public void createGrid(Context context) {
        int [][] game = GameGenerator.getExample().generateGrid();
        game = GameGenerator.getExample().removeElements(game);
    }

    public GameGrid getGrid() {
        return grid;
    }

}
