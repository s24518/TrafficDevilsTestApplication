package com.nikfen.trafficdevilstestapplication.view.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.nikfen.trafficdevilstestapplication.R;

import java.util.Random;

public class DoublePole extends AppCompatActivity {

    final String SAVED_SCORE = "SAVED_SCORE";

    Button[] buttons = new Button[4];
    TextView score, bestScore;
    boolean[] buttonContainer = new boolean[4];
    int scoreInt;

    SharedPreferences sPref;
    SharedPreferences.Editor editor;

    int randomNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_double_pole);

        initViews();
        initSPref();
        scoreInt = 0;
        makePole();

    }

    public void initSPref() {
        sPref = getSharedPreferences(getString(R.string.SPrefGame), MODE_PRIVATE);
        editor = sPref.edit();
    }

    public void initViews() {
        buttons[0] = findViewById(R.id.button1);
        buttons[1] = findViewById(R.id.button2);
        buttons[2] = findViewById(R.id.button3);
        buttons[3] = findViewById(R.id.button4);
        score = findViewById(R.id.score);
        bestScore = findViewById(R.id.best_score);
    }

    public void button1(View view) {
        checkWin(0);
    }

    public void button2(View view) {
        checkWin(1);
    }

    public void button3(View view) {
        checkWin(2);
    }

    public void button4(View view) {
        checkWin(3);
    }

    public void makePole() {
        score.setText(String.valueOf(scoreInt));
        bestScore.setText(String.valueOf(sPref.getInt(SAVED_SCORE, 0)));
        Random rand = new Random();
        int r = rand.nextInt(225);
        int g = rand.nextInt(225);
        int b = rand.nextInt(225);
        int randomColor = Color.rgb(r, g, b);
        int anotherRandomColor = Color.rgb(r + 20, g + 20, b + 20);
        for (int i = 0; i < 4; i++) {
            buttons[i].setBackgroundColor(randomColor);
            buttonContainer[i] = false;
        }

        randomNum = rand.nextInt(4);
        buttons[randomNum].setBackgroundColor(anotherRandomColor);
        buttonContainer[randomNum] = true;
    }

    public void checkWin(int buttonId) {
        if (buttonContainer[buttonId]) {
            Toast.makeText(this, "Good!", Toast.LENGTH_SHORT).show();
            scoreInt++;
            makePole();
        } else {
            Toast.makeText(this, "You failed!", Toast.LENGTH_SHORT).show();
            checkScore();
            fail();
        }
    }

    public void checkScore() {
        if (scoreInt > sPref.getInt(SAVED_SCORE, 0)) {
            editor.putInt(SAVED_SCORE, scoreInt);
            editor.apply();
        }
    }

    public void fail() {
        checkScore();
        startActivity(new Intent(this, GameActivity.class));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        checkScore();
    }
}