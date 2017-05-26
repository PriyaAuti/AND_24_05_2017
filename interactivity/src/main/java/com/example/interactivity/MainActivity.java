package com.example.interactivity;

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
                String userName = ((EditText) findViewById(R.id.etUserName)).getText().toString();
                String Password = ((EditText) findViewById(R.id.etPassword)).getText().toString();

                if (userName.equalsIgnoreCase("Priya") && Password.equalsIgnoreCase("Priya")) {

                    Bundle bundle = new Bundle();
                    bundle.putString("keyStr", userName);
                    bundle.putInt("keyInt", 123);


                    Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                    intent.putExtras(bundle);


                    //startActivity(intent);

                    startActivityForResult(intent, 4568);
                }
            }
        });
    }
        // Button btnLogin=(Button) findViewById(R.id.btnLogin);
        // btnLogin.setOnClickListener(new View.OnClickListener() {


        // EditText etUserName =(EditText)findViewById(R.id.etUserName);
        // String txtUserName =etUserName.getText().toString();

        // EditText etPassword =(EditText)findViewById(R.id.etPassword);
        // String txtPassword =etPassword.getText().toString();

        //String userName= ((EditText) findViewById(R.id.etUserName))
        // String Password= ((EditText) findViewById(R.id.etPassword))

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 4568) {
            if (resultCode == RESULT_OK) {
                if (data != null) {
                    Bundle bundle = data.getExtras();
                    String res = bundle.getString("keyRes");
                    ((EditText) findViewById(R.id.etUserName)).setText(res);
                }
            }
        }
    }

}




