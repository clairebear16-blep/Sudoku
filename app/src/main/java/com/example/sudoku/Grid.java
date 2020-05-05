package com.example.sudoku;

import android.content.Context;
import android.widget.Toast;

public class Grid {
    private SudokuCell[][] cell = new SudokuCell[9][9];
    private Context context;

    public Grid(Context context) {
        this.context = context;
        for (int x= 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                cell[x][y] = new SudokuCell(context);
            }
        }
    }

    public void setGrid(int[][] grid) {
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                cell[x][y].setValue(grid[x][y]);
                if ((grid[x][y]) != 0) {
                    cell[x][y].setNotModifiable();
                }
            }
        }
    }

    public SudokuCell[][] getGrid() {
        return cell;
    }

    public SudokuCell getItem(int x, int y) {
        return cell[x][y];
    }

    public SudokuCell getItem(int position) {
        int x = position % 9;
        int y = position / 9;
        return cell[x][y];
    }

    public void setItem(int x, int y, int number) {
        cell[x][y].setValue(number);
    }

    public void checkGame() {
        int[][] grid = new int[9][9];
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                grid[x][y] = getItem(x, y).getValue();
            }
        }

        if (SudokuChecker.getInstance().checkSudoku(grid)) {
            Toast.makeText(context, "Yay, you solved it!", Toast.LENGTH_LONG).show();
        }
    }
}
