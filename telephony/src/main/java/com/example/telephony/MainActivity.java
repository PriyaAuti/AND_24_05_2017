package com.example.telephony;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.TelecomManager;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TelephonyManager manager;
    private SmsManager smsmanager;
    private PendingIntent intentSent , intentDelivered;

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("com.example.sms.sent")) {
                Toast.makeText(context, "Msg Sent", Toast.LENGTH_SHORT).show();
            } else if (intent.getAction().equals("com.example.sms.delivered")) {
                Toast.makeText(context, "Msg Delivered", Toast.LENGTH_SHORT).show();
            }
        }


    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
        smsmanager =smsmanager.getDefault();

        Intent sent = new Intent("com.example.sms.sent");
        intentSent = PendingIntent.getBroadcast(this,1234,sent,PendingIntent.FLAG_UPDATE_CURRENT);
        Intent delivered = new Intent("com.example.sms.delivered");
        intentDelivered = PendingIntent.getBroadcast(this,6789,delivered,PendingIntent.FLAG_UPDATE_CURRENT);

        IntentFilter filter = new IntentFilter();
        filter.addAction("com.example.sms.sent");
        filter.addAction("com.example.sms.delivered");

        registerReceiver(receiver,filter);
        details();
    }

    private void details(){
        int dataActivity = manager.getDataActivity();
        Log.i("@codekul","Data activity is - "+dataActivity);

        int callState = manager.getCallState();
        Log.i("@codekul","Callstate is - "+callState);

        String imei = manager.getDeviceId();
        Log.i("@codekul","Imei is - "+imei);

        String num = manager.getLine1Number();
        Log.i("@codekul","Num is - "+num);

        String simiso =manager.getSimCountryIso();
        Log.i("@codekul","Sim Iso is - "+simiso);

        String operator =manager.getSimOperator();
        Log.i("@codekul","Operator is - "+operator);

        String operatorName =manager.getSimOperatorName();
        Log.i("@codekul","Operator Name is - "+operatorName);

    }

  public void sendSms(View view){
      smsmanager.sendTextMessage("+919975078425","","Hello :)",intentSent,intentDelivered);

  }
}
