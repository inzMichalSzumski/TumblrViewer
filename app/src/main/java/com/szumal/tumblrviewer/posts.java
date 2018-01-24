package com.szumal.tumblrviewer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class posts extends AppCompatActivity {

    String userName;
    ListView postsList;
    LinearLayout linearL;

    List<singlePost> posts = new ArrayList<singlePost>();
    List<Button> btnWord = new ArrayList<Button>();

    functions fund = new functions();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);

        Intent intent = getIntent();
        userName = intent.getStringExtra("Username");

        linearL = findViewById(R.id.linearL);

        //posts.add(new singlePost(1l, "tit", "tex", "tag", "imgule", "1.1.1990"));

        fund.getXML(linearL, userName, this);
        //functions.buttonMaker(linearL, posts.get(0).title, this);

        //System.out.println("xyz " + fund.btnContainer.size());
        /*btnWord[0] = new Button(this);
        btnWord[0].setText(userName);
        linearL.addView(btnWord[0]);*/

        /*cars[0] = posts[0].getTitle();
        // Get the Intent that started this activity and extract the string


        postsList = findViewById(R.id.postsList);

        ArrayList<String> carL = new ArrayList<String>();
        carL.addAll( Arrays.asList(cars) );

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.postfragment, carL);


        postsList.setAdapter(adapter);*/
    }
}
