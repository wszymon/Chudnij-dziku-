package com.example.chudnijdziku;

import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class Break extends Thread{

    int breakTime;
    TextView currentBreakTextView;


    public Break(int breakTime, TextView currentBreakTextView){
        this.breakTime = breakTime;
        this.currentBreakTextView = currentBreakTextView;
    }

    @Override
    public void run() {
        for(int j = breakTime; j >= 0; j--){
            currentBreakTextView.setText(j+"");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        super.run();
    }
}
