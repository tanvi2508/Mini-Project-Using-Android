package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class Eighth extends AppCompatActivity {
    Button b1,b2;
    RadioButton r1, r2, r3, r4;
    TextView t1;
    static int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eighth);
        t1 = (TextView) findViewById(R.id.textView2);
        b1 = (Button) findViewById(R.id.button17);
        b2 = (Button) findViewById(R.id.button18);
        r1 = (RadioButton) findViewById(R.id.radiobtn);
        r2 = (RadioButton) findViewById(R.id.radiobtn1);
        r3 = (RadioButton) findViewById(R.id.radiobtn2);
        r4 = (RadioButton) findViewById(R.id.radiobtn3);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score = 0;
                if (r3.isChecked()) {
                    ++score;
                } else {
                    --score;
                }
                Intent i = new Intent(Eighth.this, Ninth.class);
                startActivity(i);
                finish();
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Eighth.this, Seventh.class);
                startActivity(i);
                finish();
            }
        });
    }

}