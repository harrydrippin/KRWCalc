package com.kmucs.krwcalc.lib;

import android.content.Context;
import android.graphics.drawable.Drawable;
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

    public void makeCard(String mCardName, CardCompany mCardCompany, NetCompany mNetCompany, SpecialCard mSpecialCard, int mCheck) {
        try {
            dbManager.query("INSERT INTO Card VALUES (, " + mCardName + ", " + mCardCompany + ", " + mNetCompany + ", " + mSpecialCard.toString() + ", " + mCheck + ")");
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

    public int getCardDrawable(CardCompany mCardComp, boolean isLined) {

        String resID = "@drawable/card_";

        switch(mCardComp) {
            case SHINHAN:
                resID += "shinhan";
                break;
            case HYUNDAI:
                resID += "hyundai";
                break;
            case SAMSUNG:
                resID += "samsung";
                break;
            case LOTTE:
                resID += "lotte";
                break;
            case KOOKMIN:
                resID += "kookmin";
                break;
            case HANA:
                resID += "hana";
                break;
            case WOORI:
                resID += "woori";
                break;
            case BC:
                resID += "bc";
                break;
            case NH:
                resID += "nh";
                break;
            case CITI:
                resID += "citi";
                break;
            case SC:
                resID += "sc";
                break;
            case BUSAN:
                resID += "busan";
                break;
            case DAEGU:
                resID += "daegu";
                break;
            case GYUNGNAM:
                resID += "gyungnam";
                break;
            case IBK:
                resID += "ibk";
                break;
        }

        if(isLined) {
            resID += "_line";
        }

        String packName = mContext.getPackageName();
        int result = mContext.getResources().getIdentifier(resID, "drawable", packName);

        return result;
    }

    public int getNetDrawable(NetCompany mNetComp) {

        String resID = "@drawable/net_";

        switch(mNetComp) {
            case AMEX:
                resID += "amex";
                break;
            case BCGLOBAL:
                resID += "bcglobal";
                break;
            case JCB:
                resID += "jcb";
                break;
            case MASTER:
                resID += "master";
                break;
            case UNIONPAY:
                resID += "unionpay";
                break;
            case VISA:
                resID += "visa";
                break;
        }

        String packName = mContext.getPackageName();
        int result = mContext.getResources().getIdentifier(resID, "drawable", packName);

        return result;
    }
}
