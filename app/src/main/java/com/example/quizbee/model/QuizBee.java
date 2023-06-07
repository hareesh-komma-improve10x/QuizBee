package com.example.quizbee.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class QuizBee {
    @SerializedName("_id")
    private String id;

    @SerializedName("module")
    public Module module;

    @SerializedName("questions")
    public ArrayList<Questions> questions;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public ArrayList<Questions> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Questions> questions) {
        this.questions = questions;
    }

}
