package com.example.lamiaapplicazione;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

public class calcoloFrequenzaCardiaca extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void scambioFinestre(View V) {
        Intent intent = new Intent(calcoloFrequenzaCardiaca.this,MainActivity.class);
        startActivity(intent);
    }
}