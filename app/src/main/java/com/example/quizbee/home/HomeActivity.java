package com.example.quizbee.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.quizbee.questions.QuestionsActivity;
import com.example.quizbee.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("Home");
        startButton();
    }

    private void startButton() {
        binding.startBtn.setOnClickListener(v -> {
            Intent intent = new Intent(this, QuestionsActivity.class);
            startActivity(intent);
        });
    }
}