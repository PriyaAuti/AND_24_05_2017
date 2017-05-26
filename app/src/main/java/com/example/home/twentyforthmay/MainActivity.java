package com.example.home.twentyforthmay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.home.twentyforthmay.R.id.etPassword;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
        public void onClick(View v) {

         EditText etUsername = (EditText) findViewById(R.id.etUsername);
         String txtUserName = etUsername.getText().toString();


          EditText etPassword=(EditText)findViewById(R.id.etPassword);
           String txtPassword =etPassword.getText().toString();
            TextView textview=(TextView) findViewById(R.id.textView);

            if(txtUserName.equalsIgnoreCase("Android1") && txtPassword.equalsIgnoreCase("Android1"))
                    textview.setText("Successfully login");
                    else textview.setText("Login unsuccessful");





         }
        }
        );


    }
}
