package com.example.runtimeapppermissions;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.preference.DialogPreference;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


//Using this you dont need to go to app manager and to set permissions manually.
// The app will ask for permisssions wheneven it will require,, by poping up the dialog box.








public class MainActivity extends AppCompatActivity {

    public static final int REQ_CAL_PHONE = 4567;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CALL_PHONE)) {
                AlertDialog dialog = new AlertDialog.Builder(this)
                        .setTitle("Permission")
                        .setMessage("Need Your Permission For Calling ...")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                ActivityCompat.requestPermissions(MainActivity.this,
                                        new String[]{Manifest.permission.CALL_PHONE}, REQ_CAL_PHONE);

                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }

                        })
                        .create();
                dialog.show();
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, REQ_CAL_PHONE);
            }
        }
            else {
                Intent intent=new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel://8806165934"));
                startActivity(intent);
            }
        }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == REQ_CAL_PHONE){
            if(grantResults[0]==PackageManager.PERMISSION_GRANTED){
                onClick(null);
            }
        }
    }
}



