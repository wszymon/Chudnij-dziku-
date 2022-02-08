package com.example.chudnijdziku;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class IntervalsActivity extends Intervals {

    private EditText roundTime, breakTime, roundsNum;
    private TextView sumTime;
    private Button confirmButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intervals);

    }

    Intervals intervals = new Intervals();  //an Interval class instance for access to attributes and methods


    public void ConfirmIntervalsProperties(View v){
        //picking layout views
        roundTime = (EditText)findViewById(R.id.roundTimeEditText);
        breakTime = (EditText)findViewById(R.id.breakTimeEditText);
        roundsNum = (EditText)findViewById(R.id.roundNumberEditText);
        confirmButton = (Button)findViewById(R.id.confirmIntervalsPropertiesButton);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intervals.setRoundTime(Integer.parseInt(roundTime.getText().toString()));//setting round time

                intervals.setBreakTime(Integer.parseInt(breakTime.getText().toString()));//setting break time

                intervals.setRoundsNumber(Integer.parseInt(roundsNum.getText().toString()));//setting rounds number

            }
        });
    }
}