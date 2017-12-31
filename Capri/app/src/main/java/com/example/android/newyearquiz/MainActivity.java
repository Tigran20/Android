package com.example.android.newyearquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private int currentQuestion = 1;
    private int totalNumberOfQuestions = 3;

    private TextView question_number;
    private TextView ny_question;
    private TextView ny_answer;

    private ImageView question_image;

    private RadioButton answer1;
    private RadioButton answer2;
    private RadioButton answer3;
    private RadioButton answer4;

    private Button nextQuestion;

    private String qnum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_year_quiz);

        question_number = findViewById(R.id.question_number);
        question_image = findViewById(R.id.question_image);
        ny_question = findViewById(R.id.question);

        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        answer3 = findViewById(R.id.answer3);
        answer4 = findViewById(R.id.answer4);

        ny_answer = findViewById(R.id.answer);

        nextQuestion = (Button) findViewById(R.id.next_question);
        nextQuestion.setOnClickListener(this);
    }

    public void Question1() {
        qnum = getString(R.string.questionNumber, currentQuestion, totalNumberOfQuestions);

        question_number.setText(qnum);
        question_image.setImageResource(R.drawable.question31img);
        ny_question.setText(R.string.ny_question_1);
        ny_answer.setText(R.string.ny_answer_1);
    }

    public void Question2() {
        qnum = getString(R.string.questionNumber, currentQuestion, totalNumberOfQuestions);
        question_number.setText(qnum);
        question_image.setImageResource(R.drawable.question31img);
        ny_question.setText(R.string.ny_question_2);
        ny_answer.setText(R.string.ny_answer_2);
    }

    public void Question3() {
        qnum = getString(R.string.questionNumber, currentQuestion, totalNumberOfQuestions);
        question_number.setText(qnum);
        question_image.setImageResource(R.drawable.question31img);
        ny_question.setText(R.string.ny_question_3);
        ny_answer.setText(R.string.ny_answer_3);
    }


    public void onClick(View view) {
        currentQuestion++;

        switch (currentQuestion) {
            case 1:
                Question1();
                break;
            case 2:
                Question2();
                break;
            case 3:
                Question3();
                break;
        }
    }
}



