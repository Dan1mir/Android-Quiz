package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;

public class QuizActivity extends AppCompatActivity {
    private TextView numberQuestion;
    private TextView Question;
    private ImageView idMenu;
    private Button option1,option2,option3,option4;
    private Button next;
    private List <QuestionList> questionList;
    private int curretQuestion = 0;
    private String selectedAnswer = "";
    private MediaPlayer mediaPlayer;
    private Chronometer chronometer1;
    private boolean close = false;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        final String getSelectedTopic = getIntent().getStringExtra("selectedTopic");

        final TextView selectedTopic = findViewById(R.id.selectedTopic);

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.button_scale);

        numberQuestion = findViewById(R.id.Qnumber);
        Question = findViewById(R.id.Q);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);
        next = findViewById(R.id.next);
        idMenu = findViewById(R.id.idMenu);

        selectedTopic.setText(getSelectedTopic);

        questionList = QuestionSupply.getQuestions(getSelectedTopic);

        resetNumberQuestion();

        chronometer1 = findViewById(R.id.chronometer);
        chronometer1.setBase(SystemClock.elapsedRealtime() + (questionList.size()* 12L)*1000); //вы спросите почему 12, а я отвечу... ПОТОМУ-ЧТО, АХАХАХАХА
        chronometer1.setCountDown(true);

        option1.setOnLongClickListener(view -> {
            setOptionSelected(option1);
            return false;
        });

        option2.setOnLongClickListener(view -> {
            setOptionSelected(option2);
            return false;
        });

        option3.setOnLongClickListener(view -> {
            setOptionSelected(option3);
            return false;
        });

        option4.setOnLongClickListener(view -> {
            setOptionSelected(option4);
            return false;
        });



        next.setOnClickListener(view -> {
            next.startAnimation(animation);
            if(selectedAnswer.isEmpty()){
                Toast.makeText(QuizActivity.this, getString(R.string.chooseAnsv), Toast.LENGTH_SHORT).show();
            } else {
                curretQuestion++;
                if((curretQuestion+1)==questionList.size()){
                    next.setText(R.string.ende);
                    close = true;
                }
                if(curretQuestion<questionList.size()){
                    resetOptions();
                    resetNumberQuestion();
                } else {
                    goToRezults();
                }
            }
        });

        idMenu.setOnClickListener(view -> {
            onBackPressed();
            overridePendingTransition(R.anim.anim_l, R.anim.anim);
            idMenu.startAnimation(animation);
            mediaPlayer.release();
        });

        chronometer1.setOnChronometerTickListener(chrono -> {
            if(chronometer1.getText().equals("00:00") ){
                Toast.makeText(QuizActivity.this, getString(R.string.timesup), Toast.LENGTH_SHORT).show();
                close = true;
                chronometer1.stop();
                goToRezults();
            }
        });
    }

    private int correctAnswers(){
        int correctAnswers = 0;

        for(int i = 0; i < questionList.size() ;i++){
            final String getUserSelectedAnswer = questionList.get(i).getSelectedAnswer();
            final String getAnswer = questionList.get(i).getAnswer();
            if(getUserSelectedAnswer.equals(getAnswer)){
                correctAnswers++;
            }
        }
        return  correctAnswers;
    }
    private int incorrectAnswers(){
        int incorrectAnswers = 0;

        for(int i = 0; i < questionList.size() ;i++){
            final String getUserSelectedAnswer = questionList.get(i).getSelectedAnswer();
            final String getAnswer = questionList.get(i).getAnswer();
            if(!getUserSelectedAnswer.equals(getAnswer)){
                incorrectAnswers++;
            }
        }
        return  incorrectAnswers;
    }

    private void resetOptions() {
        selectedAnswer = "";
        Button[] buttons = {option1, option2, option3, option4};
        for(Button option : buttons){
            option.setBackgroundResource(R.drawable.opros_button);
            option.setTextColor(Color.RED);
        }
    }

    @SuppressLint("SetTextI18n")
    private void resetNumberQuestion(){
        numberQuestion.setText((curretQuestion+1)+"/"+questionList.size());
        Question.setText(questionList.get(curretQuestion).getQuestion());
        option1.setText(questionList.get(curretQuestion).getOption1());
        option2.setText(questionList.get(curretQuestion).getOption2());
        option3.setText(questionList.get(curretQuestion).getOption3());
        option4.setText(questionList.get(curretQuestion).getOption4());
    }


    private void setOptionSelected(Button optionButton){
        if (selectedAnswer.isEmpty()) {
            selectedAnswer = optionButton.getText().toString();
            optionButton.setBackgroundResource(R.drawable.incorrect_opros_button);
            optionButton.setTextColor(Color.WHITE);
            openAnswers();
            questionList.get(curretQuestion).setSelectedAnswer(selectedAnswer);
        }
    }
    private void openAnswers() {
        final String getAnswers = questionList.get(curretQuestion).getAnswer();

        Button[] buttons = {option1, option2, option3, option4};
        for (Button option : buttons) {
            if (option.getText().toString().equals(getAnswers)) {
                option.setBackgroundResource(R.drawable.correct_opros_button);
                option.setTextColor(Color.WHITE);
                break;
            }
        }
    }

    private void goToRezults(){
        Intent q = new Intent(QuizActivity.this, QuizRezults.class);
        q.putExtra("correct", correctAnswers());
        q.putExtra("incorrect", incorrectAnswers());
        q.putExtra("size",questionList.size());
        startActivity(q);
        mediaPlayer.release();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        close = true;
        startActivity(new Intent(QuizActivity.this, MenuActivity.class));
        overridePendingTransition(R.anim.anim_l, R.anim.anim);
        mediaPlayer.release();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mediaPlayer = MediaPlayer.create(QuizActivity.this, R.raw.kuss);
        mediaPlayer.setLooping(true);
        mediaPlayer.setVolume(50, 50);

    }

    @Override
    protected void onPause() {
        super.onPause();
        if(!close){
            mediaPlayer.stop();
            chronometer1.stop();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(!close){
            mediaPlayer.start();
            chronometer1.start();
        }
    }
}