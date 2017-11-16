package com.alextroy.basketballcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreTeamA = 0;
    int scoreTeamB = 0;

    EditText nameTeamA = null;
    EditText nameTeamB = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addThreeForTeamA(View v) {
        scoreTeamA = scoreTeamA + 3;
        displayForTeamA(scoreTeamA);
    }

    public void addTwoForTeamA(View v) {
        scoreTeamA = scoreTeamA + 2;
        displayForTeamA(scoreTeamA);
    }

    public void addOneForTeamA(View v) {
        scoreTeamA = scoreTeamA + 1;
        displayForTeamA(scoreTeamA);
    }

    public void addThreeForTeamB(View v) {
        scoreTeamB = scoreTeamB + 3;
        displayForTeamB(scoreTeamB);
    }

    public void addTwoForTeamB(View v) {
        scoreTeamB = scoreTeamB + 2;
        displayForTeamB(scoreTeamB);
    }

    public void addOneForTeamB(View v) {
        scoreTeamB = scoreTeamB + 1;
        displayForTeamB(scoreTeamB);
    }

    public void resetScore(View v) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        findViewById(R.id.team_winner).setVisibility(View.INVISIBLE);
    }

    public void winner (View v){
        TextView winnerTeam = (TextView) findViewById(R.id.team_winner);

        nameTeamA = findViewById(R.id.name_team_a);
        nameTeamB = findViewById(R.id.name_team_b);

        String nameA = String.valueOf(nameTeamA.getText());
        String nameB = String.valueOf(nameTeamB.getText());

        if (scoreTeamB > scoreTeamA) {
            winnerTeam.setText("Team " + nameB + " win!");
            findViewById(R.id.team_winner).setVisibility(View.VISIBLE);
        }
        if (scoreTeamB < scoreTeamA) {
            winnerTeam.setText("Team " + nameA + " win!");
            findViewById(R.id.team_winner).setVisibility(View.VISIBLE);
        }
        if (scoreTeamA == scoreTeamB) {
            winnerTeam.setText(R.string.draw);
            findViewById(R.id.team_winner).setVisibility(View.VISIBLE);
        }
    }

    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }




}
