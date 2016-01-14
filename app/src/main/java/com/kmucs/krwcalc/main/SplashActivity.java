package com.kmucs.krwcalc.main;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.kmucs.krwcalc.R;
import com.kmucs.krwcalc.lib.ERParser;

/**
 * Created by harryhong on 16. 1. 14..
 */
public class SplashActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

    }

    public class MyAsyncTask extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {
            float mUSD = ERParser.getExchangeRate("USD");
            float mJPY = ERParser.getExchangeRate("JPY");
            float mCNY = ERParser.getExchangeRate("CNY");

            String result = mUSD + "" + mJPY + "" + mCNY;
            return result;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }

    }

}
