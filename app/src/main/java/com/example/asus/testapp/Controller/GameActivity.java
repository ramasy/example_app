package com.example.asus.testapp.Controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.testapp.Model.Question;
import com.example.asus.testapp.Model.QuestionBank;
import com.example.asus.testapp.R;

import java.util.Arrays;

public class GameActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView mQuestion;
    private Button mReponse1;
    private Button mReponse2;
    private Button mReponse3;
    private Button mReponse4;
    private QuestionBank mQuestionBank;
    private Question mNewQuestion;
    private int mNombreQuestion = 4;
    private int mScore = 0;
    public static final String BUNDLE_EXTRA_SCORE = "BUNDLE_EXTRA_SCORE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        mQuestion = (TextView) findViewById(R.id.game_activity_question);
        mReponse1 = (Button) findViewById(R.id.game_activity_reponse1);
        mReponse2 = (Button) findViewById(R.id.game_activity_reponse2);
        mReponse3 = (Button) findViewById(R.id.game_activity_reponse3);
        mReponse4 = (Button) findViewById(R.id.game_activity_reponse4);
        mQuestionBank = generateQuestion();
        mNewQuestion = mQuestionBank.getQuestion();
        afficherQuestion(mNewQuestion);

        mReponse1.setTag(0);
        mReponse1.setOnClickListener(this);
        mReponse2.setTag(1);
        mReponse2.setOnClickListener(this);
        mReponse3.setTag(2);
        mReponse3.setOnClickListener(this);
        mReponse4.setTag(3);
        mReponse4.setOnClickListener(this);
    }
    public QuestionBank generateQuestion() {
        Question question1 = new Question("Who is the creator of Android?",
                Arrays.asList("Andy Rubin",
                        "Steve Wozniak",
                        "Jake Wharton",
                        "Paul Smith"),
                0);

        Question question2 = new Question("When did the first man land on the moon?",
                Arrays.asList("1958",
                        "1962",
                        "1967",
                        "1969"),
                3);

        Question question3 = new Question("What is the house number of The Simpsons?",
                Arrays.asList("42",
                        "101",
                        "666",
                        "742"),
                3);

        return new QuestionBank(Arrays.asList(question1,
                question2,
                question3));
    }
    public void afficherQuestion(Question question) {
        mQuestion.setText(question.getQuestion());
        mReponse1.setText(question.getListeReponse().get(0));
        mReponse2.setText(question.getListeReponse().get(1));
        mReponse3.setText(question.getListeReponse().get(2));
        mReponse4.setText(question.getListeReponse().get(3));
    }

    @Override
    public void onClick(View view) {
        mNombreQuestion -=1;


        if ((int) view.getTag() == this.mNewQuestion.getReponseIndex()) {
            Toast.makeText(this, "Reponse Correct!", Toast.LENGTH_SHORT).show();
            mScore += 1;
        } else {
            Toast.makeText(this, "Reponse incorrect!", Toast.LENGTH_SHORT).show();
        }

        if (mNombreQuestion == 0) {
            Intent intent = new Intent();
            intent.putExtra(BUNDLE_EXTRA_SCORE,mScore);
            setResult(RESULT_OK, intent);
            finish();
        }
        mNewQuestion = mQuestionBank.getQuestion();
        afficherQuestion(mNewQuestion);
    }
}
