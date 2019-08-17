package com.example.interactivitydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class InterActivityDemo extends AppCompatActivity {

    public void showUserCredentials(View view)
    {
        EditText nameEditText = findViewById(R.id.userNameEditText);
        EditText pwdEditText = findViewById(R.id.pwdEditText);

        Log.i("Message", "You've Done it!");
        Log.i("User: ", nameEditText.getText().toString());
        Log.i("Pwd: ", pwdEditText.getText().toString());

        Toast.makeText(this, "Hello, " + nameEditText.getText().toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inter_demo);
    }
}
