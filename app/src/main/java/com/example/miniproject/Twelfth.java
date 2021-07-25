package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class Twelfth extends AppCompatActivity {
    Button b1;
    RadioButton r1,r2,r3,r4;
    TextView t1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twelfth);
        t1=(TextView)findViewById(R.id.textView6);
        b1=(Button)findViewById(R.id.button22);
        r1=(RadioButton)findViewById(R.id.radiobtn16);
        r2=(RadioButton)findViewById(R.id.radiobtn17);
        r3=(RadioButton)findViewById(R.id.radiobtn18);
        r4=(RadioButton)findViewById(R.id.radiobtn19);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(r1.isChecked())
                {
                    ++Eighth.score;
                }
                else
                {
                    --Eighth.score;
                }
                Intent i=new Intent(Twelfth.this,Thirteen.class);
                startActivity(i);
                finish();
            }
        });




    }
}