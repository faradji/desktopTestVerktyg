/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.sql.Date;

public class StudentAnswer implements Serializable
{
    int participant_Id;
    int question_Id;
    String givenAnswer;
    Date date;

    public StudentAnswer()
    {

    }

    public StudentAnswer(int participant_Id, int question_Id, String givenAnswer, Date date)
    {
        this.participant_Id = participant_Id;
        this.question_Id = question_Id;
        this.givenAnswer = givenAnswer;
        this.date = date;
    }

    public int getParticipant_Id()
    {
        return participant_Id;
    }

    public void setParticipant_Id(int participant_Id)
    {
        this.participant_Id = participant_Id;
    }

    public int getQuestion_Id()
    {
        return question_Id;
    }

    public void setQuestion_Id(int question_Id)
    {
        this.question_Id = question_Id;
    }

    public String getGivenAnswer()
    {
        return givenAnswer;
    }

    public void setGivenAnswer(String givenAnswer)
    {
        this.givenAnswer = givenAnswer;
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
