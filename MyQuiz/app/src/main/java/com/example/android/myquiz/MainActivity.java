package com.example.android.myquiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button answer1;
    Button answer2;
    Button answer3;
    Button answer4;

    TextView question;
    TextView score;
    EditText editText;

    private Questions questions = new Questions();

    private String answer;
    private int mScore = 0;
    private int questionNumber = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        answer1 = (Button) findViewById(R.id.answer_1);
        answer2 = (Button) findViewById(R.id.answer_2);
        answer3 = (Button) findViewById(R.id.answer_3);
        answer4 = (Button) findViewById(R.id.answer_4);

        score = (TextView) findViewById(R.id.score);
        question = (TextView) findViewById(R.id.question);

        updateQuestion();

        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer1.getText() == answer) {
                    mScore++;
                    score.setText("Score: " + mScore);
                    updateQuestion();

                    if (mScore == 10) {
                        gameWin();
                    }
                } else {
                    gameOver();
                }
            }
        });

        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer2.getText() == answer) {
                    mScore++;
                    score.setText("Score: " + mScore);
                    updateQuestion();
                    if (mScore == 10) {
                        gameWin();
                    }
                } else {
                    gameOver();
                }
            }
        });

        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer3.getText() == answer) {
                    mScore++;
                    score.setText("Score: " + mScore);
                    updateQuestion();
                    if (mScore == 10) {
                        gameWin();
                    }
                } else {
                    gameOver();
                }
            }
        });

        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer4.getText() == answer) {
                    mScore++;
                    score.setText("Score: " + mScore);
                    updateQuestion();
                    if (mScore == 10) {
                        gameWin();
                    }
                } else {
                    gameOver();
                }
            }
        });

    }

    private void updateQuestion() {
        question.setText(questions.getQuestion(questionNumber));
        answer1.setText(questions.getChoice1(questionNumber));
        answer2.setText(questions.getChoice2(questionNumber));
        answer3.setText(questions.getChoice3(questionNumber));
        answer4.setText(questions.getChoice4(questionNumber));

        answer = questions.getAnswer(questionNumber);
        questionNumber++;
    }

    private void gameOver() {
        AlertDialog.Builder alertDB = new AlertDialog.Builder(MainActivity.this);
        alertDB
                .setMessage("Game over! Your score is " + mScore + " points")
                .setCancelable(false)

                .setNegativeButton("EXIT",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                .setPositiveButton("NEW GAME",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            }
                        });

        AlertDialog alertDialog = alertDB.create();
        alertDialog.show();

        Button p = alertDialog.getButton(DialogInterface.BUTTON_POSITIVE);
        p.setTextColor(Color.BLACK);

        Button n = alertDialog.getButton(DialogInterface.BUTTON_NEGATIVE);
        n.setTextColor(Color.BLACK);
    }

    private void gameWin() {
        AlertDialog.Builder alertDB = new AlertDialog.Builder(MainActivity.this);
        alertDB
                .setMessage("You win! Your score is " + mScore + " points")
                .setCancelable(false)

                .setNegativeButton("EXIT",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                .setPositiveButton("NEW GAME",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            }

                        });

        AlertDialog alertDialog = alertDB.create();
        alertDialog.show();

        Button p = alertDialog.getButton(DialogInterface.BUTTON_POSITIVE);
        p.setTextColor(Color.BLACK);

        Button n = alertDialog.getButton(DialogInterface.BUTTON_NEGATIVE);
        n.setTextColor(Color.BLACK);
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alertDB_exit = new AlertDialog.Builder(MainActivity.this);
        alertDB_exit
                .setMessage("Do you really want to quit? ?")
                .setCancelable(false)

                .setNegativeButton("Yes",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })

                .setPositiveButton("No",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                return;
                            }

                        });

        AlertDialog alertDialog_exit = alertDB_exit.create();
        alertDialog_exit.show();

        Button p = alertDialog_exit.getButton(DialogInterface.BUTTON_POSITIVE);
        p.setTextColor(Color.BLACK);

        Button n = alertDialog_exit.getButton(DialogInterface.BUTTON_NEGATIVE);
        n.setTextColor(Color.BLACK);
    }



}
