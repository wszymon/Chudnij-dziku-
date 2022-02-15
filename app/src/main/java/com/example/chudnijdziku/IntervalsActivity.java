package com.example.chudnijdziku;

import static java.util.concurrent.TimeUnit.*;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.concurrent.TimeUnit;

public class IntervalsActivity extends MainActivity  {

    //all times will be in seconds
    private int roundTime;
    private int breakTime;
    private int roundsNumber;
    private TextView sumTimeTextView, roundBreakTextView, currentRoundTextView, currentIntervalTextView, currentBreakTextView;
    private EditText roundTimeEditText, breakTimeEditText, roundsNumEditText;
    private Button confirmButton, startIntervalsButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intervals);
        roundTimeEditText = (EditText)findViewById(R.id.roundTimeEditText);
        breakTimeEditText = (EditText)findViewById(R.id.breakTimeEditText);
        roundsNumEditText = (EditText)findViewById(R.id.roundNumberEditText);
        confirmButton = (Button)findViewById(R.id.confirmIntervalsPropertiesButton);
        sumTimeTextView = (TextView)findViewById(R.id.sumTimeTextView);
        startIntervalsButton = (Button)findViewById(R.id.startIntervalButton);
        roundBreakTextView = (TextView)findViewById(R.id.roundBreakTextView);
        currentRoundTextView = (TextView)findViewById(R.id.currentRoundTextView);
        roundBreakTextView = (TextView)findViewById(R.id.roundBreakTextView);
        currentIntervalTextView = (TextView)findViewById(R.id.currentIntervalTextView);
        currentBreakTextView = (TextView)findViewById(R.id.currentBreakTextView);
    }


    public void ConfirmIntervalsProperties(View view){
        //picking layout views
       // roundTimeEditText = (EditText)findViewById(R.id.roundTimeEditText);
        //breakTimeEditText = (EditText)findViewById(R.id.breakTimeEditText);
       // roundsNumEditText = (EditText)findViewById(R.id.roundNumberEditText);
        //setting confirm button
       // confirmButton = (Button)findViewById(R.id.confirmIntervalsPropertiesButton);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                roundTime = Integer.parseInt(roundTimeEditText.getText().toString());//setting round time
                breakTime = Integer.parseInt(breakTimeEditText.getText().toString());//setting break time
                roundsNumber = Integer.parseInt(roundsNumEditText.getText().toString());//setting rounds number
                showTrainingTime((roundTime+breakTime)*roundsNumber);
            }
        });
    }

    public void showTrainingTime(int time){
        int minutes = time / 60;
        int sec = time % 60;
        //sumTimeTextView = (TextView)findViewById(R.id.sumTimeTextView);
        sumTimeTextView.setText(minutes +" min i " + sec + " sek");
    }

    public void startIntervals(View view){

    //startIntervalsButton = (Button)findViewById(R.id.startIntervalButton);
        startIntervalsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*for(int i = 5; i >= 1; i--){        //begining descend counting loop, just for preparation
                    Toast.makeText(getApplicationContext(),i,Toast.LENGTH_SHORT).show();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }*/
                int citv = Integer.parseInt(currentIntervalTextView.getText().toString());
                int cbtv = Integer.parseInt(currentBreakTextView.getText().toString());
                for(int i = 1; i <= roundsNumber; i++){ //round number
                    //roundBreakTextView = (TextView)findViewById(R.id.roundBreakTextView);
                    roundBreakTextView.setText("Praca, praca...");  //shows that it is workout time

                    //currentRoundTextView = (TextView)findViewById(R.id.currentRoundTextView);
                    currentRoundTextView.setText(i+"");       //shows current round number

                    for(int j = roundTime; j >= 0; j--){    //counting round time descend til 0
                        //currentIntervalTextView = (TextView)findViewById(R.id.currentIntervalTextView);
                        citv = roundTime;
                        currentIntervalTextView.setText(citv+"");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    //roundBreakTextView = (TextView)findViewById(R.id.roundBreakTextView);
                    roundBreakTextView.setText("Przerwa, byku :)"); //shows that it is break time

                    for(int j = breakTime; j >= 0; j--){    //counting round time descend til 0
                        //currentBreakTextView = (TextView)findViewById(R.id.currentBreakTextView);
                        cbtv = breakTime;
                        currentBreakTextView.setText(cbtv+"");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
                Toast.makeText(getApplicationContext(),"Gratuluję\nukończenia\ntreningu :D",Toast.LENGTH_LONG).show();

            }
        });
    }






}