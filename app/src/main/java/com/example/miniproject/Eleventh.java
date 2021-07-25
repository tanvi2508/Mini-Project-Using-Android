package com.example.miniproject;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.miniproject.databinding.ActivityEleventhBinding;

public class Eleventh extends AppCompatActivity {
    public static int score;
    Button b1;
    RadioButton r1,r2,r3,r4;
    TextView t1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eleventh);
        t1=(TextView)findViewById(R.id.textView5);
        b1=(Button)findViewById(R.id.button21);
        r1=(RadioButton)findViewById(R.id.radiobtn12);
        r2=(RadioButton)findViewById(R.id.radiobtn13);
        r3=(RadioButton)findViewById(R.id.radiobtn14);
        r4=(RadioButton)findViewById(R.id.radiobtn15);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(r3.isChecked())
                {
                    ++Eighth.score;
                }
                else
                {
                    --Eighth.score;
                }
                Intent i=new Intent(Eleventh.this,Twelfth.class);
                startActivity(i);
                finish();
            }
        });



    }
}