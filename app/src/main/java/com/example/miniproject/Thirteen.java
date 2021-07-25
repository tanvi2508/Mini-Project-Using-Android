package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

public class Thirteen extends AppCompatActivity {
    TextView t1;
   Button b1,b2,b3,b4;
    WebView w1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thirteen);
        t1 = (TextView) findViewById(R.id.textView7);
        t1.setText("Your score is" + Eighth.score);
        b1 = (Button) findViewById(R.id.button23);
        b2 = (Button) findViewById(R.id.button24);
        b3 = (Button) findViewById(R.id.button25);
        b4 = (Button) findViewById(R.id.button26);
        w1 = (WebView) findViewById(R.id.webView);

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Thirteen.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                w1.loadUrl("https://www.facebook.com");
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                w1.loadUrl("https://www.twitter.com");
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                w1.loadUrl("https://www.linkedin.com");
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK &&this.w1.canGoBack()){
            this.w1.goBack();
            return true;

        }
        return super.onKeyDown(keyCode,event);

    }
}