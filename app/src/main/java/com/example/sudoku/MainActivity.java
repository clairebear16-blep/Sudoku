package com.example.sudoku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        Button button;
        button = (Button) findViewById(R.id.begin);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                beginGame();
            }
        });

        /**TextView text = findViewById(R.id.Colordoku);
        String str = "COLORDOKU";
        SpannableString ss = new SpannableString(str);
        ForegroundColorSpan red = new ForegroundColorSpan(Color.RED);
        ForegroundColorSpan yellow = new ForegroundColorSpan(Color.YELLOW);
        ForegroundColorSpan cyan = new ForegroundColorSpan(Color.CYAN);
        ForegroundColorSpan blue = new ForegroundColorSpan(Color.BLUE);
        ForegroundColorSpan purple = new ForegroundColorSpan(Color.MAGENTA);
        ForegroundColorSpan grey = new ForegroundColorSpan(Color.LTGRAY);
        ss.setSpan(red, 0, 0, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(yellow, 1, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(cyan, 2, 2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(blue, 3, 3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(purple, 4, 4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(grey, 5, 5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(red, 6, 6, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(yellow, 7, 7, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(blue, 8, 8, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        if (ss != null) {
            text.setText(ss);
        } */
    }
    public void beginGame() {
        Intent intent = new Intent(this, LaunchActivity.class);
        startActivity(intent);
    }
}
