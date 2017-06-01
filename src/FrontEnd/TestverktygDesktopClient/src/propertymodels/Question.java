package propertymodels;

import java.util.ArrayList;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Question{

    String imageURL;
    IntegerProperty id;
    StringProperty qText;
    IntegerProperty correctAnswer;
    IntegerProperty test_Id;

    private ArrayList<String> answers;

    Test test;

    public Question() {
    }

    public Question(int id, String qText, int correctAnswer, ArrayList answers, int test_Id) {
        this.id = new SimpleIntegerProperty(id);
        this.qText = new SimpleStringProperty(qText);
        this.correctAnswer = new SimpleIntegerProperty(correctAnswer);
        this.answers = answers;
        this.test_Id = new SimpleIntegerProperty(test_Id);
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

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public ArrayList getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList answers) {
        this.answers = answers;
    }

    public int getTest_Id() {
        return test_Id.get();
    }
    public void setTest_Id(int test_Id) {
        this.test_Id.set(test_Id);
    }
    
    public Test getTest() {
        return test;
    }
    public void setTest(Test test) {
        this.test = test;
    }

}
