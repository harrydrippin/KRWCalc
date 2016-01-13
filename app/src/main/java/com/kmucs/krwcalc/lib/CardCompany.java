package com.kmucs.krwcalc.lib;

/**
 * CardCompany.java
 * @author Seunghwan Hong
 */
public enum CardCompany {
    SHINHAN(0.25f), HYUNDAI(0.35f), SAMSUNG(0.18f), LOTTE(0.35f), KOOKMIN(0.30f), HANA(0.20f), WOORI(0.25f), BC(0.20f), NH(0.20f), CITI(0.18f), SC(0.35f), BUSAN(0.35f), DAEGU(0.35f), GYUNGNAM(0.18f), IBK(0.18f);
    private float fee;

    CardCompany(float fee) {
        this.fee = fee;
    }

    public float getFee() {
        return fee;
    }

    public void setFee(float fee) {
        this.fee = fee;
    }
}
