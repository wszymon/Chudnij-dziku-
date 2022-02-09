package com.example.chudnijdziku;

import android.widget.Button;

public class ChudnijDziku extends MainActivity {
    private int eatenKcal;
    private int burnedKcal;
    private int sumKcal;
    private String eatenKcalTextView;
    private String burnedKcalTextView;
    private String randomFactTextView;
    private static int minute = 60;

    public int getMinute() {return minute;}

    public int getEatenKcal() {
        return eatenKcal;
    }

    public void setEatenKcal(int eatenKcal) {
        this.eatenKcal = eatenKcal;
    }

    public int getBurnedKcal() {
        return burnedKcal;
    }

    public void setBurnedKcal(int burnedKcal) {
        this.burnedKcal = burnedKcal;
    }

    public int getSumKcal() {
        return sumKcal;
    }

    public void setSumKcal(int sumKcal) {
        this.sumKcal = sumKcal;
    }

    public String getEatenKcalTextView() {
        return eatenKcalTextView;
    }

    public void setEatenKcalTextView(String eatenKcalTextView) {
        this.eatenKcalTextView = eatenKcalTextView;
    }

    public String getBurnedKcalTextView() {
        return burnedKcalTextView;
    }

    public void setBurnedKcalTextView(String burnedKcalTextView) {
        this.burnedKcalTextView = burnedKcalTextView;
    }

    public String getRandomFactTextView() {
        return randomFactTextView;
    }

    public void setRandomFactTextView(String randomFactTextView) {
        this.randomFactTextView = randomFactTextView;
    }

}
