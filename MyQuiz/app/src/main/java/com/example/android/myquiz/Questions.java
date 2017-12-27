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
        String question = mQuestionsList[a];
        return question;
    }

    public String getChoice1(int a) {
        String choice = mChoices[a][0];
        return choice;
    }

    public String getChoice2(int a) {
        String choice = mChoices[a][1];
        return choice;
    }

    public String getChoice3(int a) {
        String choice = mChoices[a][2];
        return choice;
    }

    public String getChoice4(int a) {
        String choice = mChoices[a][3];
        return choice;
    }

    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers[a];
        return answer;
    }

    public int getLength() {
        return mQuestionsList.length;
    }
}
