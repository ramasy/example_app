package com.example.asus.testapp.Model;

import java.util.List;
import java.util.Random;

/**
 * Created by Asus on 07/01/2018.
 */

public class QuestionBank {
    private List<Question> mListeQuestion;
    private int mNextQuestionIndex;

    public QuestionBank(List<Question> listeQuestion) {
        mListeQuestion = listeQuestion;
    }

    public List<Question> getListeQuestion() {
        return mListeQuestion;
    }

    public void setListeQuestion(List<Question> listeQuestion) {
        mListeQuestion = listeQuestion;
    }
    public Question getQuestion() {
        Random random = new Random();
        setNextQuestionIndex(random.nextInt(3));
        return  (Question) mListeQuestion.get(getNextQuestionIndex());
    }

    public int getNextQuestionIndex() {
        return mNextQuestionIndex;
    }

    public void setNextQuestionIndex(int nextQuestionIndex) {
        mNextQuestionIndex = nextQuestionIndex;
    }
}
