package com.example.uithread;

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

       // handler =new Handler(Looper.getMainLooper());


    }
    public void onBtnClick(View view){
        workerThread();

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
}
