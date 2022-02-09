package com.example.chudnijdziku;


import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Intervals extends ChudnijDziku implements procedureable{
    //all times will be in seconds
    private int roundTime;
    private int breakTime;
    private int sumRoundsTime;
    private int sumBreaksTime;
    private int sumTime;
    private int roundsNumber;
    private TextView sumTimeTextView;
    private EditText roundTimeEditText, breakTimeEditText, roundsNumEditText;
    private Button confirmButton;

    public Intervals() {
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public int getRoundTime() {
        return roundTime;
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

    public TextView getSumTimeTextView() {
        return sumTimeTextView;
    }

    public void setSumTimeTextView(TextView sumTimeTextView) {
        this.sumTimeTextView = sumTimeTextView;
    }

    public EditText getRoundTimeEditText() {
        return roundTimeEditText;
    }

    public void setRoundTimeEditText(EditText roundTimeEditText) {
        this.roundTimeEditText = roundTimeEditText;
    }

    public EditText getBreakTimeEditText() {
        return breakTimeEditText;
    }

    public void setBreakTimeEditText(EditText breakTimeEditText) {
        this.breakTimeEditText = breakTimeEditText;
    }

    public EditText getRoundsNumEditText() {
        return roundsNumEditText;
    }

    public void setRoundsNumEditText(EditText roundsNumEditText) {
        this.roundsNumEditText = roundsNumEditText;
    }

    public Button getConfirmButton() {
        return confirmButton;
    }

    public void setConfirmButton(Button confirmButton) {
        this.confirmButton = confirmButton;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void input(){
        setRoundTimeEditText((EditText)findViewById(R.id.roundTimeEditText));
        setBreakTimeEditText((EditText)findViewById(R.id.breakTimeEditText));
        setRoundsNumEditText((EditText)findViewById(R.id.roundNumberEditText));
    }

    public void ConfirmIntervalsProperties(){
        //picking layout views
        input();
        //setting confirm button
        confirmButton = (Button)findViewById(R.id.confirmIntervalsPropertiesButton);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setRoundTime(Integer.parseInt(roundTimeEditText.getText().toString()));//setting round time
                setBreakTime(Integer.parseInt(breakTimeEditText.getText().toString()));//setting break time
                setRoundsNumber(Integer.parseInt(roundsNumEditText.getText().toString()));//setting rounds number
                //Toast.makeText(getApplicationContext(),String.valueOf(intervals.getBreakTime()), Toast.LENGTH_LONG).show();
                //setSumTime(getRoundTime()*getBreakTime()*getRoundsNumber());
                //showTrainingTime(getSumTime());
            }
        });
    }

    public void countAllTimes(int rounds, int breaks, int rNum){
        setSumRoundsTime(rounds*rNum);
        setSumBreaksTime(breaks*rNum);
        setSumTime((rounds + breaks) * rNum);
    }

    public void showTrainingTime(int time){
       int minutes = time / getMinute();
       int sec = time % getMinute();
        sumTimeTextView.setText(minutes + " minut i " + sec + " sekund");
    }

    @Override
    public void procedure() {
        ConfirmIntervalsProperties();
        countAllTimes(getRoundTime(),getBreakTime(),getRoundsNumber());
        showTrainingTime(getSumTime());
    }
}
