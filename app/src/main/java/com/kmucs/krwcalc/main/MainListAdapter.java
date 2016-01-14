package com.kmucs.krwcalc.main;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kmucs.krwcalc.R;
import com.kmucs.krwcalc.lib.Card;
import com.kmucs.krwcalc.lib.CardCompany;
import com.kmucs.krwcalc.lib.CardManager;

import java.util.ArrayList;

/**
 * Created by harryhong on 16. 1. 14..
 */
public class MainListAdapter extends BaseAdapter {
    public Context mContext = null;
    public ArrayList<Card> mCardData = new ArrayList<Card>();

    public MainListAdapter(Context mContext) {
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
            convertView = mInflater.inflate(R.layout.view_mainlist, null);

            mViewHolder.mImageView = (ImageView)convertView.findViewById(R.id.img_cardimg);
            mViewHolder.mCardName = (TextView)convertView.findViewById(R.id.txt_cardname);
            mViewHolder.mCardPay = (TextView)convertView.findViewById(R.id.text_pay);

            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder)convertView.getTag();
        }

        Card mCard = mCardData.get(position);
        CardManager mCardManager = new CardManager(mContext);
        mViewHolder.mImageView.setImageResource(mCardManager.getCardDrawable(CardCompany.DAEGU, true));
        mViewHolder.mCardName.setText("국민대학교 학생증 체크카드");
        mViewHolder.mCardPay.setText("1,000");

        return convertView;
    }

    public void addItem(Card card) {
        mCardData.add(card);
    }

    private class ViewHolder {
        public ImageView mImageView;
        public TextView mCardName;
        public TextView mCardPay;

    }
}
