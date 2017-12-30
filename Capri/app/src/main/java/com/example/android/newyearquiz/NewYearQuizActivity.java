package com.example.android.newyearquiz;

import android.content.Intent;
import android.graphics.Color;
import android.provider.MediaStore;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class NewYearQuizActivity extends AppCompatActivity implements View.OnClickListener {


    private int currentQuestion = 1;

    private int totalNumberOfQuestions = 10;

    private int correct_score = 0;

    private int incorrect_score = 0;

    private TextView question_number;

    private ImageView question_image;

    private TextView ny_question;

    Button nextQuestion;
    String qnum;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ny_edittext);

        question_number = findViewById(R.id.question_number);
        question_image = findViewById(R.id.question_image);
        ny_question = findViewById(R.id.question);

        editText = (EditText) findViewById(R.id.ny_answer1);

        nextQuestion = (Button) findViewById(R.id.next_question);

        nextQuestion.setOnClickListener(this);

        Question1();
    }

    public void Question1() {
        qnum = getString(R.string.questionNumber, currentQuestion, totalNumberOfQuestions);
        question_number.setText(qnum);
    }

    public void onClick(View view) {
        if (editText.getText().toString().trim().equals("")) {
            Toast.makeText(this, R.string.not_chosen2, Toast.LENGTH_SHORT).show();
            return;
        } else if (editText.getText().toString().trim().equals("Russia")) {
            Toast.makeText(this, R.string.correctAnswer, Toast.LENGTH_SHORT).show();
            correct_score++;
        } else {
            Toast.makeText(this, R.string.wrongAnswer, Toast.LENGTH_SHORT).show();
            incorrect_score++;
        }
        currentQuestion++;
        openRBActivity();
    }

    // This method calls RadioButtonsActivity
    public void openRBActivity() {
        Intent openRBActivity = new Intent(this, RadioButtonsActivity.class);
        openRBActivity.putExtra("current_question", currentQuestion);
        openRBActivity.putExtra("correct_score", correct_score);
        openRBActivity.putExtra("incorrect_score", incorrect_score);
        openRBActivity.putExtra("total_number_of_questions", totalNumberOfQuestions);
        startActivity(openRBActivity);
    }
}
