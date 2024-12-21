package com.example.que_1;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View box = findViewById(R.id.box);
        Button buttonUp = findViewById(R.id.buttonUp);
        Button buttonDown = findViewById(R.id.buttonDown);
        Button buttonLeft = findViewById(R.id.buttonLeft);
        Button buttonRight = findViewById(R.id.buttonRight);

        // Load animations
        Animation flipUp = AnimationUtils.loadAnimation(this, R.anim.flip_up);
        Animation flipDown = AnimationUtils.loadAnimation(this, R.anim.flip_down);
        Animation flipLeft = AnimationUtils.loadAnimation(this, R.anim.flip_left);
        Animation flipRight = AnimationUtils.loadAnimation(this, R.anim.flip_right);

        buttonUp.setOnClickListener(v -> box.startAnimation(flipUp));
        buttonDown.setOnClickListener(v -> box.startAnimation(flipDown));
        buttonLeft.setOnClickListener(v -> box.startAnimation(flipLeft));
        buttonRight.setOnClickListener(v -> box.startAnimation(flipRight));
    }
}
