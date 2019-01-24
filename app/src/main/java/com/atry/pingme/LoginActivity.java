package com.atry.pingme;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class LoginActivity extends AppCompatActivity {
    private Button login;
    private Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
           super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
           mToolbar= (Toolbar) findViewById(R.id.login_page_bar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Sign In");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        login=(Button)findViewById(R.id.btn_login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent= new Intent(LoginActivity.this,MainActivity.class);
                startActivity(loginIntent);
            }
        });
    }
}
