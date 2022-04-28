package com.nikfen.trafficdevilstestapplication.view.game;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.nikfen.trafficdevilstestapplication.R;

public class GameActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

    }



    public void doublePole(View view) {
        startActivity(new Intent(this, DoublePole.class));
    }


    public void triplePole(View view) {

        startActivity(new Intent(this, TriplePole.class));
    }
}