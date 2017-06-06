package com.example.viewanimations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnAnimate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  Animation animation= AnimationUtils.loadAnimation(context:MainActivity.this,R.anim.mixani);
            }
        });

    }

}
