package com.example.appperparametrivitali;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Button;

public class TaskAsincrona extends AsyncTask <Void,Integer,String> {

    Context context;
    ProgressDialog progressDialog;
    Button button;

    public TaskAsincrona(Context context, Button button){
        this.context = context;
        this.button = button;
    }

    @Override
    protected String doInBackground(Void... params) {

        int i = 0;
        synchronized (this){
            while (i<10){
                try {
                    wait(1500);
                    i++;
                    publishProgress(i);
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
        return "Download Completed";
    }

    @Override
    protected void onPreExecute() {
        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("Sto Calcolando...");
        progressDialog.setMax(10);
        progressDialog.setProgress(0);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.show();
    }

    @Override
    protected void onPostExecute(String result) {
       button.setEnabled(true);
       progressDialog.hide();
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        int progress = values[0];
        progressDialog.setProgress(progress);
    }
}
