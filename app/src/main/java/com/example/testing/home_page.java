package com.example.testing;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.testing.databinding.ActivityHomePageBinding;

import java.io.IOException;
import java.util.concurrent.Executors;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class home_page extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityHomePageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @SuppressLint("SetTextI18n")
            @Override
            public void run() {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url("https://newsapi.org/v2/everything?q=crypto%20OR%20nasduq%20OR%20nse&from=2024-03-04&to=2024-04-04&sortBy=relevancy&apiKey=9cba679244974b64bfea30aca9d3f868")
                        .get()
                        .build();

                Response response = null;
                try {
                    response = client.newCall(request).execute();
                    if (!response.isSuccessful()) {
                        Toast.makeText(getApplicationContext(),"error occured",Toast.LENGTH_SHORT).show();
                    } else {
                        ObjectMapper objectMapper = new ObjectMapper();
                        final News newsob = objectMapper.readValue(response.body().string(),News.class);

                        Log.d("news aaaaaaaaaaaaaaaaa data",newsob.getArticles().get(0).getContent());


                    }
                    response.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

}