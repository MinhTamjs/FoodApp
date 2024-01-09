package com.example.foodapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.foodapp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class BaseActivity extends AppCompatActivity {
    FirebaseAuth mAuth;
    FirebaseDatabase database;
    public String TAG = "Tam";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String firebaseURL = "https://foodapp-a347f-default-rtdb.asia-southeast1.firebasedatabase.app/";

        super.onCreate(savedInstanceState);
        database = FirebaseDatabase.getInstance(firebaseURL);
        mAuth = FirebaseAuth.getInstance();

        getWindow().setStatusBarColor(getResources().getColor(R.color.white));
    }
}