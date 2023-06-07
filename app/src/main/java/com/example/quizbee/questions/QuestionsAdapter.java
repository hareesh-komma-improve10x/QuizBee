package com.example.quizbee.questions;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.quizbee.OnItemActionListener;
import com.example.quizbee.databinding.QuestionsItemBinding;
import com.example.quizbee.model.Questions;
import com.example.quizbee.model.QuizBee;

import java.util.List;

public class QuestionsAdapter extends RecyclerView.Adapter<QuestionViewHolder> {

    private List<Questions> quizBees;

    private OnItemActionListener onItemActionListener;

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
    public void onBindViewHolder(@NonNull QuestionViewHolder holder, int position) {
        Questions question = quizBees.get(position);
        holder.questionsItemBinding.questionsCountTxt.setText(String.valueOf(question.getNumber()));
        holder.questionsItemBinding.getRoot().setOnClickListener(v -> {
            onItemActionListener.onClick(question);
        });
    }

    @Override
    public int getItemCount() {
        return quizBees.size();
    }
}
