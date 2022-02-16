package com.example.chudnijdziku;

import static java.util.concurrent.TimeUnit.*;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;


public class IntervalsActivity extends MainActivity {

    //all times will be in seconds
    private int roundTime;
    private int breakTime;
    private int roundsNumber;
    private TextView sumTimeTextView, roundBreakTextView, currentRoundTextView, currentIntervalTextView, currentBreakTextView;
    private EditText roundTimeEditText, breakTimeEditText, roundsNumEditText;
    private Button confirmButton, startIntervalsButton;
    private Handler handler = new Handler();
    private SoundPool soundPool;
    private int boxingRing1x, boxingRing3x;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intervals);
        ConfirmIntervalsProperties();
        startIntervals();

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();
            soundPool = new SoundPool.Builder()
                    .setMaxStreams(2)
                    .setAudioAttributes(audioAttributes)
                    .build();
        }
        else{
            soundPool = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);
        }
        boxingRing1x = soundPool.load(this, R.raw.boxingring1x, 1);
        boxingRing3x = soundPool.load(this, R.raw.boxingring3x, 1);

    }

    public void ConfirmIntervalsProperties() {
        //picking layout views
        roundTimeEditText = (EditText) findViewById(R.id.roundTimeEditText);
        breakTimeEditText = (EditText) findViewById(R.id.breakTimeEditText);
        roundsNumEditText = (EditText) findViewById(R.id.roundNumberEditText);
        //setting confirm button
        confirmButton = (Button) findViewById(R.id.confirmIntervalsPropertiesButton);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                roundTime = Integer.parseInt(roundTimeEditText.getText().toString());//setting round time
                breakTime = Integer.parseInt(breakTimeEditText.getText().toString());//setting break time
                roundsNumber = Integer.parseInt(roundsNumEditText.getText().toString());//setting rounds number
                showTrainingTime((roundTime + breakTime) * roundsNumber);
            }
        });
    }

    public void showTrainingTime(int time) {
        int minutes = time / 60;
        int sec = time % 60;
        sumTimeTextView = (TextView) findViewById(R.id.sumTimeTextView);
        sumTimeTextView.setText(minutes + " min i " + sec + " sek");
    }

    public void startIntervals() {

        roundBreakTextView = (TextView) findViewById(R.id.roundBreakTextView);
        currentRoundTextView = (TextView) findViewById(R.id.currentRoundTextView);
        currentIntervalTextView = (TextView) findViewById(R.id.currentIntervalTextView);
        currentBreakTextView = (TextView) findViewById(R.id.currentBreakTextView);

        startIntervalsButton = (Button) findViewById(R.id.startIntervalButton);
        startIntervalsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getApplicationContext(), "5 sekund", Toast.LENGTH_SHORT).show();
                            }
                        });

                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        for (int i = 1; i <= roundsNumber; i++) { //round number
                            int finalI = i;
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    roundBreakTextView.setText("Praca, praca...");  //shows that it is workout time
                                    currentRoundTextView.setText("Runda nr: " + finalI);       //shows current round number
                                    soundPool.play(boxingRing3x,1,1,0,0,1);
                                }
                            });
                            for (int j = roundTime; j >= 0; j--) {    //counting round time descend til 0
                                int finalJ = j;
                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        currentIntervalTextView.setText("Czas aktywności: " + finalJ);
                                    }
                                });

                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            if (i != roundsNumber) {
                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        roundBreakTextView.setText("Przerwa, byku :)"); //shows that it is break time
                                        soundPool.play(boxingRing1x,1,1,0,0,1);
                                    }
                                });


                                for (int j = breakTime; j >= 0; j--) {    //counting round time descend til 0
                                    int finalJ = j;
                                    handler.post(new Runnable() {
                                        @Override
                                        public void run() {
                                            currentBreakTextView.setText("Czas przerwy: " + finalJ);
                                        }
                                    });

                                    try {
                                        Thread.sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                            } else {
                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        roundBreakTextView.setText("Koniec treningu"); //shows that it is break time
                                    }
                                });
                            }
                        }
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getApplicationContext(), "Gratuluję\nukończenia\ntreningu :D", Toast.LENGTH_LONG).show();
                            }
                        });

                    }
                }).start();


            } //end of onClick
        });
    }

}