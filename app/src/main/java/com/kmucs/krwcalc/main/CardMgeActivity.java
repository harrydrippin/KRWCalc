package com.kmucs.krwcalc.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.kmucs.krwcalc.R;

/**
 * Created by harryhong on 16. 1. 14..
 */
public class CardMgeActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardmge);
        findViewById(R.id.dotline_1).setLayerType(View.LAYER_TYPE_SOFTWARE, null);
    }
}