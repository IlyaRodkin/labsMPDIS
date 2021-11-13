package com.example.lab8;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.view.View;


import android.webkit.WebSettings;
import android.webkit.WebView;

import android.webkit.WebViewClient;



import android.widget.Button;

import android.widget.EditText;

import android.widget.TextView;

import android.widget.Toast;



import java.io.FileInputStream;

import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {
    private WebView mWebView;

    @Override
    @SuppressLint("SetJavaScriptEnabled")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWebView = findViewById(R.id.activity_main_webview);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new MyWebViewClient());

        mWebView.loadUrl("https://vk.com");
    }

    @Override
    public void onBackPressed() {
        if(mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }

}