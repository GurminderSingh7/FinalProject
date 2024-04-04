package com.cuoiky.andoid.dictionaryapp.ui.main;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.cuoiky.andoid.dictionaryapp.R;
import com.cuoiky.andoid.dictionaryapp.data.model.wordquiz.Quiz;
import com.cuoiky.andoid.dictionaryapp.data.model.wordquiz.WordQuiz;
import com.cuoiky.andoid.dictionaryapp.databinding.ActivityQuizBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;

import java.util.List;
import java.util.Locale;

/**
 * Activity for conducting quizzes.
 *
 * <p>This activity displays quiz questions and options to the user, allows them to select an option,
 * and provides feedback on their answers. After completing the quiz, it displays the user's score
 * and allows them to reset the quiz.</p>
 *
 * <p>Author: Gurminder Singh Badwal</p>
 * <p>Lab Section: 012</p>
 * <p>Creation Date: 4th of April 2024</p>
 */
public class QuizActivity extends AppCompatActivity {
    private ActivityQuizBinding binding;
    private final String TAG = "QuizActivity";
    int currentQuizIndex = 0;
    int totalQuiz;
    int score = 0;
    private WordQuiz mQuiz;
    private List<Quiz> quizList;
    private List<String> quizzes;
    Snackbar snack;
    private List<String> options;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuizBinding.inflate(getLayoutInflater());
        View viewRoot = binding.getRoot();
        setContentView(viewRoot);
        try {
            initValues();
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
    }

    /**
     * Initialize the quiz values.
     */
    void initValues() {
        Gson gson = new Gson();
        Intent i = getIntent();
        mQuiz = gson.fromJson(i.getStringExtra("quiz"), WordQuiz.class);
        quizList = mQuiz.getQuizList();
        totalQuiz = quizList.size();
        loadNewQuiz();
        binding.btnOpt1.setOnClickListener(view -> checkAnswer(binding.btnOpt1));
        binding.btnOpt2.setOnClickListener(view -> checkAnswer(binding.btnOpt2));
        binding.btnNext.setOnClickListener(view -> {
            if (isCorrect) {
                score++;
            }
            currentQuizIndex++;
            loadNewQuiz();
        });
        snack = Snackbar.make(binding.getRoot(), "", Snackbar.LENGTH_SHORT);
    }

    /**
     * Check the answer selected by the user.
     *
     * @param view The view corresponding to the selected option.
     */
    void checkAnswer(View view) {
        MaterialButton btn = (MaterialButton) view;
        String selected = btn.getText().toString().toLowerCase(Locale.ROOT);
        int correct = quizList.get(currentQuizIndex).getCorrect();
        String answer = options.get(correct - 1).toLowerCase(Locale.ROOT);
        if (selected.equals(answer)) {
            isCorrect = true;
            btn.setBackgroundColor(getResources().getColor(R.color.success));
        } else {
            isCorrect = false;
            btn.setBackgroundColor(getResources().getColor(R.color.danger));
        }
        btn.setTextColor(Color.WHITE);
        binding.btnOpt1.setEnabled(false);
        binding.btnOpt2.setEnabled(false);
    }

    /**
     * Load a new quiz question and options.
     */
    void loadNewQuiz() {
        if (currentQuizIndex == totalQuiz) {
            finishQuiz();
            return;
        }
        String count = (currentQuizIndex + 1) + "/" + totalQuiz;
        binding.tvCount.setText(count);
        quizzes = quizList.get(currentQuizIndex).getQuiz();
        options = quizList.get(currentQuizIndex).getOption();
        binding.btnOpt1.setTextColor(Color.BLACK);
        binding.btnOpt1.setBackgroundColor(Color.WHITE);
        binding.btnOpt2.setTextColor(Color.BLACK);
        binding.btnOpt2.setBackgroundColor(Color.WHITE);
        binding.tvQuiz1.setText(quizzes.get(0));
        binding.tvQuiz2.setText(quizzes.get(1));
        binding.tvQuiz3.setText(quizzes.get(2));
        binding.btnOpt1.setText(options.get(0));
        binding.btnOpt2.setText(options.get(1));
        binding.btnOpt1.setEnabled(true);
        binding.btnOpt2.setEnabled(true);
    }

    /**
     * Finish the quiz and display the user's score.
     */
    void finishQuiz() {
        snack.setText("Your results: " + score + " out of " + totalQuiz);
        snack.show();
    }

    /**
     * Reset the quiz.
     */
    void resetQuiz() {
        this.finish();
    }

    Boolean isCorrect = false;
}
