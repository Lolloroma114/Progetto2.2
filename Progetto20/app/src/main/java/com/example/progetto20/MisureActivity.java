package com.example.progetto20;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.progetto20.R;

public class MisureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_misure);
    }

    public void apriHeartRate(View v) {
        Intent intent = new Intent(this, HeartRateActivity.class);
        startActivity(intent);
    }

    public void back(View v) {
        this.finish();
    }
}