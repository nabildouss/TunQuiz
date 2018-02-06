package com.example.android.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by n_douss on 06.02.18.
 */

public class FinishActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finish);
        ScoreSingleton scoreSingle = ScoreSingleton.getInstance();
        TextView scoreView = findViewById(R.id.score_view);
        scoreView.setText(getResources().getString(R.string.score, scoreSingle.getScore()));
    }

    public void tryAgain(View view) {
        Intent mainAct = new Intent(this, MainActivity.class);
        startActivity(mainAct);
        finish();
    }
}
