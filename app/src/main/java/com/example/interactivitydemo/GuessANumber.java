package com.example.interactivitydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class GuessANumber extends AppCompatActivity {
    int systemGeneratedNumber = 0;
    EditText gnEditText;
    Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_anumber);

        random = new Random();
        getRandom();
        gnEditText = findViewById(R.id.guessNumberEditText);
    }


    public void checkTheNumber(View view) {
        int userGuess=0;
        String msg = "";

        if(gnEditText.getText().toString().isEmpty()) {
            msg = "Enter your guess!";
        } else {
            userGuess = Integer.parseInt(gnEditText.getText().toString());
            if (userGuess < systemGeneratedNumber) {
                msg = "Higher";
            } else if (userGuess > systemGeneratedNumber) {
                msg = "Lower";
            } else {
                msg = "You Nailed It!";
            }
        }
        showToast(msg);
    }

    public void resetNumber(View view) {
        getRandom();
        gnEditText.setText("");
    }

    public void getRandom() {
        while (true) {
            systemGeneratedNumber = random.nextInt(20);
            if (systemGeneratedNumber != 0) break;
        }
    }

    private void showToast(String messageToShow) {
        Toast toast = Toast.makeText(this, messageToShow, Toast.LENGTH_SHORT);

        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
}
