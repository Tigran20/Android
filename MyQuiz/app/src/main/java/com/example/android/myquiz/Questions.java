package com.example.android.myquiz;


public class Questions {

    public String[] mQuestionsList = {
            "What is the sixth planet from the sun ?",
            "The first satellite in space ?",
            "What is the first planet from the sun ?",
            "What is the hottest planet in the Solar system ?",
            "What is the second planet from the sun ?",
            "What is the official name of the planet 2003 UB313 ?",
            "Which planet is tilted on its side?",
            "What is the third planet from the sun ?",
            "Which planet has the fastest winds in the solar system? ?",
            "Which planet has the shortest day ?"
    };

    public String[][] mChoices = {
            {"Saturn", "Mars", "Venus", "Pluto"},
            {"Azur", "Sputnik I", "Asterix", "Explorer-I"},
            {"Mercury", "Earth", "Saturn", "Venus"},
            {"Mars", "Venus", "Mercury", "Saturn"},
            {"Uranus", "Earth", "Mars", "Venus"},
            {"Aida", "Eris", "Ersa", "Earth"},
            {"Uranus", "Venus", "Neptune", "Pluto"},
            {"Earth", "Venus", "Mars", "Mercury"},
            {"Saturn", "Ersa", "Uranus", "Neptune"},
            {"Jupiter", "Deimos", "IO", "Mercury"}
    };

    public String[] mCorrectAnswers = {"Saturn", "Sputnik I", "Mercury", "Venus", "Venus", "Eris", "Uranus", "Earth", "Neptune", "Jupiter"};

    public String getQuestion(int a) {
        return mQuestionsList[a];
    }

    public String getChoice1(int a) {
        return mChoices[a][0];
    }

    public String getChoice2(int a) {
        return mChoices[a][1];
    }

    public String getChoice3(int a) {
        return  mChoices[a][2];
    }

    public String getChoice4(int a) {
        return mChoices[a][3];
    }

    public String getCorrectAnswer(int a) {
        return mCorrectAnswers[a];
    }

    public int getLength() {
        return mQuestionsList.length;
    }
}
