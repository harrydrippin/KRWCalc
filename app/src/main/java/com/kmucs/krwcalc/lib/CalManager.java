package com.kmucs.krwcalc.lib;

import android.content.Context;

import java.util.ArrayList;

/**
 * CalManager.java
 * @author Seunghwan Hong
 */

public class CalManager {

    private Context m;

    public CalManager(Context m) {
        this.m = m;
    }

    // 환율 적용 금액, 결제망 수수료, 카드사 수수료, 1원 단위 내림, 예상 결제 금액
    public ArrayList<Float> calculate(Card card, int money) {
        ArrayList<Float> result = new ArrayList<Float>();

        return result;
    }
}