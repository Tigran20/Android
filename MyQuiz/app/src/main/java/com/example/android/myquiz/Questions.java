package com.example.android.myquiz;


public class Questions {

    public String[] questionsList = {
            "What is the sixth planet from the sun",
            "What is the second planet from the sun",
            "What is the first planet from the sun",
            "What is the third planet from the sun",
            ""
    };

    public String[][] allChoice = {
            {"Saturn", "Mars", "Venus", "Pluto"},
            {"Mercury", "Earth", "Saturn", "Venus"},
            {"Pluto", "Earth", "Saturn", "Mercury"},
            {"Earth", "Venus", "Mars", "Mercury"},
            {"", "", "", ""},
    };

    public String[] correctAnswers = {"Saturn", "Venus", "Mercury", "Earth", ""};

    public String getQuestion(int a) {
        String questionList = questionsList[a];
        return questionList;
    }

    public String getChoice1(int a) {
        String choice = allChoice[a][0];
        return choice;
    }

    public String getChoice2(int a) {
        String choice = allChoice[a][1];
        return choice;
    }

    public String getChoice3(int a) {
        String choice = allChoice[a][2];
        return choice;
    }

    public String getChoice4(int a) {
        String choice = allChoice[a][3];
        return choice;
    }

    public String getAnswer(int a) {
        String answer = correctAnswers[a];
        return answer;
    }
}
