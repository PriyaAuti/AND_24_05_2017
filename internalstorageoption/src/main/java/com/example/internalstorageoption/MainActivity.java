package com.example.internalstorageoption;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private static final String TAG =  "TextInfo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onWrite(View view) throws IOException {
        FileOutputStream fos    = openFileOutput("my.txt",MODE_APPEND);
        fos.write("This is testing".getBytes());
        fos.close();

    }

    public void onRead(View view) throws IOException {
        StringBuilder builder = new StringBuilder();
        FileInputStream fis = openFileInput("my.txt");

        while (true) {
            int ch = fis.read();
            if(fis.read() == -1)break;
            else {
                builder.append((char) ch);
            }
        }

        Log.i(TAG,builder.toString());
        ((TextView)findViewById(R.id.txtInfo)).setText(builder);
    }
}
