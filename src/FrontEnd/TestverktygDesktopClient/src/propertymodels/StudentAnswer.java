/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package propertymodels;

import models.*;
import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class StudentAnswer implements Serializable
{

    IntegerProperty participant_Id;
    IntegerProperty question_Id;
    StringProperty givenAnswer;
    Date date;

    public StudentAnswer()
    {

    }

    public StudentAnswer(int participant_Id, int question_Id, String givenAnswer, Date date)
    {
        this.participant_Id = new SimpleIntegerProperty(participant_Id);
        this.question_Id = new SimpleIntegerProperty(question_Id);
        this.givenAnswer = new SimpleStringProperty(givenAnswer);
        this.date = date;
    }

    public int getParticipant_Id()
    {
        return participant_Id.get();
    }

    public void setParticipant_Id(int participant_Id)
    {
        this.participant_Id.set(participant_Id);
    }

    public int getQuestion_Id()
    {
        return question_Id.get();
    }

    public void setQuestion_Id(int question_Id)
    {
        this.question_Id.set(question_Id);
    }

    public String getGivenAnswer()
    {
        return givenAnswer.get();
    }

    public void setGivenAnswer(String givenAnswer)
    {
        this.givenAnswer.set(givenAnswer);
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

}
