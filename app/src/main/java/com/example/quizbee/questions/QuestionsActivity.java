package com.example.quizbee.questions;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.quizbee.R;

public class QuestionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        getSupportActionBar().setTitle("Questions");
    }
}