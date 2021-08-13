package programs.tjk.braintraning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FinalActivity extends AppCompatActivity {

    private TextView tvTitle, tvResult, tvBestResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        tvTitle = findViewById(R.id.tvTitle);
        tvResult = findViewById(R.id.tvResult);
        tvBestResult = findViewById(R.id.tvBestResult);
    }

    public void onClickFinish(View View){
        Intent i = new Intent(FinalActivity.this, StartActivity.class);
        startActivity(i);
    }

    public  void onClickRestart(View View){
        Intent restart = new Intent(FinalActivity.this, MainActivity.class);
        startActivity(restart);
    }

    private void setResult(){

    }
}