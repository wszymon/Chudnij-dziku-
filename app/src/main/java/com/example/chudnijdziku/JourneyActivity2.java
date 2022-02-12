package com.example.chudnijdziku;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class JourneyActivity2 extends JourneyActivity {

    private TextView introductiontextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journey2);
        introductiontextView = (TextView)findViewById(R.id.introductiontextView);
        introductiontextView.setText("" +
                "Okej, to do dzieła :)\n" +
                "Na początek trochę matematyki. Przede wszystkim musisz wiedzieć na czym stoisz.\n" +
                "Masz już wagę łazienkową? Jak nie to idź i kup. Bez tego nie przechodź dalej. To bardzo ważne. " +
                "Skoro jesteś zdeterminowany to trzeba się trochę poświęcić i wyrobić nawyk działania od razu.\n" +
                "...Skoro już masz wagę to się zważ i podaj masę swojego ciała w kilogramach: ");
    }
}