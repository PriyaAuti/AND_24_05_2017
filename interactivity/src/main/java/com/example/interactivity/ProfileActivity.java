package com.example.interactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Intent responsibleIntent = getIntent();
        Bundle bundle = responsibleIntent.getExtras();
        if (bundle != null) {
            String userName = bundle.getString("keyStr");
            ((TextView) findViewById(R.id.etText)).setText(userName);
        }

        findViewById(R.id.btnBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle = new Bundle();
                bundle.putString("keyRes", getDeviceName());

                Intent intent = new Intent();
                intent.putExtras(bundle);
                setResult(RESULT_OK, intent);
                finish();

            }
        });
    }

    private String getDeviceName() {
        return ((RadioGroup) findViewById(R.id.radioGroup)).getCheckedRadioButtonId() == R.id.rbMobile ? "Mobile" : "RPI";
    }
}



