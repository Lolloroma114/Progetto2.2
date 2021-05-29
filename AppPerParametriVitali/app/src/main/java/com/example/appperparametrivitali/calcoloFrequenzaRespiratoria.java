package com.example.appperparametrivitali;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class calcoloFrequenzaRespiratoria extends AppCompatActivity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcolo_frequenza_respiratoria);
        button = (Button)findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TaskAsincrona taskasincrona = new TaskAsincrona(calcoloFrequenzaRespiratoria.this, button);
                taskasincrona.execute();
                button.setEnabled(false);
            }
        });
    }
}