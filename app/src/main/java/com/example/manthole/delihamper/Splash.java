package com.example.manthole.delihamper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class Splash extends AppCompatActivity {

    Animation animFadeIn;
    private ImageView splashpic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        splashpic = (ImageView) findViewById(R.id.splashpic);

        FadeIntMethod();
    }

    public void FadeIntMethod() {


        animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        splashpic.startAnimation(animFadeIn);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            }
        }, 3000);


    }

}