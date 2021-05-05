package com.example.lamiaapplicazione;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }

    public void scambioFinestre(View V) {
        Intent intent = new Intent(MainActivity3.this,MainActivity.class);
        startActivity(intent);
    }
}