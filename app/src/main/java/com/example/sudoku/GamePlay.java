package com.example.sudoku;

public class GamePlay {
    private static GamePlay instance;
    private int[][] game;
    private GamePlay() {}
    public static GamePlay getInstance() {
        if (instance == null) {
            instance = new GamePlay();
        }
        return instance;
    }

    public int[][] getGame() {
        return game;
    }
    public void setGame(int[][] setGame) {
        game = setGame;
    }
}
