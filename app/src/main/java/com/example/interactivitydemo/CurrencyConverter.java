package com.example.interactivitydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CurrencyConverter extends AppCompatActivity {

    public void convertCurrency(View view) {
        EditText currencyToConvertEditText = findViewById(R.id.currencyEditText);
        int userCurrency = Integer.parseInt(currencyToConvertEditText.getText().toString());

        String userConvertedCurrency = Integer.toString(userCurrency * 67);
        Toast.makeText(this, "INR: " + userConvertedCurrency, Toast.LENGTH_LONG).show();

        getCurrentRate();
    }

    public float getCurrentRate() {
        // Setting URL
        String url_str = "https://api.exchangerate-api.com/v4/latest/USD";

        // Making Request
        URL url = new URL(url_str);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        // Convert to JSON
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonobj = root.getAsJsonObject();

        // Accessing object
        String req_result = jsonobj.get("result").getAsString();
        Log.i("Currency Rate", req_result);
        return 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_converter);
    }
}
