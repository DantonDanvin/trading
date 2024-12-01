package com.example.testing;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.bumptech.glide.Glide;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.io.IOException;
import java.util.concurrent.Executors;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerlayout; 
    ImageButton b1;
    TextView t1;
    NavigationView navigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        drawerlayout = findViewById(R.id.drawer);
        b1 = findViewById(R.id.menu);
        navigation = findViewById(R.id.navigation);
        Intent intent1 = new Intent(this, crypto_page.class);
        Intent i2 = new Intent(this, sign_up.class);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerlayout.open();
            }
        });

        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int itemid = item.getItemId();
                if(itemid==R.id.crypto) {
                    startActivity(intent1);
                }
                if(itemid==R.id.delate_account){
//                    Toast.makeText(getApplicationContext(),"hiiiiii",Toast.LENGTH_SHORT).show();
                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                    assert user != null;
                    user.delete()
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        startActivity(i2);
                                    } else {
                                        Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }

                return false;
            }
        });

        Executors.newSingleThreadExecutor().execute(new Runnable() {

            @Override
            public void run() {
                OkHttpClient client = new OkHttpClient();

                Request request = new Request.Builder()
                        .url("https://newsapi.org/v2/everything?q=crypto%20OR%20nasduq%20OR%20nse&sortBy=relevancy&apiKey=9cba679244974b64bfea30aca9d3f868")
                        .get()
                        .build();

                Response response;
                try {
                    response = client.newCall(request).execute();
                    if (!response.isSuccessful()) {
                        int s=0;
                    } else {
                        ObjectMapper objectMapper = new ObjectMapper();
                        final News newsob = objectMapper.readValue(response.body().string(),News.class);


                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                int si = newsob.getArticles().size(),ind=0;



                                while(si>ind) {
                                    LinearLayout linearLayout;
                                    linearLayout = findViewById(R.id.north);
                                    LayoutInflater layoutinflater = getLayoutInflater();
                                    View view = layoutinflater.inflate(R.layout.news_view,null);

                                    view.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            int clickedIndex = (int) v.getTag();

                                            Intent intent = new Intent(MainActivity.this, news_web.class);
                                            intent.putExtra("url", newsob.getArticles().get(clickedIndex).geturl());
                                            startActivity(intent);
                                        }
                                    });

                                    TextView t1 = view.findViewById(R.id.news_author), t2 = view.findViewById(R.id.news_description);
                                    ImageView i1 = view.findViewById(R.id.news_image);
                                    view.setTag(ind);

                                    t1.setText(newsob.getArticles().get(ind).getSource().getName());
                                    t2.setText(newsob.getArticles().get(ind).getContent());
                                    Glide.with(view).load(newsob.getArticles().get(ind).geturlToImage()).into(i1);

                                    linearLayout.addView(view);
                                    ind++;
                                }
                            }
                        });
                    }
                    response.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

    }


}