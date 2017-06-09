package com.example.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        custom();
        //simple();


    }


    public void addCountry(View view) {
        ArrayAdapter<String> adapter = (ArrayAdapter<String>) ((ListView) findViewById(R.id.lstCountries)).getAdapter();
        adapter.add(((EditText) findViewById(R.id.etCountry)).getText().toString());
        adapter.notifyDataSetChanged();
    }


    private void simple() {


        List<String> dataSet = new ArrayList<>();
        dataSet.add("India");
        dataSet.add("Sri Lanka");
        dataSet.add("China");
        dataSet.add("Pak");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dataSet);
        ((ListView) findViewById(R.id.lstCountries)).setAdapter(adapter);

        ((ListView) findViewById(R.id.lstCountries)).setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ArrayAdapter<String> adapterLocal = (ArrayAdapter<String>) parent.getAdapter();
                String con = adapterLocal.getItem(position);
                ((EditText) findViewById(R.id.etCountry)).setText(con);
            }
        });

    }

    private void custom(){

        List<MyItem> dataSet=new ArrayList<>();
        dataSet.add(new MyItem(R.mipmap.ic_launcher,"Sachin"));
        dataSet.add(new MyItem(R.mipmap.ic_launcher,"Mahi"));


        MyAdapter adapter=new MyAdapter(this,dataSet);
        ((ListView)findViewById(R.id.lstCountries)).setAdapter(adapter);
    }

}


