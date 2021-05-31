package com.example.myhealth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.Executor;

public class HeartRateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heart_rate);
    }

    public void startHeartRate(View v) {
        //Context context = getApplication();
        //Toast toast = Toast.makeText(context, "Avvia la misura della Frequenza Cardiaca", Toast.LENGTH_SHORT);
        //toast.show();
        new Thread(new Runnable() {

            private String result;

            @Override
            public void run() {
                try {
                    /*
                     Simula una computazione di 4 secondi e la produzione di un risultato
                    */
                    Thread.sleep(4000);
                    result = new String("65");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // Attività conclusiva del Thread con aggiornamento della UI
                TextView txt=(TextView)findViewById(R.id.textViewHeartRate);
                txt.post(new Runnable() {
                    public void run() {
                        txt.setText(result);
                    }
                });
            }
        }).start();
    }

    public void stopHeartRate(View v) {
        //Context context = getApplication();
        //Toast toast = Toast.makeText(context, "Ferma la misura della Frequenza Cardiaca", Toast.LENGTH_SHORT);
        //toast.show();
    }

    public void back(View v) {
        this.finish();
    }

}

