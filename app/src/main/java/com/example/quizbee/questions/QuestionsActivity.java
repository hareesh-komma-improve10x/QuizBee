package com.example.quizbee.questions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.quizbee.OnItemActionListener;
import com.example.quizbee.ResultActivity;
import com.example.quizbee.databinding.ActivityQuestionsBinding;
import com.example.quizbee.model.Questions;
import com.example.quizbee.model.QuizBee;
import com.example.quizbee.network.QuizApi;
import com.example.quizbee.network.QuizApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuestionsActivity extends AppCompatActivity {

    private ActivityQuestionsBinding questionsBinding;

    private List<Questions> questions = new ArrayList<>();

    private QuestionsAdapter questionsAdapter;

    private QuizApi quizApi;

    private QuizApiService quizApiService;

    private int currentQuestionNum = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        questionsBinding = ActivityQuestionsBinding.inflate(getLayoutInflater());
        setContentView(questionsBinding.getRoot());
        getSupportActionBar().setTitle("Questions");
        setupApi();
        fetchData();
        setupAdapter();
        setupRv();
        showProgressBar();
        hideProgressBar();
        showNextBtn();
    }

    private void showNextBtn() {
        questionsBinding.nextBtn.setOnClickListener(v -> {
            currentQuestionNum++;
            Questions question = questions.get(currentQuestionNum-1);
            questionData(question);
        });
    }

    private void hideProgressBar() {
        questionsBinding.progressBar.setVisibility(View.GONE);
    }

    private void showProgressBar() {
        questionsBinding.progressBar.setVisibility(View.VISIBLE);
    }

    private void questionData(Questions question) {
        questionsBinding.questionTxt.setText(question.getQuestion());
        questionsBinding.radioOneRb.setText(question.getAnswers().get(0));
        questionsBinding.radioTwoRb.setText(question.getAnswers().get(1));
        questionsBinding.radioThreeRb.setText(question.getAnswers().get(2));
        questionsBinding.radioFourRb.setText(question.getAnswers().get(3));
    }

    private void fetchData() {
        showProgressBar();
        Call<List<QuizBee>> call = quizApiService.getItems();
        call.enqueue(new Callback<List<QuizBee>>() {
            @Override
            public void onResponse(Call<List<QuizBee>> call, Response<List<QuizBee>> response) {
                hideProgressBar();
                List<QuizBee> quizBeeList = response.body();
                questionsAdapter.setData(quizBeeList.get(0).getQuestions());
                questions = quizBeeList.get(0).getQuestions();
                questionData(questions.get(0));
                Toast.makeText(QuestionsActivity.this, "Successfully Load Data", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<QuizBee>> call, Throwable t) {
                hideProgressBar();
                Toast.makeText(QuestionsActivity.this, "Failed to Load Data", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void setupApi() {
        quizApi = new QuizApi();
        quizApiService = quizApi.createQuizApiService();
    }

    private void setupAdapter() {
        questionsAdapter = new QuestionsAdapter();
        questionsAdapter.setData(questions);
        questionsAdapter.setOnItemActionListener(new OnItemActionListener() {
            @Override
            public void onClick(Questions question) {
                questionData(question);
                showNextBtn();
            }
        });
    }

    private void setupRv() {
        questionsBinding.questionsRv.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        questionsBinding.questionsRv.setAdapter(questionsAdapter);
    }
}