package com.example.bluetoothdemo;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Set;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_ENABLE_BLUETOOTH = 123 ;
    private BluetoothAdapter adapter;

    private BroadcastReceiver receiverDiscover =new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
            String deviceName = device.getName();
            String deviceHardwareAddress = device.getAddress();     //MAC Address

            Log.i("@codekul","Name -"+deviceName+"Mac Address"+deviceHardwareAddress);


        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = BluetoothAdapter.getDefaultAdapter();

        if(adapter == null){
            Toast.makeText(this,"No Bluetooth Support",Toast.LENGTH_SHORT).show();
            return;
        }
            Log.i("@codekul","MyDeviceName - "+adapter.getName()+" "+"MyDeviceAddress -"+adapter.getAddress() );
    }

    @Override
    protected void onStart() {
        super.onStart();

        IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
        registerReceiver(receiverDiscover,filter);
    }

    @Override
    protected void onStop() {
        unregisterReceiver(receiverDiscover);
        super.onStop();
    }

    public void onEnabled(View view){
        if(!adapter.isEnabled()){
            Intent enableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableIntent,REQUEST_ENABLE_BLUETOOTH);
        }

    }

    public void onDiscoverable(View view){
        Intent discoverableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
        discoverableIntent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION,300);
        startActivity(discoverableIntent);
    }

    public void onPaired(View view){
        Set<BluetoothDevice> pairedDevices = adapter.getBondedDevices();
        for(BluetoothDevice pairedDevice : pairedDevices){
            Log.i("@codekul","Device name -"+pairedDevice.getName()+"Device Address -"+pairedDevice.getAddress());
        }
    }

    public void onDiscover(View view){
        adapter.startDiscovery();
    }

    public void onServer(View view){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    BluetoothServerSocket bss = adapter.listenUsingInsecureRfcommWithServiceRecord(
                            "Chatservice",
                            UUID.fromString("00000000-0000-1000-8000-00805F9B34FB")
                    );
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    public void onClient(View view){
        new Thread(new Runnable() {
            @Override
            public void run() {
            BluetoothDevice device = adapter.getRemoteDevice("");
                try {
                    BluetoothSocket socket = device.createRfcommSocketToServiceRecord(
                            UUID.fromString("00000000-0000-1000-8000-00805F9B34FB")
                    );
                    socket.connect();

                    DataInputStream dis = new DataInputStream(socket.getInputStream());
                    String data = dis.readUTF();
                    Log.i("@codekul","Data From Server"+data);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

