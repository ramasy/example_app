package com.example.asus.testapp.Model;

import java.util.List;

/**
 * Created by Asus on 07/01/2018.
 */

public class Question {
    private String mQuestion;
    private List<String> mListeReponse;
    private int mReponseIndex;

    public Question() {
    }

    public Question(String question, List<String> listeReponse, int reponseIndex) {
        mQuestion = question;
        mListeReponse = listeReponse;
        mReponseIndex = reponseIndex;
    }

    public String getQuestion() {
        return mQuestion;
    }

    public void setQuestion(String question) {
        mQuestion = question;
    }

    public List<String> getListeReponse() {
        return mListeReponse;
    }

    public void setListeReponse(List<String> listeReponse) {
        mListeReponse = listeReponse;
    }

    public int getReponseIndex() {
        return mReponseIndex;
    }

    public void setReponseIndex(int reponseIndex) {
        mReponseIndex = reponseIndex;
    }
}
