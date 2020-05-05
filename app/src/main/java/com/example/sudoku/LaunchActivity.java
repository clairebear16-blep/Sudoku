package com.example.sudoku;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.ColorUtils;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LaunchActivity extends AppCompatActivity {
    View view;
    int currentColor;
    int resultColor;
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
        Button clearButton = (Button) findViewById(R.id.clear);
        currentColor = getResources().getColor(R.color.white);
        redButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentColor == getResources().getColor(R.color.white)) {
                    view.setBackgroundResource(R.color.red);
                    resultColor = getResources().getColor(R.color.red);
                    currentColor = resultColor;
                }
                resultColor = ColorUtils.blendARGB(currentColor,
                        getResources().getColor(R.color.red), 0.5F);
                view.setBackgroundColor(resultColor);
                currentColor = resultColor;
            }
        });

        orangeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //this part of code is subject to change
                if (currentColor == getResources().getColor(R.color.white)) {
                    view.setBackgroundResource(R.color.orange);
                    resultColor = getResources().getColor(R.color.orange);
                    currentColor = resultColor;
                }
                resultColor = ColorUtils.blendARGB(currentColor,
                        getResources().getColor(R.color.orange), 0.5F);
                view.setBackgroundColor(resultColor);
                currentColor = resultColor;
            }
        });

        yellowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentColor == getResources().getColor(R.color.white)) {
                    view.setBackgroundResource(R.color.yellow);
                    resultColor = getResources().getColor(R.color.yellow);
                    currentColor = resultColor;
                }
                resultColor = ColorUtils.blendARGB(currentColor,
                        getResources().getColor(R.color.yellow), 0.5F);
                view.setBackgroundColor(resultColor);
                currentColor = resultColor;
            }
        });

        limeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentColor == getResources().getColor(R.color.white)) {
                    view.setBackgroundResource(R.color.lime);
                    resultColor = getResources().getColor(R.color.lime);
                    currentColor = resultColor;
                }
                resultColor = ColorUtils.blendARGB(currentColor,
                        getResources().getColor(R.color.lime), 0.5F);
                view.setBackgroundColor(resultColor);
                currentColor = resultColor;
            }
        });

        greenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentColor == getResources().getColor(R.color.white)) {
                    view.setBackgroundResource(R.color.green);
                    resultColor = getResources().getColor(R.color.green);
                    currentColor = resultColor;
                }
                resultColor = ColorUtils.blendARGB(currentColor,
                        getResources().getColor(R.color.green), 0.5F);
                view.setBackgroundColor(resultColor);
                currentColor = resultColor;
            }
        });

        lightblueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentColor == getResources().getColor(R.color.white)) {
                    view.setBackgroundResource(R.color.lightblue);
                    resultColor = getResources().getColor(R.color.lightblue);
                    currentColor = resultColor;
                }
                resultColor = ColorUtils.blendARGB(currentColor,
                        getResources().getColor(R.color.lightblue), 0.5F);
                view.setBackgroundColor(resultColor);
                currentColor = resultColor;
            }
        });

        blueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentColor == getResources().getColor(R.color.white)) {
                    view.setBackgroundResource(R.color.blue);
                    resultColor = getResources().getColor(R.color.blue);
                    currentColor = resultColor;
                }
                resultColor = ColorUtils.blendARGB(currentColor,
                        getResources().getColor(R.color.blue), 0.5F);
                view.setBackgroundColor(resultColor);
                currentColor = resultColor;
            }
        });

        pinkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentColor == getResources().getColor(R.color.white)) {
                    view.setBackgroundResource(R.color.pink);
                    resultColor = getResources().getColor(R.color.pink);
                    currentColor = resultColor;
                }
                resultColor = ColorUtils.blendARGB(currentColor,
                        getResources().getColor(R.color.pink), 0.5F);
                view.setBackgroundColor(resultColor);
                currentColor = resultColor;
            }
        });

        purpleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentColor == getResources().getColor(R.color.white)) {
                    view.setBackgroundResource(R.color.purple);
                    resultColor = getResources().getColor(R.color.purple);
                    currentColor = resultColor;
                }
                resultColor = ColorUtils.blendARGB(currentColor,
                        getResources().getColor(R.color.purple), 0.5F);
                view.setBackgroundColor(resultColor);
                currentColor = resultColor;
            }
        });

        /**clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //this part of code is subject to change
                view.setBackgroundResource(R.color.white);
            }
        });*/

    }
    /*
    private void printGrid(int grid[][]) {
        for (int y = 0; y < 9; y++) {
            for(int x = 0; x < 9; x++) {
                System.out.print(grid[x][y]);
            }
            System.out.println();
        }
    }

     */


}
