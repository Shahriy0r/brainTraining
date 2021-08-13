package programs.tjk.braintraning;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences pref;
    private final String save_key = "save_key";
    private TextView tvMain, tvRes;
    private ActionBar actionBar;
    private int number_1;
    private int number_2;
    private int number_false;
    private int number_i;
    private int number_res;
    private int max = 20;
    private int min = 0;
    private int max1 = 40;
    private int min1 = 10;
    private long startTime = 0;
    private long currentTime = 0;
    private float time_result = 0.0f;
    private  int true_answer = 0;
    private int max_true_answer = 10;                           //Миқдори саволҳои пешниҳодмешуда
    private boolean is_true_answer = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        startTime = System.currentTimeMillis();
        pref = getSharedPreferences("Test", MODE_PRIVATE);
        tvMain = findViewById(R.id.tvMain);
        tvRes = findViewById(R.id.tvRes);
        tvRes.setText(String.valueOf(true_answer));
        actionBar = getSupportActionBar();
        numbers();
    }

    private void numbers(){
        number_1 = (int) (Math.random() * (max - min));
        number_2 = (int) (Math.random() * (max - min));
        number_false = (int) (Math.random() * (max1 - min1));
        number_i = (int) (Math.random() * (5 - 1));
        number_res = number_1 + number_2;
//        tvRes.setText(String.valueOf(number_1));
        String text;

        if (number_i == 3 || number_i == 1) {
            text = number_1 + "+" + number_2 + "=" + number_res;
            is_true_answer = true;
        }
        else {
            text = number_1 + "+" + number_2 + "=" + number_false;
            is_true_answer = false;
        }

        tvMain.setText(text);
        if (true_answer >= max_true_answer){
            Intent i = new Intent(MainActivity.this, FinalActivity.class);
            startActivity(i);
        }
    }

    public void onClickTrue(View View) {
        if (is_true_answer) {
            true_answer++;
            numbers();
            currentTime = System.currentTimeMillis();
            time_result = (float) (currentTime - startTime) / 1000;
            String time = "Time: " + time_result;
            actionBar.setTitle(time);
        }
        else {
            numbers();
            currentTime = System.currentTimeMillis();
            time_result = (float) (currentTime - startTime) / 1000;
            String time = "Time: " + time_result;
            actionBar.setTitle(time);
        }
        tvRes.setText(String.valueOf(true_answer));
    }

    public void onClickFalse(View View){
        if (!is_true_answer) {
            true_answer++;
            numbers();
            currentTime = System.currentTimeMillis();
            time_result = (float) (currentTime - startTime) / 1000;
            String time = "Time: " + time_result;
            actionBar.setTitle(time);
        }

        else {
            numbers();
            currentTime = System.currentTimeMillis();
            time_result = (float) (currentTime - startTime) / 1000;
            String time = "Time: " + time_result;
            actionBar.setTitle(time);
        }
        tvRes.setText(String.valueOf(true_answer));
    }

}