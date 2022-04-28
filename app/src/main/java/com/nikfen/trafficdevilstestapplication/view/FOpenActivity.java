package com.nikfen.trafficdevilstestapplication.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.nikfen.trafficdevilstestapplication.model.TDApplication;
import com.nikfen.trafficdevilstestapplication.view.game.GameActivity;
import com.nikfen.trafficdevilstestapplication.view.web.WebActivity;
import com.nikfen.trafficdevilstestapplication.viewmodel.FOpenViewModel;

public class FOpenActivity extends AppCompatActivity {

    private FOpenViewModel fOpenViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initViewModel();

        fOpenViewModel = new ViewModelProvider(this).get(FOpenViewModel.class);
        fOpenViewModel.fetchResponse(getRemoteConfig());
        fOpenViewModel.getResponse().observe(this, response -> {
            if (response) startActivity(new Intent(this, WebActivity.class));
            else startActivity(new Intent(this, GameActivity.class));
        });

    }

    private FirebaseRemoteConfig getRemoteConfig() {
        return ((TDApplication) getApplicationContext()).getConfig();
    }

    private void initViewModel() {
        fOpenViewModel = new ViewModelProvider(this).get(FOpenViewModel.class);
    }

}