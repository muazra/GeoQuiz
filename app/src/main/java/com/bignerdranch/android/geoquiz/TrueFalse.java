package com.bignerdranch.android.geoquiz;

/**
 * Created by Muaz on 8/30/14.
 */
public class TrueFalse {

    private int mQuestion;
    private boolean mTrueQuestion;
    private boolean mCheat;

    public TrueFalse(int question, boolean trueQuestion, boolean cheat){
        mQuestion = question;
        mTrueQuestion = trueQuestion;
        mCheat = cheat;
    }

    public int getQuestion() {
        return mQuestion;
    }

    public void setQuestion(int mQuestion) {
        this.mQuestion = mQuestion;
    }

    public boolean isTrueQuestion() {
        return mTrueQuestion;
    }

    public void setTrueQuestion(boolean mTrueQuestion) {
        this.mTrueQuestion = mTrueQuestion;
    }

    public boolean isDidCheat() { return mCheat; }

    public void setDidCheat(boolean mCheat) { this.mCheat = mCheat; }

}
