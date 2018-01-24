package com.szumal.tumblrviewer;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.URL;
import java.util.List;

public class postActivity extends AppCompatActivity {

    String postNr;
    TextView postId, postTitle, postText, postTags;
    ImageView postImageView;
    private List<singlePost> postsArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        Intent intent = getIntent();
        postNr = intent.getStringExtra("postNr");

        postId = findViewById(R.id.postID);
        postTitle = findViewById(R.id.postTitle);
        postText = findViewById(R.id.postText);
        postTags = findViewById(R.id.postTags);
        postImageView = findViewById(R.id.postImageView);

        postsArray = functions.posts;


        postId.setText("id: " + postsArray.get(Integer.valueOf(postNr)).getId().toString());
        postTitle.setText("Title: " + postsArray.get(Integer.valueOf(postNr)).getTitle());
        postText.setText("Text: " + postsArray.get(Integer.valueOf(postNr)).getText());
        postTags.setText("Tags: " + postsArray.get(Integer.valueOf(postNr)).getTags());
        try {
            postImageView.setImageBitmap(functions.bitmaps.get(Integer.valueOf(postNr)));
        }catch (Exception e){
            System.out.println("ImageURL" + e.toString());
        }
    }
}
