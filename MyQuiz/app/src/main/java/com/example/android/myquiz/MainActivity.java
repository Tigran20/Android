package com.example.android.myquiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    //REVU WTF? Кто удалять будет?
    //    private String[] questions = getResources().getStringArray(R.array.questions);
    //    private String[] answers = getResources().getStringArray(R.array.answers);
    //    private String[] variety = getResources().getStringArray(R.array.variety);
    //REVU private? Названия не по соглашению m....
    Button answer1;
    Button answer2;
    Button answer3;
    Button answer4;
    //REVU тоже самое^
    TextView mQuestionView;
    //Revu Названия не по соглашению m....
    TextView score;

    private Questions mQuestions = new Questions();

    private String mAnswer;
    private int mScore = 0;
    private int mQuestionNumber = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //REVU redundant casting
        score = (TextView) findViewById(R.id.score);
        mQuestionView = (TextView) findViewById(R.id.question);

        //REVU redundant casting
        answer1 = (Button) findViewById(R.id.answer_1);
        answer2 = (Button) findViewById(R.id.answer_2);
        answer3 = (Button) findViewById(R.id.answer_3);
        answer4 = (Button) findViewById(R.id.answer_4);

        updateQuestion();

        //REVU Все листенеры одинаковые. Не? Например:
//        private void checkAnswer(String actualAnswer, String expectedAnswer) {
//            if (actualAnswer.equals(expectedAnswer)) {
//                mScore++;
//                updateScore(mScore);
//                updateQuestion();
//
//                if (mScore == 10) {
//                    hideItems();
//                    gameWin();
//                }
//            } else {
//                gameOver();
//            }
//        }
        //Или свой Листенер написать

        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //REVU use .equals()
                if (answer1.getText() == mAnswer) {
                    mScore++;
                    updateScore(mScore);
                    updateQuestion();

                    if (mScore == 10) {
                        hideItems();
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
                //REVU use .equals()
                if (answer2.getText() == mAnswer) {
                    mScore++;
                    updateScore(mScore);
                    updateQuestion();
                    if (mScore == 10) {
                        hideItems();
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
                //REVU use .equals()
                if (answer3.getText() == mAnswer) {
                    mScore++;
                    updateScore(mScore);
                    updateQuestion();
                    if (mScore == 10) {
                        hideItems();
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
                //REVU use .equals()
                if (answer4.getText() == mAnswer) {
                    mScore++;
                    updateScore(mScore);
                    updateQuestion();
                    if (mScore == 10) {
                        hideItems();
                        gameWin();
                    }
                } else {
                    gameOver();
                }
            }
        });
    }

    private void updateQuestion() {
        if (mQuestionNumber < mQuestions.getLength()) {
            mQuestionView.setText(mQuestions.getQuestion(mQuestionNumber));
            answer1.setText(mQuestions.getChoice1(mQuestionNumber));
            answer2.setText(mQuestions.getChoice2(mQuestionNumber));
            answer3.setText(mQuestions.getChoice3(mQuestionNumber));
            answer4.setText(mQuestions.getChoice4(mQuestionNumber));

            mAnswer = mQuestions.getCorrectAnswer(mQuestionNumber);
            mQuestionNumber++;
        }
    }


    private void hideItems() {
        mQuestionView.setVisibility(View.INVISIBLE);
        score.setVisibility(View.INVISIBLE);
        answer1.setVisibility(View.INVISIBLE);
        answer2.setVisibility(View.INVISIBLE);
        answer3.setVisibility(View.INVISIBLE);
        answer4.setVisibility(View.INVISIBLE);
    }

    private void updateScore(int point) {
        //REVU Вот тут можно xliff спользовать
        score.setText(getString(R.string.score) + mScore);
    }

    private void gameOver() {
        AlertDialog.Builder alertDB = new AlertDialog.Builder(MainActivity.this);
        alertDB
                .setMessage(getString(R.string.game_over) + getString(R.string.your_score) + "" + mScore + " " + getString(R.string.points))
//REVU зачем перенос строки? Некрасиво
                .setCancelable(false)
//REVU тоже самое
                .setNegativeButton(R.string.exit,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                exit();
                            }
                        })
                .setPositiveButton(R.string.new_game,
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
                .setMessage(getString(R.string.game_win) + getString(R.string.your_score) + mScore + " " + getString(R.string.points))
                .setCancelable(false)

                .setNegativeButton(R.string.exit,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                exit();
                            }
                        })
                .setPositiveButton(R.string.new_game,
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
        //REVU название не по соглашению
        AlertDialog.Builder alertDB_exit = new AlertDialog.Builder(MainActivity.this);
        alertDB_exit
                .setMessage(R.string.exit_question)

                .setNegativeButton(R.string.yes,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                exit();
                            }
                        })

                .setPositiveButton(R.string.no,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //REVU Зачем?
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

    public void exit() {
        //REVU a - очень информативное название
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
    }
}
