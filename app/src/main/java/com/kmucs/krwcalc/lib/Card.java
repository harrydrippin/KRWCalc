package com.kmucs.krwcalc.lib;

/**
 * Card.java
 * @author Seunghwan Hong
 */
public class Card {
    public String name;
    public CardCompany cardCompany;
    public NetCompany netCompany;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CardCompany getCardCompany() {
        return cardCompany;
    }

    public void setCardCompany(CardCompany cardCompany) {
        this.cardCompany = cardCompany;
    }

    public NetCompany getNetCompany() {
        return netCompany;
    }

    public void setNetCompany(NetCompany netCompany) {
        this.netCompany = netCompany;
    }
}
