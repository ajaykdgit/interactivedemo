package com.example.interactivitydemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.TypedArrayUtils;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaTest extends AppCompatActivity {
    List<String> familyMembers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_test);
    }

    public void addMember(View view) {
        int memberNumber = 0;

        // Read new member name
        EditText enterMemberET = findViewById(R.id.enterMembersEditText);
        String enterMemberName = enterMemberET.getText().toString();

        // Add to the array
            familyMembers.add(enterMemberName);
    }

    public void showMember(View view) {

        // Read list first
        TextView memberListTV = findViewById(R.id.memberListTextView);
        String membersList = ""; //memberListTV.getText().toString();

        for (String fm: familyMembers) {
            // Add to the list
            if (membersList.isEmpty()) {
                membersList = fm;
            } else {
                membersList += "\r\n" + fm;
            }

            // Show in the text view
            memberListTV.setText(membersList);
        }
    }
}
