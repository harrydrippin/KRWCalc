package com.kmucs.krwcalc.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kmucs.krwcalc.R;
import com.kmucs.krwcalc.lib.Card;
import com.kmucs.krwcalc.lib.CardCompany;
import com.kmucs.krwcalc.lib.CardManager;
import com.kmucs.krwcalc.lib.NetCompany;

import java.util.ArrayList;

/**
 * Created by harryhong on 16. 1. 14..
 */
public class CardListAdapter extends BaseAdapter {
    public Context mContext = null;
    public ArrayList<Card> mCardData = new ArrayList<Card>();

    public CardListAdapter(Context mContext) {
        super();
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mCardData.size();
    }

    @Override
    public Object getItem(int position) {
        return mCardData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder mViewHolder;
        if(convertView == null) {
            mViewHolder = new ViewHolder();

            LayoutInflater mInflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.view_card, null);

            mViewHolder.mCardName = (TextView)convertView.findViewById(R.id.text_cardtitle);
            mViewHolder.mCardCompany = (ImageView)convertView.findViewById(R.id.img_cardcomp);
            mViewHolder.mNetCompany = (ImageView)convertView.findViewById(R.id.img_cardnet);
            mViewHolder.mCheck = (TextView)convertView.findViewById(R.id.text_checkcard);

            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder)convertView.getTag();
        }

        Card mCard = mCardData.get(position);
        CardManager mCardMgr = new CardManager(mContext);

        mViewHolder.mCardName.setText(mCard.getName());
        mViewHolder.mCardCompany.setImageResource(mCardMgr.getCardDrawable(CardCompany.DAEGU, false));
        mViewHolder.mNetCompany.setImageResource(mCardMgr.getNetDrawable(NetCompany.VISA));

        if(mCard.getCheck() == 1) {
            mViewHolder.mCheck.setText("체크카드");
        } else {
            mViewHolder.mCheck.setText("신용카드");
        }
        mViewHolder.mCardName.setSelected(true);

        return convertView;
    }

    public void addItem(Card card) {
        mCardData.add(card);
    }

    private class ViewHolder {
        public TextView mCardName;
        public ImageView mCardCompany;
        public ImageView mNetCompany;
        public TextView mCheck;

    }
}
