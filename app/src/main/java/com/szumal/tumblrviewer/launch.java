package com.szumal.tumblrviewer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class launch extends AppCompatActivity {

    Button showPostsBtn;
    EditText editTextPlnTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        showPostsBtn = findViewById(R.id.showPostsBtn);
        showPostsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToPosts();
            }
        });
        editTextPlnTxt = findViewById(R.id.editTextPlnTxt);
    }

    void goToPosts(){
        Intent _intent = new Intent(this, posts.class);
        _intent.putExtra("Username", editTextPlnTxt.getText().toString());
        startActivity(_intent);
    }
}
