package com.example.interactivitydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class ImageActivity extends AppCompatActivity {
    int dogImageNum = 1;

    public void showName(View view){
        EditText userNameEditText = findViewById(R.id.usernameEditText);
        Log.i("Info", "Welcome " + userNameEditText.getText().toString());
        Toast.makeText(this, "Welcome " + userNameEditText.getText().toString(), Toast.LENGTH_LONG).show();
    }

    public void changePicFunc(View view) {
        ImageView dogImageView = findViewById(R.id.dogPicImageView);
        if (dogImageNum == 1) {
            dogImageView.setImageResource(R.drawable.dog2);
            dogImageNum = 2;
        } else {
            dogImageView.setImageResource(R.drawable.dog1);
            dogImageNum = 1;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
    }
}
