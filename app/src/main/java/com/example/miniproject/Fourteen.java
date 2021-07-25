package com.example.miniproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Fourteen extends AppCompatActivity {
    private static final int REQUEST_CALL=1;
    EditText e1;
    ImageView i1;
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourteen);
        e1=(EditText)findViewById(R.id.edit_mobile);
        i1=(ImageView)findViewById(R.id.imageView5);
        b1=(Button)findViewById(R.id.buttoncall);
        b2=(Button)findViewById(R.id.buttonnext);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Fourteen.this,Fifteen.class);
                startActivity(i);
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makePhoneCall();
            }
        });

    }

    private void makePhoneCall()
    {
        String num=e1.getText().toString();
        if(num.trim().length()>0)

        {
            if(ContextCompat.checkSelfPermission(Fourteen.this, android.Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED)
            {
                ActivityCompat.requestPermissions(Fourteen.this,new String[]{android.Manifest.permission.CALL_PHONE},REQUEST_CALL);
            }
            else{
                String dial="tel:"+num;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }

        }
        else
        {
            Toast.makeText(Fourteen.this, "Enter Phone Number", Toast.LENGTH_SHORT).show();
        }
    }


    public void onRequestPermissionResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode==REQUEST_CALL)
        {
            if(grantResults.length>0 &&grantResults[0]==PackageManager.PERMISSION_GRANTED)
            {
                makePhoneCall();
            }
            else {
                Toast.makeText(this,"Permission Denied",Toast.LENGTH_SHORT).show();
            }
        }

    }
}

