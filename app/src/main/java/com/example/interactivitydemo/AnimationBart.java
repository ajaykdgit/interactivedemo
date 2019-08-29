package com.example.interactivitydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.Delayed;

public class AnimationBart extends AppCompatActivity {
    boolean whichImageIsDisplayed = true;

    public void startAnimation(View view) {
        ImageView bartSimpsonIV = findViewById(R.id.bartSimpsonIimageView);
        ImageView holmerSimpsonIimageView = findViewById(R.id.holmerSimpsonIimageView);

        bartSimpsonIV.animate().alpha(0).scaleX((float) 0.4).scaleY((float) 0.4);
        bartSimpsonIV.animate().translationX(-1000);
        bartSimpsonIV.animate().alpha(1).translationX(1000).rotation(1800).setDuration(2000);
    }


    public void changeImage(View view) {
        ImageView bartSimpsonIV = findViewById(R.id.bartSimpsonIimageView);
        ImageView holmerSimpsonIimageView = findViewById(R.id.holmerSimpsonIimageView);

        if (whichImageIsDisplayed) {
            bartSimpsonIV.animate().alpha(0).setDuration(2000);
            holmerSimpsonIimageView.animate().alpha(1).setDuration(2000);
            whichImageIsDisplayed = false;
//            bartSimpsonIV.setImageResource(R.drawable.bart_simpson_101);
        } else {
            bartSimpsonIV.animate().alpha(1).setDuration(2000);
            holmerSimpsonIimageView.animate().alpha(0).setDuration(2000);
            whichImageIsDisplayed = true;
//            bartSimpsonIV.setImageResource(R.drawable.bart_simpson_100);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_bart);
    }

}
