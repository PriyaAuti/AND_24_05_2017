package com.example.uithread;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int i=0;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    
    public void onBtnClick(View view){
      //  workerThread();

        new MyTask().execute(0,100/*params*/);

    }


    private void handlerDemo(){

    }

    public void workerThread(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(i=0;i<=100;i++){
                    try{
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        @Override
                        public void run() {
                            ((TextView) findViewById(R.id.txtCntr)).setText(String.valueOf(i));
                        }
                    });

                }

            }
        }).start();
    }
    private class MyTask extends AsyncTask<Integer/*params*/, Integer/*progress*/, Boolean/*Result*/>{

        private ProgressDialog pd;

        protected void onPreExecute(){
            super.onPreExecute();
            pd = new ProgressDialog(MainActivity.this);
            pd.setMax(100);
            pd.setTitle("Title");
            pd.setMessage("Message");
            pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            pd.show();
            // UI thread
        }

        @Override
        protected Boolean doInBackground(Integer... params) {
            // Worker Thread

            for (int i = params[0]; i < params[1]; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress(i);
            }

            return true;
        }
        protected void onPostExecute(Boolean aBoolean){
            super.onPostExecute(aBoolean);
            //UIThread
            pd.dismiss();

        }

        protected void onProgressUpdate(Integer ... values){
            super.onProgressUpdate(values);

            ((TextView)findViewById(R.id.txtCntr)).setText(String.valueOf(values[0]));
            pd.setProgress(values[i]);
            //UIThread

        }
    }
}
