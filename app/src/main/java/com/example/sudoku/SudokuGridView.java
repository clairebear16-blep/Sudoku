package com.example.sudoku;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

public class SudokuGridView extends GridView {
    private Context context;

    public SudokuGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
    }


}
