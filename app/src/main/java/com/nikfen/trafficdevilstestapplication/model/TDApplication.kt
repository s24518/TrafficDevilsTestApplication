package com.nikfen.trafficdevilstestapplication.model

import android.app.Application
import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Toast
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.nikfen.trafficdevilstestapplication.R

class TDApplication : Application() {


    private lateinit var remoteConfig: FirebaseRemoteConfig



    override fun onCreate() {
        super.onCreate()
        remoteConfig = FirebaseRemoteConfig.getInstance()
        remoteConfig.setDefaultsAsync(R.xml.remote_config_defaults)


    }

    fun getConfig(): FirebaseRemoteConfig {
        return remoteConfig
    }


}