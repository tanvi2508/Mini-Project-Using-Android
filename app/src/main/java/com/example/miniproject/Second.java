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

public class Second extends AppCompatActivity {
    EditText e1, e2, e3, e4;
    Button b1, b2;
    private FirebaseAuth f1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        e1 = (EditText) findViewById(R.id.editText3);
        e2 = (EditText) findViewById(R.id.editText4);
        e3 = (EditText) findViewById(R.id.editText5);
        e4 = (EditText) findViewById(R.id.editText6);
        e3.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        b1 = (Button) findViewById(R.id.button3);
        b2 = (Button) findViewById(R.id.button4);
        f1 = f1.getInstance();
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Second.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = e1.getText().toString().trim();
                String s2 = e2.getText().toString().trim();
                String s3 = e3.getText().toString().trim();
                String s4 = e4.getText().toString().trim();


                if (TextUtils.isEmpty(s1)) {
                    e1.setError("fill username");
                    return;
                } else if (TextUtils.isEmpty(s2)) {
                    e2.setError("fill email");
                    return;
                } else if (TextUtils.isEmpty(s3)) {
                    e3.setError("fill password");
                    return;
                } else if (TextUtils.isEmpty(s4)) {
                    e4.setError("fill phone");
                    return;
                }


                final ProgressDialog dialog = ProgressDialog.show(Second.this, "plzz wait while we connect", "connecting", true);
                dialog.dismiss();

                f1.createUserWithEmailAndPassword(s2, s3).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Second.this, "login done", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                            Intent i=new Intent(Second.this,Third.class);
                            startActivity(i);
                            finish();

                        } else {
                            Toast.makeText(Second.this, "not done", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();

                        }
                    }
                });

            }
        });
    }

}