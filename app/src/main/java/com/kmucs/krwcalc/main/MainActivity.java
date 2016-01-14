package com.kmucs.krwcalc.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.kmucs.krwcalc.R;
import com.kmucs.krwcalc.lib.Card;
import com.kmucs.krwcalc.lib.CardCompany;
import com.kmucs.krwcalc.lib.NetCompany;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private MainListAdapter mAdapter;

    // mAdapter.notifyDataSetChanged();
    // 리스트 새로고침 역할

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

}