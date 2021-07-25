package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Third extends AppCompatActivity implements SensorEventListener{
    Button b1, b2, b3, b4;
    MediaPlayer mp;
    SensorManager sm;
    Sensor s;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        b1 = (Button) findViewById(R.id.button5);
        b2 = (Button) findViewById(R.id.button6);
        b3 = (Button) findViewById(R.id.button7);
        b4 = (Button) findViewById(R.id.button8);
        mp = MediaPlayer.create(this, R.raw.music);
        sm=(SensorManager)getSystemService(SENSOR_SERVICE);
        s=sm.getDefaultSensor(Sensor.TYPE_LIGHT);
        sm.registerListener((SensorEventListener) this,s,SensorManager.SENSOR_DELAY_NORMAL);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Third.this, Fifth.class);
                startActivity(i);
                finish();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Third.this,Sixth.class);
                startActivity(i);
                finish();
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Third.this,Fourteen.class);
                startActivity(i);
                finish();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Third.this, Seventh.class);
                startActivity(i);
                finish();
            }
        });
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if(sensorEvent.values[0]>6)
        {
            mp.start();
        }
        else
        {
            mp.pause();
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

}




