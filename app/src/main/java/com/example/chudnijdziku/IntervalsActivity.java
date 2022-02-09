package com.example.chudnijdziku;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class IntervalsActivity extends MainActivity {

    //all times will be in seconds
    private int roundTime;
    private int breakTime;
    private int roundsNumber;
    private TextView sumTimeTextView, roundBreakTextView, currentRoundTextView, currentIntervaTextView;
    private EditText roundTimeEditText, breakTimeEditText, roundsNumEditText;
    private Button confirmButton, startIntervalsButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intervals);
        //ConfirmIntervalsProperties();
    }

    public void ConfirmIntervalsProperties(View v){
        //picking layout views
        roundTimeEditText = (EditText)findViewById(R.id.roundTimeEditText);
        breakTimeEditText = (EditText)findViewById(R.id.breakTimeEditText);
        roundsNumEditText = (EditText)findViewById(R.id.roundNumberEditText);
        //setting confirm button
        confirmButton = (Button)findViewById(R.id.confirmIntervalsPropertiesButton);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                roundTime = (Integer.parseInt(roundTimeEditText.getText().toString()));//setting round time
                breakTime = (Integer.parseInt(breakTimeEditText.getText().toString()));//setting break time
                roundsNumber = (Integer.parseInt(roundsNumEditText.getText().toString()));//setting rounds number
                showTrainingTime((roundTime+breakTime)*roundsNumber);
            }
        });
    }

    public void showTrainingTime(int time){
        int minutes = time / 60;
        int sec = time % 60;
        sumTimeTextView = (TextView)findViewById(R.id.sumTimeTextView);
        sumTimeTextView.setText(minutes +" min i " + sec + " sek");
    }

    public void startIntervals(View v){
        roundBreakTextView = (TextView)findViewById(R.id.roundBreakTextView);
        currentRoundTextView = (TextView)findViewById(R.id.currentRoundTextView);
        currentIntervaTextView = (TextView)findViewById(R.id.currentIntervaTextView);
    }




}