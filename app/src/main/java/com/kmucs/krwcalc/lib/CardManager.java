package com.kmucs.krwcalc.lib;

import android.content.Context;
import android.util.Log;

/**
 * CardManager.java
 * @author Seunghwan Hong
 */

public class CardManager {

    private Context mContext;
    private DBManager dbManager;

    public CardManager(Context mContext) {
        this.mContext = mContext;
        dbManager = new DBManager(mContext, "Card.db", null, 1);
    }

    public void makeCard(String mCardName, CardCompany mCardCompany, NetCompany mNetCompany, SpecialCard mSpecialCard) {
        try {
            dbManager.query("INSERT INTO Card VALUES (, " + mCardName + ", " + mCardCompany + ", " + mNetCompany + ", " + mSpecialCard.toString());
        } catch(Exception e) {
            Log.e("KRWCalcDB", "Making Card Error");
        }
    }

    public void deleteCard(String mCardName) {
        try {
            dbManager.query("DELETE FROM Card WHERE name = " + mCardName);
        } catch(Exception e) {
            Log.e("KRWCalcDB", "Delete Card Error");
        }
    }

    public String getCardInfo() {
        return dbManager.getData();
    }
}
