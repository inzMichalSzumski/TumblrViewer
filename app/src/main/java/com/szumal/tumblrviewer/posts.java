package com.szumal.tumblrviewer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

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

        fund.getXML(linearL, userName, this);
    }
}
