package com.example.indiancricketers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class PlayerInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_info);
        findViewById(R.id.imgFav).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (findViewById(R.id.imgFav).getTag().equals("border")) {
                    ((ImageView) findViewById(R.id.imgFav)).setImageResource(R.drawable.ic_favorite_border_black_24dp);
                    findViewById(R.id.imgFav).setTag("filled");
                } else {
                    ((ImageView) findViewById(R.id.imgFav)).setImageResource(R.drawable.ic_favorite_black_24dp);
                    findViewById(R.id.imgFav).setTag("border");
                }
            }
        });
    }

    public void onAdd(View view){
        startActivity(new Intent(this,NewPlayerActivity.class));
        finish();
    }
}
