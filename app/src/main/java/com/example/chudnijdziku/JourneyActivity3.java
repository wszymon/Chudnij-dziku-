package com.example.chudnijdziku;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class JourneyActivity3 extends JourneyActivity2 {

    private TextView infoTextView;
    private int ppm = getBMO();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journey3);
        infoTextView = (TextView)findViewById(R.id.infoTextView);
        infoTextView.setText("Dzięki danym, które podałeś na poprzedniej stronie wiemy, że Twoja podstawowa przemiana materii (PPM) wynosi: " + ppm +" Kcal\n" +
                "Jest to ilość kilokalorii, które Twój organizm potrzebuje do podtrzymywania funkcji organów wewnętrznych. Innymi słowy dziku, gdybyś cały dzień leżał bez ruchu na " +
                "łące to właśnie tyle kalorii Twój organizm by potrzebował żeby nie chudnąć, ani nie tyć. \n" +
                "Jednak Ty nie leżysz cały dzień. Wręcz przeciwnie, pracujesz, uczysz się, chodzisz, jeździsz itd., ale po kolei." +
                "Żeby schudnąć musisz być na deficycie kalorycznym. To znaczy, że do Twojej PPM należy dodać dzienną aktywność, a następnie od tej wartości odjąć np. 200.\n" +
                "Przykład:\n" +
                "Dzik waży 100 kg, ma 180cm wzrostu i 30 lat. Jego PPM to 2056 Kcal. Pracuje w biurze (nie uwzględniając przerw) około 7 godzin i potrzebuje na to 1050 Kcal. " +
                "Tego dnia nie uprawiał żadnej dodatkowej aktywności więc żeby nie chudnąć, ani nie tyć potrzebuje 3106 kcal. Tego dnia musi zatem zjeść mniej niż 3106 Kcal. Ile?" +
                "Szacuje się, że 1kg tłuszczu to 10 000 Kcal. Jeśli dzik codziennie będzie jadł 2906 Kcal (3106 - 200) to jeden kilogram zrzuci za 50dni. \n" +
                "Mało to, czy dużo?... Lepiej tyle niż wcale, ale jest to wartość, którą się osiągnie tylko poprzez zjedzenie o 200kcal mniej, a to tyle co kanapka z szynką i majonezem.\n" +
                "Bez obaw ;) są sposoby żeby to przyspieszyć. Zapraszam na kolejną stronę. ");
    }
}