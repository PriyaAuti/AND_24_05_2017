package com.example.indiancricketers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btnLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String UserName=((EditText) findViewById(R.id.etUserName)).getText().toString();
                String Password=((EditText)findViewById(R.id.etPassword)).getText().toString();

                if(UserName.equalsIgnoreCase("Indians")&& Password.equalsIgnoreCase("123")){
                    Bundle bundle=new Bundle();
                    bundle.putString("keyStr",UserName);
                    bundle.putInt("keyInt",123);


                    Intent intent=new Intent(MainActivity.this,ListActivity.class);
                    intent.putExtras(bundle);


                    startActivityForResult(intent,4568);
                }
            }
        });
    }

    public void onLogin(View view) {
        startActivity(new Intent(this,ListActivity.class));
    }
}
