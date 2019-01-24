package com.atry.pingme;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener {

    private android.support.v7.widget.Toolbar mToolbar;
    private FirebaseAuth mAuth;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        mToolbar=  findViewById(R.id.main_page_bar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("PingMe");



        BottomNavigationView navigation =  findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);
        navigation.setSelectedItemId(R.id.navigation_inbox);
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser==null){
            Intent startPageIntent = new Intent(MainActivity.this,StartActivity.class);
            startPageIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK| Intent.FLAG_ACTIVITY_CLEAR_TASK); //doesn't allow user to go from splashscreen to main activity unless it is logged in
            startActivity(startPageIntent);
            finish();
        }
    }

    private boolean loadFragment(Fragment fragment){
        if(fragment!=null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container,fragment)
                    .commit();
            return true;
        }
        return false;

    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment=null;
        switch (menuItem.getItemId()){
            case R.id.navigation_contacts:
                fragment=new ContactsFragment();
                break;

            case R.id.navigation_inbox:
                fragment=new InboxFragment();
                break;

            case R.id.navigation_profile:
                fragment=new ProfileFragment();
                break;
        }
        return loadFragment(fragment);
    }
}
