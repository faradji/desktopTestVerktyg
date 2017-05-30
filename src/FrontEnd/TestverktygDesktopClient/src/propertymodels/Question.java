package propertymodels;

import models.*;
import java.io.Serializable;
import java.util.ArrayList;

public class Question implements Serializable {

    int id;
    String qText;
    int correctAnswer;

    private ArrayList<String> answers;

    Test test;

    public Question() {
    }

    public Question(int id, String qText, int correctAnswer, ArrayList answers) {
        this.id = id;
        this.qText = qText;
        this.correctAnswer = correctAnswer;
        this.answers = answers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getqText() {
        return qText;
    }

    public void setqText(String qText) {
        this.qText = qText;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public ArrayList getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList answers) {
        this.answers = answers;
    }

//    public Test getTest() {
//        return test;
//    }
    public void setTest(Test test) {
        this.test = test;
    }

}
