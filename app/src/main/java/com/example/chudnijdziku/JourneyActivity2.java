package com.example.chudnijdziku;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class JourneyActivity2 extends JourneyActivity {

    private TextView introductionTextView;
    private EditText bodyWeightEditText, growthEditText, ageEditText;
    private Button goNextPageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journey2);
        introductionTextView = (TextView) findViewById(R.id.introductionTextView);
        bodyWeightEditText = (EditText) findViewById(R.id.bodyWeightEditText);
        growthEditText = (EditText) findViewById(R.id.growthEditText);
        ageEditText = (EditText) findViewById(R.id.ageEditText);
        goNextPageButton = (Button) findViewById(R.id.goNextPageButton);
        introductionTextView.setText("" +
                "Okej, to do dzieła :)\n" +
                "Na początek trochę matematyki. Przede wszystkim musisz wiedzieć na czym stoisz.\n" +
                "Masz już wagę łazienkową? Jak nie to idź i kup. Bez tego nie przechodź dalej. To bardzo ważne. " +
                "Skoro jesteś zdeterminowany to trzeba się trochę poświęcić i wyrobić nawyk działania od razu.\n" +
                "...Skoro już masz wagę to się zważ i podaj masę swojego ciała w kilogramach: ");
    }

    public int Harris_Benedict() {
        float result = (float) (66.47 + (13.7 * getBodyweight()) + (5 * getGrowth()) - (6.76 * getAge()));
        return (int) result;
    }

    public int Mifflin() {
        float result = (float) ((10 * getBodyweight()) + (6.25 * getGrowth()) - (5 * getAge()) + 5);
        return (int) result;
    }

    public void goNextPageAndCount(View view) {

        setBodyweight(Float.parseFloat(bodyWeightEditText.getText().toString()));
        setGrowth(Float.parseFloat(growthEditText.getText().toString()));
        setAge(Integer.parseInt(ageEditText.getText().toString()));
        float BMO = (Harris_Benedict() + Mifflin()) / 2;
        setBMO((int) BMO);
        Intent intent = new Intent(this, JourneyActivity3.class);
        intent.putExtra("BMO", getBMO());
        startActivity(intent);
        //Toast.makeText(this, getBMO()+"", Toast.LENGTH_SHORT).show();
    }
}