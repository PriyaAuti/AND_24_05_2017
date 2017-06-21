package com.example.jsonparsing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        parseUsingNativeApi();
    }

    private void parseUsingNativeApi() {
        String json = Util.readAssests(this);
        Log.i("@codekul", "We Have - " + json);

        try {
            JSONObject obj = new JSONObject(json);
            Log.i("@codekul", "Key Int - " + obj.getInt("keyNum"));
            Log.i("@codekul", "Key String - " + obj.getString("keyString"));

            JSONArray adds = obj.getJSONArray("adds");
            for (int i = 0; i < adds.length(); i++) {
                Log.i("@codekul", "Address is - " + adds.getString(i));
            }

            JSONObject mouse = obj.getJSONObject("mouse");
            Log.i("@codekul", "Mouse Name - " + mouse.getString("name"));
            Log.i("@codekul", "Mouse Cost - " + mouse.getInt("cost"));

            JSONArray devices = obj.getJSONArray("devices");
            for (int i = 0; i < devices.length(); i++) {
                JSONObject device = devices.getJSONObject(i);
                Log.i("@codekul", "Name - " + device.getString("name"));
                Log.i("@codekul", "Cost - " + device.getInt("cost"));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
