package com.example.indiancricketers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);



        Db.items.add(new CustomItem(R.drawable.sachin, "Sachin Tendulkar", "44 Years", "Indian Cricketer"));
        Db.items.add(new CustomItem(R.drawable.ms, "M.S.Dhoni", "35 Years", "Indian Cricketer"));
        Db.items.add(new CustomItem(R.drawable.virat, "Virat Kohli", "28 Years", "Indian Cricketer"));
        Db.items.add(new CustomItem(R.drawable.singh, "Yuvraj Singh", "35 Years", "Indian Cricketer..."));
        Db.items.add(new CustomItem(R.drawable.gautam, "Gautam Gambhir", "35 Years", "Indian Cricketer !"));
        Db.items.add(new CustomItem(R.mipmap.ic_launcher, "Android", "12", ""));

        final CustomAdapter adapter = new CustomAdapter(this, Db.items);

        ((ListView) findViewById(R.id.listPlayers)).setAdapter(adapter);

        ((ListView) findViewById(R.id.listPlayers)).setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                CustomItem clickedItem = (CustomItem) adapter.getItem(position);

                startActivityForResult(new Intent(ListActivity.this, PlayerInfoActivity.class), 586);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        ((CustomAdapter)((ListView)findViewById(R.id.listPlayers)).getAdapter()).notifyDataSetChanged();
    }
}
