package propertymodels;

import java.util.ArrayList;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Question{

    IntegerProperty id;
    StringProperty qText;
    IntegerProperty correctAnswer;

    private ArrayList<String> answers;

    Test test;

    public Question() {
    }

    public Question(int id, String qText, int correctAnswer, ArrayList answers) {
        this.id = new SimpleIntegerProperty(id);
        this.qText = new SimpleStringProperty(qText);
        this.correctAnswer = new SimpleIntegerProperty(correctAnswer);
        this.answers = answers;
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getqText() {
        return qText.get();
    }

    public void setqText(String qText) {
        this.qText.set(qText);
    }

    public int getCorrectAnswer() {
        return correctAnswer.get();
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer.set(correctAnswer);
    }

    public ArrayList getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList answers) {
        this.answers = answers;
    }

    public Test getTest() {
        return test;
    }
    public void setTest(Test test) {
        this.test = test;
    }

}
