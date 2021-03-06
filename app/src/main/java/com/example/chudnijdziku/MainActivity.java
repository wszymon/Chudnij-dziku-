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
            "Wi??kszo???? diety ka??dego dzika (oko??o 50%) powinny stanowi?? zdrowe w??glowodany. Oto kilka z nich: " +
                    "ry?? br??zowy, kasza gryczana niepalona, kasza jaglana, komosa ry??owa, makarony pe??noziarniste," +
                    "chleb z pe??nej m??ki (ciemny), p??atki owsiane g??rskie, soczewica, ziemniaki (gotowane), bataty. " +
                    "Jest ich znacznie wi??cej, a wystarczy kierowa?? si?? g????wn?? zasad??: czym mniej przetworzone, tym lepiej. ",
            "Oko??o 30% ??ywno??ci w diecie dzika powinny stanowi?? t??uszcze. Zdrowe t??uszcze to np." +
                    " awokado, oliwa z oliwek, olej lniany, orzechy i mas??o orzechowe 100%, nasiona s??onecznika, pestki dyni.",
            "Czy wiesz, ale ma??y kebab drobiowy w bu??ce ze wszystkimi dodatkami wa??y oko??o 700g? To jest prawie 1400 Kcal w jednym posi??ku. Mimo to" +
                    "jest to jeden z najlepszych wybor??w je??li chodzi o fastfoody, gdy?? zawiera najlepsze proporcje makrosk??adnik??w. Jak to si?? m??wi" +
                    " wszystko jest dla ludzi byle z g??ow??. Na przyk??ad po????czenie piwa z kebsem to bardzo z??y pomys??. W??troba musi w pierwszej kolejno??ci wzi????" +
                    "si?? za roz??o??enie alkoholu, a na kalorie z jedzenia jest ju?? za p????no.",
            "S?? trzy makrosk??adniki: W??glowodany, t??uszcze i bia??ka. Staraj si?? by w dniu proporcje ich spo??ycia wynosi??y oko??o 5:3:2, to znaczy" +
                    " na pi???? cz????ci w??glowodan??w, trzy cz????ci t??uszczy i dwie cz????ci bia??ka. Pami??taj jednak, ??e to s?? tylko orientacyjne proporcje." +
                    " Nic si?? nie stanie jak jednego dnia zje si?? wi??cej jednego czy drugiego. Jedzenie to ma te?? by?? przyjemno???? :) "

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