package com.kmucs.krwcalc.main;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.kmucs.krwcalc.R;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //클래스설정
        TextView mText_Titlename = (TextView) findViewById(R.id.text_titlename);
        TextView mText_Chippricename = (TextView) findViewById(R.id.text_chippricename);
        TextView mText_Chipprice = (TextView) findViewById(R.id.text_chipprice);
        TextView mText_Won = (TextView) findViewById(R.id.text_won);

        //dotline fix
        findViewById(R.id.dotline_1).setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        findViewById(R.id.dotline_2).setLayerType(View.LAYER_TYPE_SOFTWARE, null);

        //폰트설정
        Typeface mTextfont = Typeface.createFromAsset(getApplicationContext().getAssets(), "BM-HANNA.ttf");
        mText_Titlename.setTypeface(mTextfont);
        mText_Chipprice.setTypeface(mTextfont);
        mText_Chippricename.setTypeface(mTextfont);
        mText_Won.setTypeface(mTextfont);



        
    }

}