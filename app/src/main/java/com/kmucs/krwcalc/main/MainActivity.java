package com.kmucs.krwcalc.main;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.kmucs.krwcalc.R;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.dotline_1).setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        findViewById(R.id.dotline_2).setLayerType(View.LAYER_TYPE_SOFTWARE, null);

        
    }

}