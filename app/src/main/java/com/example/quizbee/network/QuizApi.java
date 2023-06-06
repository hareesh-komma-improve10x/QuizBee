package com.example.quizbee.network;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class QuizApi {
    public QuizApiService createQuizApiService() {
        /*HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();*/

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://crudcrud.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        QuizApiService quizApiService = retrofit.create(QuizApiService.class);
        return quizApiService;
    }
}
