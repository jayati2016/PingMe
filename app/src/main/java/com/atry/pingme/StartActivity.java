package com.atry.pingme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity {
    private Button newUser;
    private  Button alreadyUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        newUser= (Button)findViewById(R.id.btn1);
        alreadyUser=(Button)findViewById(R.id.btn2);

        newUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent= new Intent(StartActivity.this,RegisterActivity.class);
                startActivity(registerIntent);
            }
        });

        alreadyUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent= new Intent(StartActivity.this,LoginActivity.class);
                startActivity(loginIntent);
            }
        });
    }
    }

