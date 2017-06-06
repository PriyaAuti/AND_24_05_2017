package com.example.fragmentsdemo;

import android.support.v4.app.Fragment;
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
      //  txn.replace(R.id.frameContainer,new MyFragment());  //Our created fragment named "MyFragment" is added into the frame(having id framecontainer)
            txn.replace(R.id.frameContainer,MyFragment.getInstance("Done !!!"));
        txn.commit();
    }
}
