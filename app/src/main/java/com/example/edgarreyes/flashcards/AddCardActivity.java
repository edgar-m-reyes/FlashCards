package com.example.edgarreyes.flashcards;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);
        String s1 = getIntent().getStringExtra("stringKey");
        String s2 = getIntent().getStringExtra("stringKey1");
        String s3 = getIntent().getStringExtra("stringKey2");
        String s4 = getIntent().getStringExtra("stringKey3");
        ((TextView) findViewById(R.id.insertQuestion)).setText(s1);
        ((TextView) findViewById(R.id.insertAnswer1)).setText(s2);
        ((TextView) findViewById(R.id.insertAnswer2)).setText(s3);
        ((TextView) findViewById(R.id.insertAnswer3)).setText(s4);
        findViewById(R.id.archiveQuestAns).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Question = ((EditText) findViewById(R.id.insertQuestion)).getText().toString();
                String Answer1 = ((EditText) findViewById(R.id.insertAnswer1)).getText().toString();
                String Answer2 = ((EditText) findViewById(R.id.insertAnswer2)).getText().toString();
                String Answer3 = ((EditText) findViewById(R.id.insertAnswer3)).getText().toString();
                Intent data = new Intent();
                data.putExtra("QuestionString", Question);
                data.putExtra("AnswerString1", Answer1);
                data.putExtra("AnswerString2", Answer2);
                data.putExtra("AnswerString3", Answer3);
                setResult(RESULT_OK, data);
                if (Question.length() > 0 && Answer1.length() > 0 && Answer2.length() > 0 && Answer3.length() > 0) {
                    finish();
                }
                else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Must enter question and all answers!", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                    toast.show();
                }
            }
        });
        findViewById(R.id.exitButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
