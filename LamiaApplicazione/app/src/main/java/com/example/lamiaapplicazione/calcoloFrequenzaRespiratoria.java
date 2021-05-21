package com.example.lamiaapplicazione;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class calcoloFrequenzaRespiratoria extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }

    public void scambioFinestre(View V) {
        Intent intent = new Intent(calcoloFrequenzaRespiratoria.this,MainActivity.class);
        startActivity(intent);
    }



    private class MyAsyncTask extends AsyncTask<String, Integer, String> {

        private ProgressBar asyncProgress;
        private TextView asyncTextView;

        public MyAsyncTask(MyAsyncTask myAsyncTask) {
        }


        public void startAsyncTask(View v) {
            MyAsyncTask task = new MyAsyncTask(this);
            task.execute("Dortmound");
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

            asyncProgress.setVisibility(View.VISIBLE);
        }



        @Override
        protected void onProgressUpdate(Integer... progress){

            asyncProgress.setProgress(progress[0]);
        }
        @Override
        protected void onPostExecute(String result){
            asyncProgress.setVisibility(View.GONE);
            asyncTextView.setText(result);
        }

    }

}