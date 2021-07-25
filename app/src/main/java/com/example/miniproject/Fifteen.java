package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Fifteen extends AppCompatActivity {
    Button b1,b2,b3,b4;
    ImageView i1;
    private WifiManager w1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifteen);
        b1 = (Button) findViewById(R.id.button28);
        b2 = (Button) findViewById(R.id.button29);
        b3 = (Button) findViewById(R.id.button30);
        i1=(ImageView)findViewById(R.id.imageView6);
        b4 = (Button) findViewById(R.id.button31);
        w1=(WifiManager)getApplicationContext().getSystemService(WIFI_SERVICE);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Fifteen.this, Sixteen.class);
                startActivity(i);
                finish();
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j=new Intent(Fifteen.this,Fourteen.class);
                startActivity(j);
                finish();
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wifion();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wifioff();
            }
        });

    }
    private void wifion()
    {
        w1.setWifiEnabled(true);
        Toast.makeText(Fifteen.this,"Wifi On",Toast.LENGTH_SHORT).show();

    }
    private  void wifioff() {
        w1.setWifiEnabled(false);
        Toast.makeText(Fifteen.this, "Wifi Off", Toast.LENGTH_SHORT).show();
    }




    }
