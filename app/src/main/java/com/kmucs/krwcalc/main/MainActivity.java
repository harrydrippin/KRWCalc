package com.kmucs.krwcalc.main;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.kmucs.krwcalc.R;
import com.kmucs.krwcalc.lib.Card;
import com.kmucs.krwcalc.lib.CardCompany;
import com.kmucs.krwcalc.lib.NetCompany;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ListView mListView;
    private MainListAdapter mAdapter;

    private TextView mTextTitlename;
    private TextView mLowerPriceIndicator;
    private TextView mTextWon;
    private TextView mLowerPrice;

    private FloatingActionButton mFAB;

    // mAdapter.notifyDataSetChanged();
    // 리스트 새로고침 역할

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Typeface mHannaType = Typeface.createFromAsset(getAssets(), "BM-HANNA.ttf");

        mTextTitlename = (TextView)findViewById(R.id.text_titlename);
        mLowerPriceIndicator = (TextView)findViewById(R.id.textView2);
        mTextWon = (TextView)findViewById(R.id.textView);
        mLowerPrice = (TextView)findViewById(R.id.textView3);

        mTextTitlename.setTypeface(mHannaType);
        mLowerPriceIndicator.setTypeface(mHannaType);
        mTextWon.setTypeface(mHannaType);
        mLowerPrice.setTypeface(mHannaType);

        mFAB = (FloatingActionButton)findViewById(R.id.main_fab);
        mFAB.setOnClickListener(this);

        findViewById(R.id.dotline_1).setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        findViewById(R.id.dotline_2).setLayerType(View.LAYER_TYPE_SOFTWARE, null);

        mListView = (ListView)findViewById(R.id.listview_cardlist);

        mAdapter = new MainListAdapter(this);
        mListView.setAdapter(mAdapter);

        Card card = new Card();
        card.setName("카드 이름");
        card.setCardCompany(CardCompany.HANA);

        mAdapter.addItem(card);
        mAdapter.addItem(card);
        mAdapter.addItem(card);
        mAdapter.addItem(card);
        mAdapter.addItem(card);
        mAdapter.addItem(card);
        mAdapter.addItem(card);
        mAdapter.addItem(card);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.main_fab:
                Intent intent = new Intent(getApplicationContext(), CardMgeActivity.class);
                startActivity(intent);
        }
    }
}