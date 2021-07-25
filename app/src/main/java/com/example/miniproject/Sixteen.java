package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Sixteen extends AppCompatActivity {
    Button b1, b2;
    EditText e1, e2, e3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixteen);
        e1 = (EditText) findViewById(R.id.edit_to);
        e2 = (EditText) findViewById(R.id.edit_from);
        e3 = (EditText) findViewById(R.id.edit_subject);
        b1 = (Button) findViewById(R.id.button32);
        b2 = (Button) findViewById(R.id.button33);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = e1.getText().toString().trim();
                String s2 = e2.getText().toString().trim();
                String s3 = e3.getText().toString().trim();
                sendMail(s1, s2, s3);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Sixteen.this,Seventeen.class);
                startActivity(i);
                finish();
            }
        });
    }

    private void sendMail(String s1, String s2, String s3) {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setData(Uri.parse("mail to:"));
        i.putExtra(Intent.EXTRA_EMAIL, new String[]{s1});
        i.putExtra(Intent.EXTRA_SUBJECT, s2);
        i.putExtra(Intent.EXTRA_TEXT, s3);
        i.setType("text/plain");
        try {
            startActivity(Intent.createChooser(i, "choose an email client:"));
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


}