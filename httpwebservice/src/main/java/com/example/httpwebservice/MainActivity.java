package com.example.httpwebservice;

import android.app.Application;
import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.example.httpwebservice.domain.Wh;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view){
      App app = (App) getApplication();

        String lat = ((EditText)findViewById(R.id.etLat)).getText().toString();
        String lon = ((EditText)findViewById(R.id.etLon)).getText().toString();

        final ProgressDialog pd = ProgressDialog.show(MainActivity.this, "Weather", "Fetching weather data");


        app.q().add(new StringRequest("http://samples.openweathermap.org/data/2.5/weather?lat="+lat+"&lon="+lon+"&appid=8536a5c402eb79666a84a6761492e96c", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.i("@priya","Response is" +response);


                Wh ex = ((App)getApplication()).gson().fromJson(response, com.example.httpwebservice.domain.Wh.class);
                String data = ex.getMain().getTemp() + ", " + ex.getName() + ", " + ex.getSys().getCountry();
                ((TextView)findViewById(R.id.textView3)).setText(data);
                pd.dismiss();


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                pd.dismiss();

            }
        }));
    }
}
