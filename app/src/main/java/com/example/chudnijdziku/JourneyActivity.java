package com.example.chudnijdziku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class JourneyActivity extends MainActivity {

    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journey);
        text = (TextView) findViewById(R.id.welcomeInfos);

        text.setText("Witaj, dziku!\n" +
                "To początek Twojej drogi w głąb lasu.\n" +
                "Jak to zwykle bywa w takich podróżach\n" +
                "trzeba się nastawić na to, że nie będzie łatwo.\n" +
                "Najtrudniej jest zebrać się do drogi, ale zanim\n" +
                "zaczniesz musisz się odpowiednio przygotować.\n" +
                "Potrzebny jest odpowiedni sprzęt, wiedza i plan trasy,\n" +
                "żeby nie zabłądzić.\n " +
                "Nie mniej, czasami zdarzają się pomyłki, to normalne.\n" +
                "Nie można od razu zakładać, że wszystko się uda od razu. " +
                "Jednak jeśli jesteś odpowiednio zdetermionowany to dasz radę.\n" +
                "Dzik kiedy zaryje pyskiem w błoto nie cofa się, ale idzie naprzód " +
                "pchając te błoto aż nie przedostanie się na drugą stronę.\n" +
                "Bądź jak dzik, zdetermionowany i nie zważaj na porażki.\n" +
                "Twoim postawowym wyposażeniem będzie waga kuchenna i łazienkowa.\n" +
                "Odpowiednią wiedzę zaraz Ci przekażę, a plan wyznaczysz sam.\n" +
                "Pamiętaj, jeśli naprawdę chcesz schudnąć\n" +
                " to bądź uczciwy wobec samego siebie.");
    }

    public void goForward(View view) {
        Intent intent = new Intent(this, JourneyActivity2.class);
        startActivity(intent);
    }

}