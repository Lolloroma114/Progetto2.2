package com.example.appperparametrivitali;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void scambioFinestreFC(View V) {
        Intent intent = new Intent(Menu.this,calcoloFrequenzaCardiaca.class);
        startActivity(intent);
    }

    public void scambioFinestreFR(View V) {
        Intent intent = new Intent(Menu.this,calcoloFrequenzaRespiratoria.class);
        startActivity(intent);
    }
}