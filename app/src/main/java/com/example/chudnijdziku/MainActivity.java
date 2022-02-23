package com.example.chudnijdziku;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private float bodyweight = 0, growth = 0;
    private int age = 0, BMO;
    private TextView textViewRandomInfos;
    private static List<Integer> list = new ArrayList<>();
    //private String sList;

    public int getBMO() {
        return BMO;
    }

    public void setBMO(int BMO) {
        this.BMO = BMO;
    }

    public float getBodyweight() {
        return bodyweight;
    }

    public void setBodyweight(float bodyweight) {
        this.bodyweight = bodyweight;
    }

    public float getGrowth() {
        return growth;
    }

    public void setGrowth(float growth) {
        this.growth = growth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_main);
        textViewRandomInfos = (TextView) findViewById(R.id.randFactsTextView);
        showRandomInfo();

    }

    public void goIntervals(View view) {
        Intent i = new Intent(this, IntervalsActivity.class);
        startActivity(i);
    }

    public void goJourney(View view) {
        Intent i = new Intent(this, JourneyActivity.class);
        startActivity(i);
    }

    private String[] randomInfos = new String[]{
            "Większość diety każdego dzika (około 50%) powinny stanowić zdrowe węglowodany. Oto kilka z nich: " +
                    "ryż brązowy, kasza gryczana niepalona, kasza jaglana, komosa ryżowa, makarony pełnoziarniste," +
                    "chleb z pełnej mąki (ciemny), płatki owsiane górskie, soczewica, ziemniaki (gotowane), bataty. " +
                    "Jest ich znacznie więcej, a wystarczy kierować się główną zasadą: czym mniej przetworzone, tym lepiej. ",
            "Około 30% żywności w diecie dzika powinny stanowić tłuszcze. Zdrowe tłuszcze to np." +
                    " awokado, oliwa z oliwek, olej lniany, orzechy i masło orzechowe 100%, nasiona słonecznika, pestki dyni.",
            "Czy wiesz, ale mały kebab drobiowy w bułce ze wszystkimi dodatkami waży około 700g? To jest prawie 1400 Kcal w jednym posiłku. Mimo to" +
                    "jest to jeden z najlepszych wyborów jeśli chodzi o fastfoody, gdyż zawiera najlepsze proporcje makroskładników. Jak to się mówi" +
                    " wszystko jest dla ludzi byle z głową. Na przykład połączenie piwa z kebsem to bardzo zły pomysł. Wątroba musi w pierwszej kolejności wziąć" +
                    "się za rozłożenie alkoholu, a na kalorie z jedzenia jest już za późno.",
            "Są trzy makroskładniki: Węglowodany, tłuszcze i białka. Staraj się by w dniu proporcje ich spożycia wynosiły około 5:3:2, to znaczy" +
                    " na pięć części węglowodanów, trzy części tłuszczy i dwie części białka. Pamiętaj jednak, że to są tylko orientacyjne proporcje." +
                    " Nic się nie stanie jak jednego dnia zje się więcej jednego czy drugiego. Jedzenie to ma też być przyjemność :) "

    };

    public int randomInfoNum() {
        int min = 0;
        int max = randomInfos.length - 1;
        int result = (int) (Math.random() * (max - min + 1) + min);
        return result;
    }

    public void showRandomInfo() {
        File file = new File("/textFiles/shownList.txt");
        String slist = null;
        try {
            FileReader fr = new FileReader(file);
            int i;
            while (true) { //till end of file
                try {
                    if (!((i = fr.read()) != -1)) { //reading from file char by char
                        slist += (char) i; //adding chars to slist
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        if (list.size() == randomInfos.length - 1) {
            list.clear();
        }
        //ill have to send list size to file but i think 'checking' logic is correct
        int randomIndex = randomInfoNum();
        boolean shownIndex = wasItShown(randomIndex, list);
        if (shownIndex == true) {
            showRandomInfo();
        } else {
            list.add(randomIndex);
            textViewRandomInfos.setText(randomInfos[randomIndex]);
        }
    }

    public boolean wasItShown(int num, List<Integer> list) {
        for (int i : list) {
            if (i == num) {
                return true;
            }
        }
        return false;
    }

}