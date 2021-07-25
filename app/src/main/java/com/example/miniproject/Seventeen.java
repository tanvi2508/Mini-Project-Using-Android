package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Seventeen extends AppCompatActivity {
    EditText e1, e2;
    Button b1,b2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seventeen);
        e1=(EditText)findViewById(R.id.edit_source);
        e2=(EditText)findViewById(R.id.edit_dest);
        b1=(Button)findViewById(R.id.btn_search);
        b2=(Button)findViewById(R.id.btn_back);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Seventeen.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=e1.getText().toString().trim();
                String s2=e2.getText().toString().trim();

                if(s1.equals("")&&s2.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Enter both location",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    DisplayTrack(s1,s2);
                }
            }
        });
    }

    private void DisplayTrack(String s1, String s2) {
        try{
            Uri uri=Uri.parse("https://www.google.co.in/maps/dir/"+s1+"/"+s2);
            Intent i=new Intent(Intent.ACTION_VIEW,uri);
            i.setPackage("com.google.android.apps.maps");
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(i);

        }
        catch (ActivityNotFoundException e)
        {
            Uri uri=Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.apps.maps");
            Intent i=new Intent(Intent.ACTION_VIEW,uri);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(i);
        }

    }
}