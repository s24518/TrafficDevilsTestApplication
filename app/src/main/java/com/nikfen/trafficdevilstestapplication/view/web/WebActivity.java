package com.nikfen.trafficdevilstestapplication.view.web;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

import com.nikfen.trafficdevilstestapplication.R;

public class WebActivity extends AppCompatActivity {

    WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        initView();

        webView.loadUrl(getString(R.string.html5link));
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new CustomWebVieClient());
    }


    private void initView() {
        webView = findViewById(R.id.webView);
    }


}