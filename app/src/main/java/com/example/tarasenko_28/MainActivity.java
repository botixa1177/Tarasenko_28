package com.example.tarasenko_28;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Задание 1 & 2: Анимация восхода и захода солнца
        ImageView sunImageView = findViewById(R.id.sun);
        Animation sunRiseAnimation = AnimationUtils.loadAnimation(this, R.anim.sun_rise);
        Animation sunSetAnimation = AnimationUtils.loadAnimation(this, R.anim.sun_set);

        sunRiseAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {}

            @Override
            public void onAnimationEnd(Animation animation) {
                // Заход солнца после восхода (Задание 2)
                sunImageView.startAnimation(sunSetAnimation);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {}
        });
        sunImageView.startAnimation(sunRiseAnimation);

        // Задание 1 & 2: Вращение часов (минутная стрелка)
        ImageView clockImageView = findViewById(R.id.clock);
        Animation clockTurnAnimation = AnimationUtils.loadAnimation(this, R.anim.clock_turn);
        clockImageView.startAnimation(clockTurnAnimation);

        // Задание 1 & 2: Вращение часовой стрелки с измененными позициями и скоростью
        ImageView hourImageView = findViewById(R.id.hour_hand);
        Animation hourTurnAnimation = AnimationUtils.loadAnimation(this, R.anim.hour_turn);
        hourImageView.startAnimation(hourTurnAnimation);


    }
}
