package com.example.sudoku;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class SudokuGridView extends GridView {
    private Context context;

    public SudokuGridView(final Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        GridViewAdapter gridViewAdapter = new GridViewAdapter(context);
        setAdapter(gridViewAdapter);
        setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int x = position % 9;
                int y = position / 9;

                Toast.makeText(context, "Selected Item", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }



}
