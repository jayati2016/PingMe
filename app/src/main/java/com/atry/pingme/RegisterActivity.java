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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    private Button register;
    private FirebaseAuth mAuth;
    private Toolbar mToolbar;
    private EditText name;
    private EditText email;
    private EditText password;
    private ProgressDialog progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mToolbar=findViewById(R.id.register_page_bar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Sign Up");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mAuth=FirebaseAuth.getInstance();

        register=(Button)findViewById(R.id.btn_reg);
        name=(EditText)findViewById(R.id.et_rname);
        email=(EditText)findViewById(R.id.et_remail);
        password=(EditText)findViewById(R.id.et_rpassword);
        progressBar=new ProgressDialog(this);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname= name.getText().toString();
                String uemail= email.getText().toString();
                String upassword= password.getText().toString();

                registerAccount(uname,uemail,upassword);


            }
        });
    }

    private void registerAccount(String uname, String uemail, String upassword) {
        if(TextUtils.isEmpty(uname)){
            Toast.makeText(RegisterActivity.this,"Please enter name",Toast.LENGTH_LONG).show();

        }
        if(TextUtils.isEmpty(uemail)){
            Toast.makeText(RegisterActivity.this,"Please enter email",Toast.LENGTH_LONG).show();

        }
        if(TextUtils.isEmpty(upassword)){
            Toast.makeText(RegisterActivity.this,"Please enter password",Toast.LENGTH_LONG).show();

        }
        else{
            progressBar.setTitle("Creating Account");
            progressBar.setMessage("Please wait...");
            progressBar.show();

        mAuth.createUserWithEmailAndPassword(uemail,upassword)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Intent registerIntent=new Intent(RegisterActivity.this,MainActivity.class);
                                registerIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(registerIntent);
                                finish();

                            }
                            else {
                                Toast.makeText(RegisterActivity.this,"Error",Toast.LENGTH_LONG).show();

                            }
                            progressBar.dismiss();
                    }
                });
        }
    }
}
