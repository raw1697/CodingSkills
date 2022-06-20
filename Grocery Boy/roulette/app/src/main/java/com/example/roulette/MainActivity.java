package com.example.roulette;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import java.util.Random;
import android.view.animation.*;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ImageView;
import android.widget.Button;
import android.view.View;
import android.preference.PreferenceManager;
import android.content.SharedPreferences;

    public class MainActivity extends AppCompatActivity {

        Button button;
        TextView textView;
        ImageView iv_wheel;

        Random r;

        int degree = 0, degree_old = 0;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            button = (Button) findViewById(R.id.button_btn);
            textView = (TextView) findViewById(R.id.textView2);
            iv_wheel = (ImageView) findViewById(R.id.iv_wheel);

            r = new Random();


            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    degree_old = degree % 360;
                    degree = r.nextInt(3600) + 720;
                    RotateAnimation rotate = new RotateAnimation(degree_old, degree,
                            RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f );
                    rotate.setDuration(3600);
                    rotate.setFillAfter(true);
                    rotate.setInterpolator(new DecelerateInterpolator());
                    rotate.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {

                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });

                    iv_wheel.startAnimation(rotate);

                }
            });



        }

    }