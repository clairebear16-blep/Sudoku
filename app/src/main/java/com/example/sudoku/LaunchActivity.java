package com.example.sudoku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LaunchActivity extends AppCompatActivity {
    View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /**TextView textView = findViewById(R.id.Colordoku);
        String str = "COLORDUKU";
        SpannableString ss = new SpannableString(str); */

        view = this.getWindow().getDecorView();
        Button redButton = (Button) findViewById(R.id.redButton);
        Button orangeButton = (Button) findViewById(R.id.orangeButton);
        Button yellowButton = (Button) findViewById(R.id.yellowButton);
        Button limeButton = (Button) findViewById(R.id.limeButton);
        Button greenButton = (Button) findViewById(R.id.greenButton);
        Button lightblueButton = (Button) findViewById(R.id.lightblueButton);
        Button blueButton = (Button) findViewById(R.id.blueButton);
        Button pinkButton = (Button) findViewById(R.id.purpleButton);
        Button purpleButton = (Button) findViewById(R.id.pinkButton);

        redButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundResource(R.color.red);
            }
        });

        orangeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //this part of code is subject to change
                view.setBackgroundResource(R.color.orange);
            }
        });

        yellowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //this part of code is subject to change
                view.setBackgroundResource(R.color.yellow);
            }
        });

        limeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //this part of code is subject to change
                view.setBackgroundResource(R.color.lime);
            }
        });

        greenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //this part of code is subject to change
                view.setBackgroundResource(R.color.green);
            }
        });

        lightblueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //this part of code is subject to change
                view.setBackgroundResource(R.color.lightblue);
            }
        });

        blueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //this part of code is subject to change
                view.setBackgroundResource(R.color.blue);
            }
        });

        pinkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //this part of code is subject to change
                view.setBackgroundResource(R.color.pink);
            }
        });

        purpleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //this part of code is subject to change
                view.setBackgroundResource(R.color.purple);
            }
        });

        int [][] game = GameGenerator.getExample().generateGrid();
        GamePlay.getInstance().setGame(game);

        printGrid(game);

        GameEngine.getInstance().createGrid(this);
    }

    private void printGrid(int grid[][]) {
        for (int y = 0; y < 9; y++) {
            for(int x = 0; x < 9; x++) {
                System.out.print(grid[x][y]);
            }
            System.out.println();
        }
    }


}
