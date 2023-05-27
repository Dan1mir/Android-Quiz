package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class QuizRezults extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_rezults);

        final Button playAgain = findViewById(R.id.again);

        final TextView correct = findViewById(R.id.correctansv);
        final TextView incorrect = findViewById(R.id.incorrectansv);
        final TextView damn = findViewById(R.id.damn);

        final int getCorrectAnsv = getIntent().getIntExtra("correct",0);
        final int getIncorrectAnsv = getIntent().getIntExtra("incorrect",0);
        final int getSize = getIntent().getIntExtra("size",0);

        if(getCorrectAnsv == getSize){
            damn.setTextColor(Color.YELLOW);
            damn.setText(R.string.Perfect);
            incorrect.setText("");
            correct.setText("");
        } else if (getIncorrectAnsv == getSize) {
            damn.setTextColor(Color.RED);
            damn.setText(R.string.damn);
            incorrect.setText("");
            correct.setText("");
        } else {
        correct.setText(getString(R.string.correctansv) + getCorrectAnsv);
        incorrect.setText(getString(R.string.incorrectansv) + getIncorrectAnsv);
        damn.setText("");
        }
        playAgain.setOnClickListener(view -> {
            startActivity(new Intent(QuizRezults.this, MenuActivity.class));
            overridePendingTransition(R.anim.anim_l, R.anim.anim);
            playAgain.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.button_scale));
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(QuizRezults.this, MenuActivity.class));
        overridePendingTransition(R.anim.anim_l, R.anim.anim);
    }
}