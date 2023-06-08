package com.example.quizbee.questions;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.quizbee.OnItemActionListener;
import com.example.quizbee.databinding.QuestionsItemBinding;
import com.example.quizbee.model.Questions;

import java.util.List;

public class QuestionsAdapter extends RecyclerView.Adapter<QuestionViewHolder> {

    private List<Questions> quizBees;

    private OnItemActionListener onItemActionListener;

    public int currentQuestionPosition = 0;

    void setData(List<Questions> quizBees) {
        this.quizBees = quizBees;
        notifyDataSetChanged();
    }

    void setOnItemActionListener(OnItemActionListener onItemActionListener) {
        this.onItemActionListener = onItemActionListener;
    }

    @NonNull
    @Override
    public QuestionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        QuestionsItemBinding questionsItemBinding = QuestionsItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        QuestionViewHolder questionViewHolder = new QuestionViewHolder(questionsItemBinding);
        return questionViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Questions question = quizBees.get(position);
        holder.questionsItemBinding.questionsCountTxt.setText(String.valueOf(question.getNumber()));
        holder.questionsItemBinding.getRoot().setOnClickListener(v -> {
            currentQuestionPosition = position;
            notifyDataSetChanged();
            onItemActionListener.onClick(question);
        });
        if (currentQuestionPosition == position) {
            holder.questionsItemBinding.questionsCountTxt.setTextColor(Color.parseColor("#D61D1D"));
        } else {
            holder.questionsItemBinding.questionsCountTxt.setTextColor(Color.parseColor("#050505"));

        }
    }

    @Override
    public int getItemCount() {
        return quizBees.size();
    }
}
