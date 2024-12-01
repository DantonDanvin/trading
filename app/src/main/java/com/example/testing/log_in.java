package com.example.testing;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class log_in extends AppCompatActivity {
    private FirebaseAuth mauth;
    private ProgressDialog progressd;
    private EditText email;
    private EditText password;
    private Button submit;
    ProgressBar progressBa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        Intent  it = new Intent(this,MainActivity.class);
        mauth = FirebaseAuth.getInstance();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

//        if(user != null){ startActivity(it); }


        email = findViewById(R.id.editTextTextEmailAddress);
        password = findViewById(R.id.editTextTextPassword);
        submit = findViewById(R.id.button);
        progressBa = findViewById(R.id.pblog);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBa.setVisibility(View.VISIBLE);
                String emailtext = email.getText().toString().trim();
                String passwordtext = password.getText().toString().trim();
                if(TextUtils.isEmpty(emailtext) || TextUtils.isEmpty(passwordtext)){
                    Toast.makeText(log_in.this,"No empty fields allowed",Toast.LENGTH_SHORT).show();
                }
                else {

                    mauth.signInWithEmailAndPassword(emailtext, passwordtext).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()) {
                                progressBa.setVisibility(View.GONE);
                                startActivity(it);
                            } else {
                                Toast.makeText(log_in.this,"error occurred",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }
}