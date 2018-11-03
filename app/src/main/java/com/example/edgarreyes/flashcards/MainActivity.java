package com.example.edgarreyes.flashcards;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

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
        findViewById(R.id.addButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , AddCardActivity.class);
                String ques = ((TextView) findViewById(R.id.FlashCardQuestion)).getText().toString();
                String ans1 = ((TextView) findViewById(R.id.FlashCardAnswer1)).getText().toString();
                String ans2 = ((TextView) findViewById(R.id.FlashCardAnswer2)).getText().toString();
                String ans3 = ((TextView) findViewById(R.id.FlashCardAnswer3)).getText().toString();
                intent.putExtra("stringKey", ques);
                intent.putExtra("stringKey1", ans1);
                intent.putExtra("stringKey2", ans2);
                intent.putExtra("stringKey3", ans3);
                MainActivity.this.startActivityForResult(intent, 100);
            }
        });
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == 100 && data!= null) {
            String string1 = data.getExtras().getString("QuestionString");
            String string2 = data.getExtras().getString("AnswerString1");
            String string3 = data.getExtras().getString("AnswerString2");
            String string4 = data.getExtras().getString("AnswerString3");
            ((TextView) findViewById(R.id.FlashCardQuestion)).setText(string1);
            ((TextView) findViewById(R.id.FlashCardAnswer1)).setText(string2);
            ((TextView) findViewById(R.id.FlashCardAnswer2)).setText(string3);
            ((TextView) findViewById(R.id.FlashCardAnswer3)).setText(string4);
        }
    }
}
