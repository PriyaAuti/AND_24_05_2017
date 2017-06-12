package com.example.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences prefs;
    public static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prefs = getSharedPreferences("my_prefs",MODE_APPEND);

    }

    public void onWrite(View view){
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("BooleanValue",true);
        editor.putFloat("FloatValue",234.65f);
        editor.putString("StringValue","Priya");
        editor.apply();
    }


    public void onRead(View view){
        boolean _boolean =prefs.getBoolean("BooleanValue",false);
        float _float = prefs.getFloat("FloatValue",5.5f);
        String _string = prefs.getString("StringValue","codekul.com");


        Log.i(TAG,"Boolean -"+ _boolean + "Float -" + _float + "String -" + _string);

        ((TextView)findViewById(R.id.txtInfo)).setText("Boolean -"+ _boolean + "Float -" + _float + "String -" + _string);
    }

}







