package com.kmucs.krwcalc.lib;

/**
 * NetCompany.java
 * @author Seunghwan Hong
 */
public enum NetCompany {
    MASTER(0.01f), VISA(0.01f), AMEX(0.014f), JCB(0.01f), UNIONPAY(1f), BCGLOBAL(1f);
    private float fee;

    NetCompany(float fee) {
        this.fee = fee;
    }

    public float getFee() {
        return fee;
    }

    public void setFee(float fee) {
        this.fee = fee;
    }
}
