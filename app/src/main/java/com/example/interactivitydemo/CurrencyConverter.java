package com.example.interactivitydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class CurrencyConverter extends AppCompatActivity {

    ProgressDialog pd;
    TextView convertedCurrencyValueEditText;
    float inrValue=0, usdValue=0;

    public void convertCurrency(View view) {

        EditText currencyToConvertEditText = findViewById(R.id.currencyEditText);
        convertedCurrencyValueEditText = findViewById(R.id.currentUSDrateTextView);

        new RetrieveAPITask().execute(currencyToConvertEditText.getText().toString());
    }

    public float getCurrentRate() throws IOException {
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

    @SuppressLint("StaticFieldLeak")
    class RetrieveAPITask extends AsyncTask<String, Void, Void> {

        private Exception exception;
//        private EditText currencyToConvertEditText;

        protected void onPreExecute() {
            super.onPreExecute();

            pd = new ProgressDialog(CurrencyConverter.this);
            pd.setMessage("Please wait... getting current rates");
            pd.setCancelable(false);
            pd.show();
        }

        protected Void doInBackground(String... strings) {
            String url_str = "https://api.exchangerate-api.com/v4/latest/USD";
            URL url = null;
            try {
                url = new URL(url_str);
                Log.d("CurrencyConverter", String.valueOf(url));

                HttpURLConnection request = (HttpURLConnection) url.openConnection();
                request.connect();

                Log.d("--> CurrencyCoverter", String.valueOf(request.toString()));
                // Convert to JSON
                JsonParser jp = new JsonParser();
                Log.d("--> CurrencyCoverter", String.valueOf(request.getContent()));
                JsonObject root = (JsonObject) jp.parse(new InputStreamReader((InputStream) request.getContent()));
                JsonObject rates = root.getAsJsonObject("rates");
                JsonElement INR = rates.get("INR");
                Log.d("--> CurrencyCoverter", "doInBackground: " + INR);

                inrValue = Float.valueOf(INR.getAsString());
                usdValue = Float.valueOf(strings[0]);
                Log.d("--> CurrencyCoverter", "1 USD = " + INR + " INR");

            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }


        @Override
        protected void onPostExecute(Void v) {
            float finalINRvalue = usdValue * inrValue;

            Log.d("--> CurrencyCoverter", usdValue + " USD = " + finalINRvalue + " INR");
            convertedCurrencyValueEditText.setText(String.format("%s USD = %s INR", Float.toString(usdValue), finalINRvalue));

            if (pd.isShowing()){
                pd.dismiss();
            }
        }
    }
}
