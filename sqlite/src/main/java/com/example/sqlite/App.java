package com.example.sqlite;

import android.app.Application;

/**
 * Created by Home on 6/15/2017.
 */

public class App extends Application{
    private DbHelper helper;

    @Override
    public void onCreate() {
        super.onCreate();

        helper = new DbHelper(this,"code.sqlite",null,1);
    }

    public DbHelper helper(){
        return helper;
    }
}
