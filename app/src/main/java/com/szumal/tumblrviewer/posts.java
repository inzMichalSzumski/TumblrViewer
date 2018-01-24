package com.szumal.tumblrviewer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import org.w3c.dom.Document;

public class posts extends AppCompatActivity {

    String userName;
    LinearLayout linearL;


    functions fund = new functions();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);

        Intent intent = getIntent();
        userName = intent.getStringExtra("Username");

        linearL = findViewById(R.id.linearL);


        try {
            fund.getXML(linearL, new AsyncPost().execute(userName).get(), this);
        }catch (Exception e){

        }
    }
}
