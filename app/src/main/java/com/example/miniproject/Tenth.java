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

import com.example.miniproject.databinding.ActivityTenthBinding;

public class Tenth extends AppCompatActivity {
    public static int score;
    Button b1;
    RadioButton r1,r2,r3,r4;
    TextView t1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenth);
        t1=(TextView)findViewById(R.id.textView4);
        b1=(Button)findViewById(R.id.button20);
        r1=(RadioButton)findViewById(R.id.radiobtn8);
        r2=(RadioButton)findViewById(R.id.radiobtn9);
        r3=(RadioButton)findViewById(R.id.radiobtn10);
        r4=(RadioButton)findViewById(R.id.radiobtn11);
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
                Intent i=new Intent(Tenth.this,Eleventh.class);
                startActivity(i);
                finish();
            }
        });
    }
}



