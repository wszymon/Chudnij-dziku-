package com.example.chudnijdziku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    private float bodyweight, growth;
    private int age, BMO;

    public int getBMO() {
        return BMO;
    }

    public void setBMO(int BMO) {
        this.BMO = BMO;
    }

    public float getBodyweight() {
        return bodyweight;
    }

    public void setBodyweight(float bodyweight) {
        this.bodyweight = bodyweight;
    }

    public float getGrowth() {
        return growth;
    }

    public void setGrowth(float growth) {
        this.growth = growth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_main);
    }

    public void goIntervals(View v){
        Intent i = new Intent(this,IntervalsActivity.class);
        startActivity(i);
    }

    public void GoJourney(View v){
        Intent i = new Intent(this, JourneyActivity.class);
        startActivity(i);
    }

}