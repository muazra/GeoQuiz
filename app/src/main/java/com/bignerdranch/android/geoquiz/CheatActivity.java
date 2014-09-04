package com.bignerdranch.android.geoquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Muaz on 9/1/14.
 */
public class CheatActivity extends Activity {

    public static final String EXTRA_ANSWER_IS_TRUE =
            "com.bignerdranch.android.geoquiz.answer_is_true";
    public static final String EXTRA_ANSWER_SHOWN =
            "com.bignerdranch.android.geoquiz.answer_shown";

    private static final String KEY_CHEAT = "cheat";
    private static final String KEY_CHEAT_ANSWER = "cheat answer";

    private static final String TAG = "CheatActivity";

    private boolean mAnswerIsTrue;
    private boolean mCheated;
    private Button mShowAnswerButton;
    private TextView mAnswerTextView;

    private void setAnswerShownResult(boolean isAnswerShown) {
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown);
        setResult(RESULT_OK, data);
    }

    private void showCheatAnswer(){
        if(mAnswerIsTrue)
            mAnswerTextView.setText(R.string.true_button);
        else
            mAnswerTextView.setText(R.string.false_button);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);
        mAnswerTextView = (TextView) findViewById(R.id.answerTextView);

        if(savedInstanceState != null) {
            mCheated = savedInstanceState.getBoolean(KEY_CHEAT, false);
            setAnswerShownResult(mCheated);
            if(mCheated)
                showCheatAnswer();
        }else {
            mCheated = false;
            setAnswerShownResult(false);
        }

        mShowAnswerButton = (Button) findViewById(R.id.showAnswerButton);
        mShowAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCheatAnswer();
                setAnswerShownResult(true);
                mCheated = true;
            }
        });

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "onSaveInstanceState");
        savedInstanceState.putBoolean(KEY_CHEAT, mCheated);
        savedInstanceState.putBoolean(KEY_CHEAT_ANSWER, mAnswerIsTrue);
    }
}
