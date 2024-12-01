package com.example.testing;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class news_web extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_web);
        WebView webView;
        webView = findViewById(R.id.web_v); // Replace with your WebView ID in the layout

        // Enable JavaScript (optional, but recommended for many web pages)
        webView.getSettings().setJavaScriptEnabled(true);

        // Load the URL in the WebView
        Intent intent = getIntent();
        String url = ""; // Replace with your actual URL
        if (intent.hasExtra("url")) {
            url = intent.getStringExtra("url");
        }
        webView.loadUrl(url);
    }
}