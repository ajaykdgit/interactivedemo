package com.example.interactivitydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button welcomeNextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the button and attach click event
        welcomeNextButton = findViewById(R.id.welcomeNextButton);
        welcomeNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MyNavActivity.class);
//                Intent intent = new Intent(MainActivity.this, InterActivityDemo.class);
//                Intent intent = new Intent(MainActivity.this, ImageActivity.class);
//                Intent intent = new Intent(MainActivity.this, CurrencyConverter.class);
                startActivity(intent);
            }
        });
    }
}
