package com.example.httpwebservice;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.lang.ref.ReferenceQueue;

/**
 * Created by Home on 6/22/2017.
 */

public class App extends Application {
    private Gson gson;
    private RequestQueue queue;


    @Override
    public void onCreate() {
        super.onCreate();

        gson = new Gson();
        queue = Volley.newRequestQueue(this);
    }

    public Gson gson() {
        return gson;
    }

    public RequestQueue q() {
        return queue;
    }

}
