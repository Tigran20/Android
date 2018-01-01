package com.example.android.quizzapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public final static String EXTRA_MESSAGE = "com.example.android.quizzapp.MESSAGE";
    private ProgressBar mProgressBar;
    private Button startButton;
    private EditText name;
    private Intent intent;
    private String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        mProgressBar = findViewById(R.id.pb_loading_indicator);

        startButton = findViewById(R.id.startButton);
        startButton.setOnClickListener(this);
    }

    @Override
    public void onClick(final View view) {
        if (view.getId() == R.id.startButton) {

            intent = new Intent(this, QuizActivity.class);

            name = findViewById(R.id.name);
            userName = name.getText().toString();
            if (userName.isEmpty()) userName = getString(R.string.username);

            intent.putExtra(EXTRA_MESSAGE, userName);
            mProgressBar.setVisibility(View.VISIBLE);
            startActivity(intent);
        }
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage(R.string.exitApp)
                .setNegativeButton(R.string.no, null)
                .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        exitFromApp();
                    }
                }).create().show();
    }

    public void exitFromApp() {
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);

    }
}