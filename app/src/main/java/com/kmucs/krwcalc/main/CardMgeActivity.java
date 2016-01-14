package com.kmucs.krwcalc.main;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.kmucs.krwcalc.R;
import com.kmucs.krwcalc.lib.Card;
import com.kmucs.krwcalc.lib.CardCompany;
import com.kmucs.krwcalc.lib.NetCompany;

/**
 * Created by harryhong on 16. 1. 14..
 */

public class CardMgeActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTitle;
    private ListView mListView;
    private CardListAdapter mAdapter;
    private FloatingActionButton mFAB;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardmge);
        findViewById(R.id.dotline_1).setLayerType(View.LAYER_TYPE_SOFTWARE, null);

        mTitle = (TextView)findViewById(R.id.text_titlename);
        mListView = (ListView)findViewById(R.id.list_mge);
        mFAB = (FloatingActionButton)findViewById(R.id.card_fab);

        mFAB.setOnClickListener(this);

        mAdapter = new CardListAdapter(this);

        mListView.setAdapter(mAdapter);

        Card mCard = new Card();
        mCard.setName("국민대학교 학생증 체크카드");
        mCard.setCardCompany(CardCompany.SHINHAN);
        mCard.setNetCompany(NetCompany.VISA);
        mCard.setCheck(0);

        mAdapter.addItem(mCard);
        mAdapter.addItem(mCard);
        mAdapter.addItem(mCard);
        mAdapter.addItem(mCard);
        mAdapter.addItem(mCard);

        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           int pos, long id) {
                // TODO Auto-generated method stub

                Toast.makeText(CardMgeActivity.this, "롱 클릭 감지 : " + (pos+1) + "번째 항목", Toast.LENGTH_SHORT).show();

                return true;
            }
        });


        Typeface mHannaType = Typeface.createFromAsset(getAssets(), "BM-HANNA.ttf");
        mTitle.setTypeface(mHannaType);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.card_fab:
                Intent intent = new Intent(getApplicationContext(), CardAddActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}