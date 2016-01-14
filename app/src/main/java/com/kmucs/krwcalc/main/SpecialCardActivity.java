package com.kmucs.krwcalc.main;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kmucs.krwcalc.R;

/**
 * Created by harryhong on 16. 1. 14..
 */
public class SpecialCardActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTitlename;
    private TextView mTextConfirm;
    private RelativeLayout mBtnConfirm;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specialcard);

        findViewById(R.id.dotline_1).setLayerType(View.LAYER_TYPE_SOFTWARE, null);

        mTitlename = (TextView)findViewById(R.id.text_titlename);
        mTextConfirm = (TextView)findViewById(R.id.txt_confirm);
        mBtnConfirm = (RelativeLayout)findViewById(R.id.btn_confirm);
        mBtnConfirm.setOnClickListener(this);

        Typeface mHannaType = Typeface.createFromAsset(getAssets(), "BM-HANNA.ttf");
        mTitlename.setTypeface(mHannaType);
        mTextConfirm.setTypeface(mHannaType);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btn_confirm:
                Intent intent = new Intent(getApplicationContext(), CardMgeActivity.class);
                startActivity(intent);
                finish();
        }
    }
}
