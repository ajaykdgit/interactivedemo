package com.example.interactivitydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class TriangularNumbers extends AppCompatActivity {
    int imageSequence = 0;
    ImageView TNDefinitionIV;
    Button btnShowDefinition, showTNButton;
    TextView showNumberTextView;
    EditText numberOfTNEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangular_numbers);
    }

    @Override
    protected void onStart() {
        super.onStart();
        String numOfTNtoShow = "10";

        TNDefinitionIV = findViewById(R.id.TNImageView);
        btnShowDefinition = findViewById(R.id.showDefinitionButton);
        numberOfTNEditText = findViewById(R.id.numberOfTNEditText);
        showNumberTextView = findViewById(R.id.textView11);
        showTNButton = findViewById(R.id.showTNButton);

        showNumberTextView.setVisibility(View.INVISIBLE);
        numberOfTNEditText.setVisibility(View.INVISIBLE);
        TNDefinitionIV.setVisibility(View.INVISIBLE);
        showTNButton.setVisibility(View.INVISIBLE);

        numberOfTNEditText.setText(numOfTNtoShow);

    }

    public void showDefinition(View view) {
        imageSequence++;
        TNDefinitionIV.setVisibility(View.VISIBLE);
        showTNButton.setVisibility(View.VISIBLE);
        showNumberTextView.setVisibility(View.VISIBLE);
        numberOfTNEditText.setVisibility(View.VISIBLE);

        if (imageSequence == 1) {
            TNDefinitionIV.setImageResource(R.drawable.triangular_numbers_11);
            btnShowDefinition.setText("Show Next Definition");
        } else if (imageSequence == 2) {
            TNDefinitionIV.setImageResource(R.drawable.triangular_numbers_13);
        } else {
            TNDefinitionIV.setImageResource(R.drawable.triangular_numbers_14);
            imageSequence = 0;
        }
    }

    public void showTnumbers(View view) {
        int TNnumber=1, nextNumber=2;
        TextView TNTextView = findViewById(R.id.triangularNumbersTextView);
        String informationToShow="";

        for(int x=1; x<=10; x++) {
            if (x==1) {
                informationToShow = "  " + TNnumber;
            } else {
                TNnumber = TNnumber + x;
                informationToShow = informationToShow + ", " + TNnumber ;
            }
        }

        TNTextView.setText(informationToShow);
    }
}
