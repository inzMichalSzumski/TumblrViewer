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
    URL imageURL;
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


        postId.setText(postsArray.get(Integer.valueOf(postNr)).getId().toString());
        postTitle.setText(postsArray.get(Integer.valueOf(postNr)).getTitle().toString());
        postText.setText(postsArray.get(Integer.valueOf(postNr)).getText().toString());
        postTags.setText(postsArray.get(Integer.valueOf(postNr)).getTags().toString());
        try {
            imageURL = new URL(postsArray.get(Integer.valueOf(postNr)).getImgurl().toString());
            Bitmap bmp = BitmapFactory.decodeStream(imageURL.openConnection().getInputStream());
            postImageView.setImageBitmap(bmp);
        }catch (Exception e){
            System.out.println("ImageURL" + e.toString());
        }
    }



}
