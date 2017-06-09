package com.example.indiancricketers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class NewPlayerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_player);
    }

    public void onAdd(View view){
        Db.items.add(new CustomItem(R.mipmap.ic_launcher,"new player","30","Indian Cricket Player"));


        /*ArrayAdapter<String> adapter = (ArrayAdapter<String>) ((ListView) findViewById(R.id.listPlayers)).getAdapter();
        adapter.add(((EditText) findViewById(R.id.etNm)).getText().toString());
        adapter.add(((EditText) findViewById(R.id.etAg)).getText().toString());
        adapter.add(((EditText) findViewById(R.id.etDec)).getText().toString());

        adapter.notifyDataSetChanged();*/
    }
}
