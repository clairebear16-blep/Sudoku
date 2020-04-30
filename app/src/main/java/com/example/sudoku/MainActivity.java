package com.example.sudoku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
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

        TextView textView = findViewById(R.id.Colordoku);
        String title = "COLORDOKU";
        textView.setText(buildRainbowText(title));

    }

    private Spannable buildRainbowText(String name) {
        int[] colors = new int[]{Color.RED, 0xFFFF9933, Color.YELLOW, Color.GREEN, Color.BLUE, Color.RED, 0xFFFF9933, Color.YELLOW, Color.GREEN, Color.BLUE, Color.RED, 0xFFFF9933, Color.YELLOW, Color.GREEN, Color.BLUE, Color.RED, 0xFFFF9933, Color.YELLOW, Color.GREEN, Color.BLUE};
        Spannable word = new SpannableString(name);
        for(int i = 0; i < word.length(); i++) {
            word.setSpan(new ForegroundColorSpan(colors[i]), i, i+1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        return word;
    }

    public void beginGame() {
        Intent intent = new Intent(this, LaunchActivity.class);
        startActivity(intent);
    }
}
