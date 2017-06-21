package com.example.service;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * helper methods.
 */
public class MyIntentService extends IntentService {

    public MyIntentService()
    {
        super("MyIntentService");
    }
    @Override
    protected void onHandleIntent(Intent intent) {

    }
}
