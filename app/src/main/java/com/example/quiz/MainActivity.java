package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

private ImageView id_start;
private ImageView id_exit;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_mainmenu);
        ConstraintLayout ConstraintLayout = findViewById(R.id.mainLayout);
        AnimationDrawable fon = (AnimationDrawable) ConstraintLayout.getBackground();
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.button_scale);
        fon.setEnterFadeDuration(2500);
        fon.setExitFadeDuration(5000);
        fon.start();


        id_start = findViewById(R.id.idStart);
        id_exit = findViewById(R.id.idExit);
        TextView version = findViewById(R.id.version);

        String versionName = "";
        try {
            PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            versionName = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e){
            e.printStackTrace();
        }

        version.setText(getString(R.string.version) + versionName);

        id_start.setOnClickListener(view -> {
            id_start.postDelayed(mLaunchTask,300);
            overridePendingTransition(R.anim.slide, R.anim.slide_l);
            id_start.startAnimation(animation);
        });

        id_exit.setOnClickListener(view -> {
            MainActivity.this.finishAffinity();
            id_exit.startAnimation(animation);
        });

    }
    private final Runnable mLaunchTask = () -> {
        Intent i = new Intent(MainActivity.this, MenuActivity.class);
        startActivity(i);
    };
}