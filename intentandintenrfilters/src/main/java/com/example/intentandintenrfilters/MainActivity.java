package com.example.intentandintenrfilters;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClick(View view){
       // all();

       // custom();

        //dial();

        //cal();

        view();

    }


    private void all(){
        Intent intent=new Intent();
        intent.setAction(intent.ACTION_MAIN);
        intent.addCategory(intent.CATEGORY_LAUNCHER);
        startActivity(intent);
    }


    private void custom(){
        Intent intent=new Intent();
        intent.setAction("com.example.intentandintenrfilters.action.Black");
        intent.addCategory("com.example.intentandintenrfilters.category.test");
        startActivity(intent);
    }

    private void dial(){
        Intent intent=new Intent(Intent.ACTION_DIAL);
        startActivity(intent);   //Dial pad will open
    }

    private void cal(){
        Intent intent=new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel://8806165934"));

        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            return;
        }
        startActivity(intent);
    }

    private void view(){
        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.youtube.com/channel/UCkwT4L_Nhl1WoXqAnfwxH3A"));
        startActivity(intent);
    }

}
