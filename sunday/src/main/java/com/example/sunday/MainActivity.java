package com.example.sunday;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        runFragTxn();
    }
    private void runFragTxn(){
        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction txn=manager.beginTransaction();
        txn.add(R.id.frameContainer,new MyFragment());
        txn.commit();
    }
}
