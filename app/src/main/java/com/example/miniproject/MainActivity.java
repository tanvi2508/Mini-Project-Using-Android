package com.example.miniproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    EditText e1,e2;
    Button b1,b2;
    private FirebaseAuth f1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=(EditText)findViewById(R.id.editText);
        e2=(EditText)findViewById(R.id.editText2);
        e2.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2);
        f1=f1.getInstance();
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,Second.class);
                startActivity(i);
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=e1.getText().toString().trim();
                String s2=e2.getText().toString().trim();
                if(TextUtils.isEmpty(s1))
                {
                    e1.setError("fill username");
                    return;
                }
                else
                {
                    if(TextUtils.isEmpty(s2))
                    {
                        e2.setError("fill password");
                        return;
                    }
                }
                final ProgressDialog dialog=ProgressDialog.show(MainActivity.this,"plzz wait while we connect","connecting",true);
                dialog.dismiss();
                f1.signInWithEmailAndPassword(s1,s2).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "login done", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                            Intent i=new Intent(MainActivity.this,Third.class);
                            startActivity(i);
                            finish();

                        }
                        else
                        {
                            Toast.makeText(MainActivity.this,"not done",Toast.LENGTH_SHORT).show();
                            dialog.dismiss();

                        }
                    }
                });

            }
        });
    }
    }
