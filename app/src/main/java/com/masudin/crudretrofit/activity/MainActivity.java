package com.masudin.crudretrofit.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.masudin.crudretrofit.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addData(View view) {
        Intent intent = new Intent(getApplicationContext(),AddActivity.class);
        startActivity(intent);
    }

    public void showData(View view) {
        Intent intent = new Intent(getApplicationContext(),ShowActivity.class);
        startActivity(intent);
    }
}