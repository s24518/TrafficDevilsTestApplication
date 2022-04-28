package com.nikfen.trafficdevilstestapplication.viewmodel;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.nikfen.trafficdevilstestapplication.R;

import java.util.concurrent.Executor;

public class FOpenViewModel extends ViewModel {
    private MutableLiveData<Boolean> response;

    public void fetchResponse(FirebaseRemoteConfig remoteConfig){
        response = new MutableLiveData<Boolean>();
        remoteConfig.fetchAndActivate();
        response.setValue(remoteConfig.getBoolean("boolean_key"));
    }

    public MutableLiveData<Boolean> getResponse(){
        return response;
    }
}
