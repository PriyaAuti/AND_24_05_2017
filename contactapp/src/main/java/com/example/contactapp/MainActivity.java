package com.example.contactapp;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // readPhoneContacts();
        mydata();
    }


    private void readPhoneContacts(){
        List<String> contacts = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,contacts);

        ContentResolver resolver = getContentResolver();
        Cursor cursor = resolver.query(
                ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                new String[]{ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,ContactsContract.CommonDataKinds.Phone.NUMBER},
                null,
                null,
                null
        );

        while (cursor.moveToNext()){
           String name =  cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String number = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

            contacts.add(name + "\n" + number);

        }
        ((ListView)findViewById(R.id.listview)).setAdapter(adapter);
    }




    private void mydata(){


        //ContentProvider is added into squlite module..

        List<String> contacts = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,contacts);

        ContentResolver resolver = getContentResolver();
        Cursor cursor = resolver.query(
                Uri.parse("content://com.example.read.PROJECT"),
                new String[]{
                        "devNm",
                        "desg",
                        "proj"
                },
                null,
                null,
                null

        );
        if(cursor != null){
            while (cursor.moveToNext()){
                String devNm = cursor.getString(cursor.getColumnIndex("devNm"));
                int desg = cursor.getInt(cursor.getColumnIndex("desg"));
                String proj = cursor.getString(cursor.getColumnIndex("proj"));
                contacts.add(devNm + "\n" + desg + "\n" + proj);

            }
        }
        ((ListView)findViewById(R.id.listview)).setAdapter(adapter);


    }
}
