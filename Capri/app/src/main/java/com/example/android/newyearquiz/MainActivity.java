package com.example.android.newyearquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.android.newyearquiz.MESSAGE";

    private EditText nameField;
    private String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void openNYQuiz(View view) {
        Intent openNYQuiz = new Intent(this, NewYearQuizActivity.class);

        nameField = (EditText) findViewById(R.id.name);
        message = nameField.getText().toString().trim();

        openNYQuiz.putExtra(EXTRA_MESSAGE, message);
        startActivity(openNYQuiz);
    }


}