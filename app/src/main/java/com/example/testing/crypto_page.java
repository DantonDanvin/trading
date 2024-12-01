package com.example.testing;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import java.io.IOException;
import java.util.Locale;

import java.util.Objects;

import com.example.firstresponse.coin_page;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.util.List;

public class crypto_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crypto_page);

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://coinranking1.p.rapidapi.com/coins?referenceCurrencyUuid=yhjMzLPhuIDl&timePeriod=3h&tiers%5B0%5D=1&orderBy=marketCap&orderDirection=desc&limit=50&offset=0")
                .get()
                .addHeader("X-RapidAPI-Key", "2b72cdb93fmsh84c52cd5f5f4c40p1e4d89jsn181671185d28")
                .addHeader("X-RapidAPI-Host", "coinranking1.p.rapidapi.com")
                .build();


        client.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                e.printStackTrace();
            }
            @Override
            public void onResponse(@NonNull Call call, @NonNull final Response response) throws IOException {
                if (!response.isSuccessful()) {
                    throw new IOException("Unexpected code " + response);
                } else {
                    ObjectMapper objectMapper = new ObjectMapper();
                    final SimpleEntity entity1 = objectMapper.readValue(response.body().string(),SimpleEntity.class);

                    response.close();

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            int data = 0,si = entity1.getData().getCoins().size();
                            while (data < si) {

                                LinearLayout linearLayout;
                                linearLayout = findViewById(R.id.linerlayout);
                                LayoutInflater layoutinflater = getLayoutInflater();
                                View view = layoutinflater.inflate(R.layout.recycler_view_item,null);

                                view.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        int clickedIndex = (int) v.getTag();


                                        Intent intent = new Intent(crypto_page.this, coin_page.class);
                                        intent.putExtra("uuid",entity1.getData().getCoins().get(clickedIndex).getuuid());
//                                        intent.putExtra("coin_data",jsondata);
                                        intent.putExtra("symbol",entity1.getData().getCoins().get(clickedIndex).getSymbol().toLowerCase());
                                        intent.putExtra("name",entity1.getData().getCoins().get(clickedIndex).getName());
                                        startActivity(intent);
                                    }
                                });


                                TextView t1 = view.findViewById(R.id.textView1), t2 = view.findViewById(R.id.textView2);

                                view.setTag(data);

                                t1.setText(entity1.getData().getCoins().get(data).getName());
                                t2.setText(entity1.getData().getCoins().get(data).getPrice());
                                ImageView i1 = view.findViewById(R.id.image);


//                                String name = entity1.getData().getCoins().get(data).getName().toLowerCase(Locale.ROOT);
                                String name1 = entity1.getData().getCoins().get(data).getSymbol().toLowerCase();

//                                String[] words = name.split("\\s+");

//                                if (words.length > 0) { name = words[0]; }

//                                Log.d("value",name+name1);
                                String ur = "https://github.com/Pymmdrza/Cryptocurrency_Logos/blob/mainx/PNG/"+name1+".png?raw=true";

                                Glide.with(view).load(ur).error(R.drawable.crypto).into(i1);

                                linearLayout.addView(view);

                                data++;
                            }
                        }
                    });
                }
            }
        });
    }
}