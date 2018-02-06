package com.example.android.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by n_douss on 06.02.18.
 */

public class QuestionsActivity extends AppCompatActivity {

    public ScoreSingleton scoreSingle;
    /**
     * attributes
     */
    private TextView questionNumberView;
    private TextView questionView;
    private Button answerAView;
    private Button answerBView;
    private Button answerCView;
    private Button answerDView;
    private Toast rightAnswer;
    private Toast wrongAnswer;
    private int score = 0;
    private int questionNumber = 0;
    private String questions[];
    private String answersA[];
    private String answersB[];
    private String answersC[];
    private String answersD[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questions);
        scoreSingle = ScoreSingleton.getInstance();
        scoreSingle.setScore(0);
        questionNumberView = (TextView) findViewById(R.id.question_number);
        questionView = findViewById(R.id.question);
        answerAView = findViewById(R.id.answer_a);
        answerBView = findViewById(R.id.answer_b);
        answerCView = findViewById(R.id.answer_c);
        answerDView = findViewById(R.id.answer_d);


        questions = new String[]{getResources().getString(R.string.question_1), getResources().getString(R.string.question_2),
                getResources().getString(R.string.question_3), getResources().getString(R.string.question_4), getResources().getString(R.string.question_5),
                getResources().getString(R.string.question_6), getResources().getString(R.string.question_7), getResources().getString(R.string.question_8),
                getResources().getString(R.string.question_9), getResources().getString(R.string.question_10)};

        answersA = new String[]{getResources().getString(R.string.answer_A_1), getResources().getString(R.string.answer_A_2), getResources().getString(R.string.answer_A_3),
                getResources().getString(R.string.answer_A_4), getResources().getString(R.string.answer_A_5), getResources().getString(R.string.answer_A_6),
                getResources().getString(R.string.answer_A_7), getResources().getString(R.string.answer_A_8), getResources().getString(R.string.answer_A_9), getResources().getString(R.string.answer_A_10)};

        answersB = new String[]{getResources().getString(R.string.answer_B_1), getResources().getString(R.string.answer_B_2), getResources().getString(R.string.answer_B_3),
                getResources().getString(R.string.answer_B_4), getResources().getString(R.string.answer_B_5), getResources().getString(R.string.answer_B_6), getResources().getString(R.string.answer_B_7),
                getResources().getString(R.string.answer_B_8), getResources().getString(R.string.answer_B_9), getResources().getString(R.string.answer_B_10)};

        answersC = new String[]{getResources().getString(R.string.answer_C_1), getResources().getString(R.string.answer_C_2), getResources().getString(R.string.answer_C_3), getResources().getString(R.string.answer_C_4),
                getResources().getString(R.string.answer_C_5), getResources().getString(R.string.answer_C_6), getResources().getString(R.string.answer_C_7),
                getResources().getString(R.string.answer_C_8), getResources().getString(R.string.answer_C_9), getResources().getString(R.string.answer_C_10)};

        answersD = new String[]{getResources().getString(R.string.answer_D_1), getResources().getString(R.string.answer_D_2), getResources().getString(R.string.answer_D_3), getResources().getString(R.string.answer_D_4),
                getResources().getString(R.string.answer_D_5), getResources().getString(R.string.answer_D_6), getResources().getString(R.string.answer_D_7),
                getResources().getString(R.string.answer_D_8), getResources().getString(R.string.answer_D_9), getResources().getString(R.string.answer_D_10)};


        rightAnswer = Toast.makeText(this, R.string.right_answer, Toast.LENGTH_SHORT);
        wrongAnswer = Toast.makeText(this, R.string.wrong_answer, Toast.LENGTH_SHORT);
        startQuiz();
    }


    /**
     * start the quiz/ next question
     */
    public void startQuiz() {

        questionView.setText(questions[questionNumber]);
        answerAView.setText(answersA[questionNumber]);
        answerBView.setText(answersB[questionNumber]);
        answerCView.setText(answersC[questionNumber]);
        answerDView.setText(answersD[questionNumber]);
        questionNumber++;
        questionNumberView.setText(getResources().getString(R.string.question_number, questionNumber));

    }

    /**
     * finish quiz / change to final screen
     */
    public void finishQuiz() {
        Intent finish = new Intent(this, FinishActivity.class);
        startActivity(finish);
    }

    /**
     * All the next methods handle the button clicks (A,B,C,D)
     */
    public void clickA(View view) {
        switch (questionNumber) {
            case 1:
            case 7:
                this.score += 100;
                rightAnswer.show();
                startQuiz();
                break;
            case 10:
                score += 100;
                rightAnswer.show();
                if (score < 0) score = 0;
                scoreSingle.setScore(score);
                finishQuiz();
                finish();
                break;
            default:
                score -= 15;
                wrongAnswer.show();
                break;

        }
    }

    public void clickB(View view) {
        switch (questionNumber) {

            case 8:
            case 9:
                score += 100;
                rightAnswer.show();
                startQuiz();
                break;
            default:
                score -= 15;
                wrongAnswer.show();
                break;

        }
    }

    public void clickC(View view) {
        switch (questionNumber) {
            case 3:
            case 5:
            case 6:
                score += 100;
                rightAnswer.show();
                startQuiz();
                break;
            default:
                score -= 15;
                wrongAnswer.show();
                break;

        }
    }

    public void clickD(View view) {
        switch (questionNumber) {
            case 2:
                score += 100;
                rightAnswer.show();
                startQuiz();
                break;
            case 4:
                score += 100;
                rightAnswer.show();
                startQuiz();
                break;
            default:
                score -= 15;
                wrongAnswer.show();
                break;

        }
    }
}
