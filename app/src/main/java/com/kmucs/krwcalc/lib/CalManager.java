package com.kmucs.krwcalc.lib;

import java.util.ArrayList;

/**
 * CalManager.java
 * @author Seunghwan Hong
 */
public class CalManager {
    public float getCardFee(CardCompany mCardCompany) {
        return 1.01f;
    }

    public float getNetFee(NetCompany mNetCompany) {
        return 1.01f;
    }

    public ArrayList<Float> calculate(Card card, int money) {
        ArrayList<Float> result = new ArrayList<Float>();
        result.add(5.00f);

        return result;
    }
}