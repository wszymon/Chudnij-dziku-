package com.example.chudnijdziku;


import android.widget.Button;

public class Intervals extends ChudnijDziku implements procedureable{
    //all times will be in seconds
    private int roundTime;
    private int breakTime;
    private int sumRoundsTime;
    private int sumBreaksTime;
    private int sumTime;
    private int roundsNumber;

    public int getRoundTime() {
        return roundTime;
    }

    public Intervals() {
    }

    public void setRoundTime(int roundTime) {
        this.roundTime = roundTime;
    }

    public int getBreakTime() {
        return breakTime;
    }

    public void setBreakTime(int breakTime) {
        this.breakTime = breakTime;
    }

    public int getSumRoundsTime() {
        return sumRoundsTime;
    }

    public void setSumRoundsTime(int sumRoundsTime) {
        this.sumRoundsTime = sumRoundsTime;
    }

    public int getSumBreaksTime() {
        return sumBreaksTime;
    }

    public void setSumBreaksTime(int sumBreaksTime) {
        this.sumBreaksTime = sumBreaksTime;
    }

    public int getSumTime() {
        return sumTime;
    }

    public void setSumTime(int sumTime) {
        this.sumTime = sumTime;
    }

    public int getRoundsNumber() {
        return roundsNumber;
    }

    public void setRoundsNumber(int roundsNumber) {
        this.roundsNumber = roundsNumber;
    }

    public void showTrainingTime(){
        if(roundTime == 0 && breakTime == 0 && roundsNumber == 0){

        }
        else if(breakTime == 0 && roundsNumber == 0){

        }
        else if(roundsNumber == 0){

        }
        else{

        }
    }
    public void input(){

    }

    @Override
    public void procedure() {


    }
}
