package com.example.lamiaapplicazione;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.lang.ref.WeakReference;

public class calcoloFrequenzaRespiratoria extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcolo_frequenza_respiratoria);
    }

    public void scambioFinestre(View V) {
        Intent intent = new Intent(calcoloFrequenzaRespiratoria.this,MainActivity.class);
        startActivity(intent);
    }

    public void startAsyncTask(View v) {
        MyAsyncTask task = new MyAsyncTask(this);
        task.execute("Dortmound");
    }



    private class MyAsyncTask extends AsyncTask<String, Integer, String> {

        private WeakReference<calcoloFrequenzaRespiratoria> activityWeakReference;

        MyAsyncTask(calcoloFrequenzaRespiratoria activity) {
            activityWeakReference = new WeakReference<calcoloFrequenzaRespiratoria>(activity);
        }


        private ProgressBar asyncProgress;
        private TextView asyncTextView;

        public MyAsyncTask(MyAsyncTask myAsyncTask) {
        }

        @Override
        protected String doInBackground(String... parameter){
            String result ="";
            int myProgress = 0;

            int inputLength = parameter[0].length();

            for (int i = 1; i<= inputLength; i++){
                myProgress = i;
                result = result + parameter[0].charAt(inputLength - i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e){}
                publishProgress(myProgress);
            }
            return result;
        }
        @Override
        protected void onPreExecute (){

            calcoloFrequenzaRespiratoria activity = activityWeakReference.get();
            if (activity == null || activity.isFinishing()) {
                return;
            }

            asyncProgress.setVisibility(View.VISIBLE);
        }



        @Override
        protected void onProgressUpdate(Integer... progress){

            calcoloFrequenzaRespiratoria activity = activityWeakReference.get();
            if (activity == null || activity.isFinishing()) {
                return;
            }

            asyncProgress.setProgress(progress[0]);
        }
        @Override
        protected void onPostExecute(String result){

            calcoloFrequenzaRespiratoria activity = activityWeakReference.get();
            if (activity == null || activity.isFinishing()) {
                return;
            }
            asyncProgress.setVisibility(View.GONE);
            asyncTextView.setText(result);
        }

    }


}