package com.example.quizbee.questions;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizbee.databinding.QuestionsItemBinding;

public class QuestionViewHolder extends RecyclerView.ViewHolder {
    QuestionsItemBinding questionsItemBinding;

    public QuestionViewHolder(QuestionsItemBinding questionsItemBinding) {
        super(questionsItemBinding.getRoot());
        this.questionsItemBinding = questionsItemBinding;
    }
}
