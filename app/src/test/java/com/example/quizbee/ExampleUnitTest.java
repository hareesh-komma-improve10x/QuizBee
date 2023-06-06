package com.example.quizbee;

import org.junit.Test;

import static org.junit.Assert.*;

import com.example.quizbee.model.QuizBee;
import com.example.quizbee.network.QuizApi;
import com.example.quizbee.network.QuizApiService;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);

    }
    @Test
    public void getQuizBee() throws IOException {
        QuizApi quizApi = new QuizApi();
        QuizApiService shopsApiService = quizApi.createQuizApiService();
        Call<List<QuizBee>> call = shopsApiService.getItems();
        List<QuizBee> quizBees = call.execute().body();
        assertNotNull(quizBees);
        assertFalse(quizBees.isEmpty());
        System.out.println(new Gson().toJson(quizBees));
    }
}