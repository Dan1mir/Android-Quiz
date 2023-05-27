package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {
    private String selectedTopic = "";

    private LinearLayout pizza;
    private LinearLayout PCs;
    private LinearLayout idk;
    private LinearLayout idk2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        pizza = findViewById(R.id.pizzaQuiz);
        PCs = findViewById(R.id.PCsQuiz);
        idk = findViewById(R.id.idkQuiz);
        idk2 = findViewById(R.id.idk2Quiz);

        final Button startButton = findViewById(R.id.startButton);
        final ImageView back = findViewById(R.id.idBack);

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.button_scale);

        pizza.setOnClickListener(view -> selectButton(pizza,"Pizza"));

        PCs.setOnClickListener(view -> selectButton(PCs,"PC"));

        idk.setOnClickListener(view -> selectButton(idk,"Burger"));

        idk2.setOnClickListener(view -> selectButton(idk2,"Я хз лол"));

        startButton.setOnClickListener(view -> {
            if(selectedTopic.isEmpty()){
                Toast.makeText(MenuActivity.this, getString(R.string.сhooseQuiz), Toast.LENGTH_SHORT).show();
            }else{
                Intent i = new Intent(MenuActivity.this, QuizActivity.class);
                i.putExtra("selectedTopic", selectedTopic);
                startActivity(i);
                overridePendingTransition(R.anim.slide, R.anim.slide_l);
            }
            startButton.startAnimation(animation);
        });

        back.setOnClickListener(view -> {
            startActivity(new Intent(MenuActivity.this, MainActivity.class));
            overridePendingTransition(R.anim.anim_l, R.anim.anim);
            back.startAnimation(animation);
        });
    }

    private void selectButton(LinearLayout button, String topic) {
        selectedTopic = topic;
        Clear();
        button.setBackgroundResource(R.drawable.selected_button);
    }

    private void Clear(){
        pizza.setBackgroundResource(R.drawable.game_button);
        PCs.setBackgroundResource(R.drawable.game_button);
        idk.setBackgroundResource(R.drawable.game_button);
        idk2.setBackgroundResource(R.drawable.game_button);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(MenuActivity.this, MainActivity.class));
        overridePendingTransition(R.anim.anim_l, R.anim.anim);
    }
}