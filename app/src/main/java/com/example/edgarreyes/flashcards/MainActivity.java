package com.example.edgarreyes.flashcards;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.FlashCardAnswer1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.FlashCardAnswer1).setBackgroundColor(
                    getResources().getColor(android.R.color.holo_red_light));
                findViewById(R.id.FlashCardAnswer2).setBackgroundColor(
                        getResources().getColor(android.R.color.holo_green_light));
            }
        });
        findViewById(R.id.FlashCardAnswer2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.FlashCardAnswer2).setBackgroundColor(
                        getResources().getColor(android.R.color.holo_green_light));
            }
        });
        findViewById(R.id.FlashCardAnswer3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.FlashCardAnswer3).setBackgroundColor(
                        getResources().getColor(android.R.color.holo_red_light));
                findViewById(R.id.FlashCardAnswer2).setBackgroundColor(
                        getResources().getColor(android.R.color.holo_green_light));
            }
        });
        findViewById(R.id.rootView).setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v) {
               findViewById(R.id.FlashCardAnswer1).setBackgroundColor(
                       getResources().getColor(R.color.originalColor));
               findViewById(R.id.FlashCardAnswer2).setBackgroundColor(
                       getResources().getColor(R.color.originalColor));
               findViewById(R.id.FlashCardAnswer3).setBackgroundColor(
                       getResources().getColor(R.color.originalColor));
           }
        });
        findViewById(R.id.toggle_choices_visibility).setOnClickListener(new View.OnClickListener() {
            boolean isShowingAnswers = true;
            @Override
            public void onClick(View v) {
                if (isShowingAnswers) {
                    findViewById(R.id.FlashCardAnswer1).setVisibility(View.INVISIBLE);
                    findViewById(R.id.FlashCardAnswer2).setVisibility(View.INVISIBLE);
                    findViewById(R.id.FlashCardAnswer3).setVisibility(View.INVISIBLE);
                    isShowingAnswers = false;
                } else if (!isShowingAnswers) {
                    findViewById(R.id.FlashCardAnswer1).setVisibility(View.VISIBLE);
                    findViewById(R.id.FlashCardAnswer2).setVisibility(View.VISIBLE);
                    findViewById(R.id.FlashCardAnswer3).setVisibility(View.VISIBLE);
                    isShowingAnswers = true;
                }
            }
        });
    }
}
