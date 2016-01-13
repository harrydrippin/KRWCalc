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

    public float getCardFee(CardCompany mCardCompany) {
        return mCardCompany.getFee();
    }

    public float getNetFee(NetCompany mNetCompany) {
        return mNetCompany.getFee();
    }

    // 환율 적용 금액, 결제망 수수료, 카드사 수수료, 1원 단위 내림, 예상 결제 금액
    public ArrayList calculate(Card card, float money) {
        ArrayList result = new ArrayList();

        ERParser mParser = new ERParser();
        float mExRate = mParser.getExchangeRate();

        // 환율 적용 금액
        int mResultExchanged = (int)(money * mExRate);
        result.add(mResultExchanged);

        // 결제망 수수료
        float mResultNetFee = mResultExchanged * card.getNetCompany().getFee();
        result.add((int)mResultNetFee);

        // 환율 적용 금액 + 결제망 수수료
        float mResult = mResultExchanged + mResultNetFee;

        // 카드사 수수료
        float mResultCardFee = mResult * card.getCardCompany().getFee();
        result.add((int)mResultCardFee);

        // 환율 적용 금액 + 결제망 수수료 + 카드사 수수료
        mResult = mResult + mResultCardFee;

        // 1원 단위 누락
        float mResultOneWon = (float)(int)(mResult % 10);
        result.add((int)mResultOneWon);

        // 결과
        int mResultFinal = (int)mResult - (int)mResultOneWon;
        result.add(mResultFinal);

        // 인덱스 순서대로 : 환율 적용 금액, 결제망 수수료, 카드사 수수료, 1원 단위 누락된 부분, 결과
        return result;
    }
}