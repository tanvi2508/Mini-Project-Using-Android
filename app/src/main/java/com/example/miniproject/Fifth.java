package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Fifth extends AppCompatActivity {
    Button b1,b2,b3;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);
        b1=(Button)findViewById(R.id.button12);
        b2=(Button)findViewById(R.id.button13);
        b3=(Button)findViewById(R.id.button14);
        mp=MediaPlayer.create(this,R.raw.media);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.pause();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Fifth.this,Fourth.class);
                startActivity(i);
                finish();
            }
        });



    }
}