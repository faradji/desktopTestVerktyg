package com.mycompany.testverktygdesktop.models;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.Type;

@Entity

public class Question implements Serializable {

    @Id
    @GeneratedValue
    int id;
    String qText;
    int correctAnswer;
<<<<<<< HEAD

    int[] answers;

=======
    
    @Type(type="com.mycompany.testverktygdesktop.services.QuestionService")
    @Column(name = "answers")
    private ArrayList<String> answers;
    
>>>>>>> magnus
    @ManyToOne
    @JsonBackReference
    @JsonIgnore
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
