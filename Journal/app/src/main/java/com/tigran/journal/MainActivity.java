package com.tigran.journal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String name;
    private String chemistryGrade;
    private String mathGrade;
    private String historyGrade;

    EditText nameUser;
    EditText mChemistryGrade;
    EditText mMathGrade;
    EditText mHistoryGrade;

    String nr = "NR";
    String nameEnter = "Enter your name!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void setName() {
        nameUser = (EditText) findViewById(R.id.name_user);
        if(name != null){
            name = String.valueOf(nameUser.getText());
        }
        else {
            name = nameEnter;
        }

    }

    public void setChemistryGrade() {
        mChemistryGrade = (EditText) findViewById(R.id.chemistry_grade);

        if(chemistryGrade != null){
            chemistryGrade = String.valueOf(mChemistryGrade.getText());
        }
        else {
            chemistryGrade = nr;
        }

    }

    public void setMathGrade(){
        mMathGrade = (EditText) findViewById(R.id.math_grade);

        if(mathGrade != null) {
            mathGrade = String.valueOf(mMathGrade.getText());
        }
        else {
            mathGrade = nr;
        }
    }

    public void setHistoryGrade() {
        mHistoryGrade = (EditText) findViewById(R.id.history_grade);

        if(historyGrade != null){
            historyGrade = String.valueOf(mHistoryGrade.getText());
        }
        else {
            historyGrade = nr;
        }
    }

    public void displayGrades(View v) {
        TextView textView1 = (TextView) findViewById(R.id.text_view_name);
        TextView textView = (TextView) findViewById(R.id.text_view_grade);
        setName();
        setChemistryGrade();
        setMathGrade();
        setHistoryGrade();
        textView1.setText(nameItem());
        textView.setText(valueItem());
    }


    public String nameItem(){
        return  "Name: " + "\n" +
                "Chemistry : " + "\n" +
                "Math : " + "\n" +
                "History : ";
    }

    public String valueItem(){
        return name + "\n" +
                chemistryGrade + "\n" +
                mathGrade + "\n" +
                historyGrade + "\n";

    }

}
