package com.example.chudnijdziku;

import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class Interval extends Thread{

    private int  roundTime;
    private TextView currentIntervalTextView;
    public Interval(int roundTime, TextView currentIntervalTextView){
        this.roundTime = roundTime;
        this.currentIntervalTextView = currentIntervalTextView;
    }


    @Override
    public void run() {

        for (int j = roundTime; j >= 0; j--) {    //counting round time descend til 0
            currentIntervalTextView.setText(j + "");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        super.run();
    }

}
